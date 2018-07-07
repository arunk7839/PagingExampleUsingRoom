package com.c1ctech.pagingexampleusingroom;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.DiffCallback;

import static com.c1ctech.pagingexampleusingroom.Country.TABLE_NAME;

@Entity(tableName = TABLE_NAME)
public class Country {

    public static DiffCallback<Country> DIFF_CALLBACK = new DiffCallback<Country>() {
        @Override
        public boolean areItemsTheSame(@NonNull Country oldItem, @NonNull Country newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Country oldItem, @NonNull Country newItem) {
            return oldItem.equals(newItem);
        }
    };


    public static final String TABLE_NAME = "COUNTRIES";


    @PrimaryKey(autoGenerate = true)
    public int id;

    public String countryName;


    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        Country country = (Country) obj;

        return country.id == this.id && country.countryName == this.countryName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                '}';
    }


}


