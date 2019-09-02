package com.ahmed.gamal.matchatak.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.ahmed.gamal.matchatak.model.Competition;
import com.ahmed.gamal.matchatak.model.Team;

@Database(entities = {Competition.class, Team.class}, exportSchema = false,version = 1 )

@TypeConverters({AreaConverter.class})
public abstract class MDataBase extends RoomDatabase {


    private static volatile  MDataBase sInstance;

    private static final String DATABASE_NAME = "competitions-db";

    public abstract CompetitionsDao competitionsDao();
    public abstract TeamsDao teamsDao();

    public static synchronized MDataBase getInstance(final Context context) {
        if (sInstance == null) {
            synchronized (MDataBase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context, MDataBase.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return sInstance;
    }



}
