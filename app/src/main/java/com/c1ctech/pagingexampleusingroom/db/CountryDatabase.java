package com.c1ctech.pagingexampleusingroom.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.c1ctech.pagingexampleusingroom.Country;
import com.c1ctech.pagingexampleusingroom.db.dao.CountryDao;


@Database(entities = {Country.class}, version = 1)
public abstract class CountryDatabase extends RoomDatabase {
    private static final String DB_NAME = "Country_Database.db";
    private static CountryDatabase INSTANCE;


    public static CountryDatabase getCountryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, CountryDatabase.class, DB_NAME).build();

        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract CountryDao countryDao();
}