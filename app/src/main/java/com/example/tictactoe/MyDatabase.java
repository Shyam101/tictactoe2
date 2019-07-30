package com.example.tictactoe;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {History_table.class,Score_Table.class},version = 1,exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {

    public abstract MyDao myDao();
}
