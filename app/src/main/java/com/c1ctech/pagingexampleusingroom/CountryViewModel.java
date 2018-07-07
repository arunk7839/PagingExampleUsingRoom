package com.c1ctech.pagingexampleusingroom;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;

import com.c1ctech.pagingexampleusingroom.db.CountryDatabase;
import com.c1ctech.pagingexampleusingroom.db.dao.CountryDao;

public class CountryViewModel extends AndroidViewModel {

    private CountryDatabase countryDatabase;

    public CountryDao countryDao;

    public LiveData<PagedList<Country>> countriesList;

    public CountryViewModel(@NonNull Application application) {
        super(application);

        countryDatabase = CountryDatabase.getCountryDatabase(this.getApplication());

        countryDao = countryDatabase.countryDao();

    }

    public void init(CountryDao countryDao) {
        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder()).setEnablePlaceholders(true)
                        .setPrefetchDistance(10)
                        .setPageSize(20).build();

        countriesList = (new LivePagedListBuilder(countryDao.getCountries()
                , pagedListConfig))
                .build();


    }

    public CountryDao getCountryDao() {
        return countryDao;
    }


    public CountryDatabase getCountryDatabase() {
        return countryDatabase;
    }
}
