package org.example;

import java.util.LinkedList;

public class Game {
    private GameStatus status;
    private final LinkedList<Player> players;
    private final Board board;
    private final Dice dice;

    public Game(LinkedList<Player> players, Board board, Dice dice){
        this.status = GameStatus.NOT_STARTED;
        this.players = players;
        this.board = board;
        this.dice = dice;
    }

    public void addPlayer(Player player){
        if(status != GameStatus.NOT_STARTED){
            System.out.println("Game Already started....");
            return;
        }
        players.add(player);
    }

    public void start(){
        status = GameStatus.STARTED;
        while(players.size() > 1){
            Player player = players.pollFirst();

            System.out.println(player.getName()+" turns !!");
            Integer nextPos = getNextPosition(player);
            if(hasReachedEnd(nextPos)){
                System.out.println("Reached End , Hurray !!");
            }else{
                player.setPosition(nextPos);
                players.add(player);
                System.out.println("Moved to: "+nextPos);
                System.out.println("--------------------------------------");
            }
        }

        status = GameStatus.ENDED;
        System.out.println("Game Finished....");
        Player last = players.getLast();
        System.out.println(last.getName()+" lost the game !!");
    }

    public Integer getNextPosition(Player player){
        Integer currPos = player.getPosition();
        Integer diceVal = dice.getNumber();
        Integer nextPos = currPos + diceVal;
        System.out.println("Current position: "+currPos);
        System.out.println("Dice Value: "+diceVal);

        if(!board.isWithinBoard(nextPos)) return currPos;
        return board.getEndPosition(nextPos);
    }

    public Boolean hasReachedEnd(Integer pos){
        return board.getMaxValue().equals(pos);
    }
}
