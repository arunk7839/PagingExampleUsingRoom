package com.c1ctech.pagingexampleusingroom;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.c1ctech.pagingexampleusingroom.db.CountryDatabase;
import com.c1ctech.pagingexampleusingroom.db.DatabaseCreater;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private CountryViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.countryList);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        viewModel = ViewModelProviders.of(this).get(CountryViewModel.class);
        insertUser(viewModel.getCountryDatabase());

        viewModel.init(viewModel.countryDao);

        CountryAdapter countryAdapter = new CountryAdapter();

        viewModel.countriesList.observe(this, pageList -> {
            countryAdapter.setList(pageList);
        });

        recyclerView.setAdapter(countryAdapter);


    }

    public void insertUser(CountryDatabase countryDatabase) {
        DatabaseCreater databaseCreator = new DatabaseCreater();
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                countryDatabase.countryDao().insertCountriesList(databaseCreator.getRandomCountryList());
                return null;
            }
        }.execute();
    }
}
