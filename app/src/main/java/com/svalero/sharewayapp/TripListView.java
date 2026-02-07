package com.svalero.sharewayapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.sharewayapp.adapter.TripAdapter;
import com.svalero.sharewayapp.api.TripApi;
import com.svalero.sharewayapp.api.TripApiInterface;
import com.svalero.sharewayapp.domain.Trip;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TripListView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TripAdapter tripAdapter;
    private List<Trip> tripList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadTrips();

        recyclerView = findViewById(R.id.trip_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tripList = new ArrayList<>();

        tripAdapter = new TripAdapter(this, tripList);
        recyclerView.setAdapter(tripAdapter);
    }

    protected void onResume() {
        super.onResume();
    }

    public void shoTrips(List<Trip> trips) {
        tripList.clear();
        tripList.addAll(trips);
        tripAdapter.notifyDataSetChanged();
    }

    public void loadTrips() {

        TripApiInterface api = TripApi.buildInstance();
        Call<List<Trip>> call = api.getTrips();

        call.enqueue(new Callback<List<Trip>>() {
            @Override
            public void onResponse(Call<List<Trip>> call, Response<List<Trip>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Trip> concerts = response.body();
                    shoTrips(concerts);

                } else {
                    Toast.makeText(getApplicationContext(), "No se ha podido conectar con el servidor. Código de error:" + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Trip>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), "Error Red: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}