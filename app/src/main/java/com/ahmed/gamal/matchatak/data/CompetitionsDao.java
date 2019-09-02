package com.ahmed.gamal.matchatak.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ahmed.gamal.matchatak.model.Competition;

import java.util.List;

@Dao
public interface CompetitionsDao {

    @Query("SELECT * FROM competitions")
    LiveData<List<Competition>> getCompetitions();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovie(Competition competition);

}
