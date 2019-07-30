package com.example.tictactoe;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void addHistory(History_table history_table);

    @Insert
    public void addScore(Score_Table scoreTable);

    @Query("select * from History_table")
    public List<History_table> readHistory();

    @Query("select * from Score_Table")
    public List<Score_Table> readScore();
}
