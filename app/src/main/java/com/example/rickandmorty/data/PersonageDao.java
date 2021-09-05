package com.example.rickandmorty.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.rickandmorty.pojo.Personage;

import java.util.List;

@Dao
public interface PersonageDao {
    @Query("SELECT * FROM personages" )
    LiveData<List<Personage>> getAllPersonages();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPersonages(List<Personage> personages);


    @Query("DELETE FROM personages")
    void deleteAllPersonages();


}
