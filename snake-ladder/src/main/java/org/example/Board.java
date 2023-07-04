package org.example;

import java.util.HashMap;
import java.util.List;

public class Board {
    private final Integer maxVal;
    private final HashMap<Integer, SpecialEntity> specialPosition;
    public Board(Integer size, List<SpecialEntity> specialPos){
        this.maxVal = size*size;
        this.specialPosition = new HashMap<>();
        for(SpecialEntity entity : specialPos){
            specialPosition.put(entity.getActionPosition(),entity);
        }
    }
    public Integer getMaxValue(){
        return this.maxVal;
    }

    public Boolean isSpecialPosition(Integer pos){
        return specialPosition.containsKey(pos);
    }

    public Integer getEndPosition(Integer pos){
        if(!isSpecialPosition(pos)){
            return pos;
        }
        return specialPosition.get(pos).getEndPosition();
    }

    public Boolean isWithinBoard(Integer pos){
        return pos <= maxVal;
    }

}
