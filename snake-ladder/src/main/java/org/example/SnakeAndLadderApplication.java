package org.example;

import java.util.LinkedList;
import java.util.List;

public class SnakeAndLadderApplication {
    public static void main(String[] args) {
        System.out.println("Welcome To Ludo");
        Dice dice = new Dice(6);

        SpecialEntity s1 = new Snake(4,1);
        SpecialEntity s2 = new Snake(10,6);
        SpecialEntity l1 = new Ladder(2,12);
        SpecialEntity l2 = new Ladder(7,8);

        List<SpecialEntity> specialEntities = List.of(s1,s2,l1,l2);

        Board board = new Board(4,specialEntities);

        Player p1 = new Player( "Praveen");
        Player p2 = new Player("Asha");
        LinkedList<Player> players = new LinkedList<>();
        players.add(p1);
        players.add(p2);

        Game game = new Game(players, board, dice);
        game.start();
    }
}