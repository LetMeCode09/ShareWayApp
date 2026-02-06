package com.svalero.sharewayapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.sharewayapp.adapter.TripAdapter;
import com.svalero.sharewayapp.domain.Trip;

import java.util.ArrayList;
import java.util.List;

public class TripListView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TripAdapter tripAdapter;
    private List<Trip> tripList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO CREAR LAYOUT LISTA TRIPS
        recyclerView = findViewById(R.id.trip_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tripList = new ArrayList<>();



    }
}