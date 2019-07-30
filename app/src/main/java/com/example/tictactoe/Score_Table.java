package com.example.tictactoe;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Score_Table {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }



    @PrimaryKey
    @NonNull
    private String name;

    private int won;
    private int lost;

}
