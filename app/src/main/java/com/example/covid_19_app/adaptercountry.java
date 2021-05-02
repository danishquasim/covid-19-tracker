package com.example.covid_19_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.covid_19_app.R.layout.activity_main;

public class adaptercountry extends RecyclerView.Adapter<adaptercountry.ViewHolder> {

    ArrayList<countryData> countrydata;

    public adaptercountry(ArrayList<countryData> countrydata){
        this.countrydata = countrydata;
    }


    @NonNull
    @Override
    public adaptercountry.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent,false);



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adaptercountry.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView cases,countryname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
