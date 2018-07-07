package com.c1ctech.pagingexampleusingroom.db.dao;


import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.c1ctech.pagingexampleusingroom.Country;

import java.util.List;

@Dao
public interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertCountriesList(List<Country> countries);

    @Query("SELECT * FROM COUNTRIES")
    public abstract DataSource.Factory<Integer,Country> getCountries();
}
