package com.ahmed.gamal.matchatak.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ahmed.gamal.matchatak.model.Team;

import java.util.List;

@Dao
public interface TeamsDao {

    @Query("SELECT * FROM teams")
    LiveData<List<Team>> getTeams();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovie(Team team);

}
