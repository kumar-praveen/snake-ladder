package org.example;

public abstract class SpecialEntity {

    private final int start;
    private final int end;

    public SpecialEntity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getActionPosition() {
        return this.start;
    }

    public int getEndPosition() {
        return this.end;
    }
}
