package com.c1ctech.pagingexampleusingroom;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CountryAdapter extends PagedListAdapter<Country, CountryAdapter.CountryViewHolder> {

    public CountryAdapter() {
        super(Country.DIFF_CALLBACK);
    }


    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_country_list, parent, false);

        return new CountryViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = getItem(position);
        if (country != null) {
            holder.bindTo(country);
        }

    }


    public static class CountryViewHolder extends RecyclerView.ViewHolder {

        TextView countryName;
        TextView uniqueId;


        public CountryViewHolder(View itemView) {
            super(itemView);

            countryName = (TextView) itemView.findViewById(R.id.tv_country);
            uniqueId = (TextView) itemView.findViewById(R.id.tv_id);
        }

        public void bindTo(Country country) {
            countryName.setText(country.countryName);
            uniqueId.setText(Integer.toString(country.id));
        }
    }


}
