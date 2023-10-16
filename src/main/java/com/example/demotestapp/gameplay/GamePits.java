package com.example.demotestapp.gameplay;

public class GamePits {

    private int stones;
    private final boolean isPlayer;

    public boolean isPlayer() {
        return isPlayer;
    }

    public int getStones() {
        return stones;
    }

    public void setStones(int stones) {
        this.stones = stones;
    }

    public GamePits(boolean isPlayer){
        this.stones = 6; //Stones allocated for each pit
        this.isPlayer = isPlayer;
    }

    public void addStones(int count){
        stones += count;
    }
}
