package com.svalero.sharewayapp;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.svalero.sharewayapp.domain.Trip;

public class TripDetailView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_detail);

        Trip trip = (Trip) getIntent().getSerializableExtra("trip_obj");

        if (trip == null) return;

        TextView tvOrigin = findViewById(R.id.detail_origin);
        TextView tvDestination = findViewById(R.id.detail_destination);
        TextView tvPrice = findViewById(R.id.detail_price);
        TextView tvDate = findViewById(R.id.detail_date);
        TextView tvSeats = findViewById(R.id.detail_seats);
        TextView tvTransport = findViewById(R.id.detail_transport);

        tvOrigin.setText(trip.getOrigin());
        tvDestination.setText(trip.getDestination());

        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            finish();
        });

        if (trip.getPrice() != null) {
            tvPrice.setText(trip.getPrice() + "€");
        }

        if (trip.getAvailableSeats() != null) {
            tvSeats.setText(trip.getAvailableSeats() + " seats available");
        }

        if (trip.getDateTime() != null) {
            tvDate.setText(trip.getDateTime().toString());
        }

        tvTransport.setText(trip.getTransportTypes());

        findViewById(R.id.btn_book).setOnClickListener(v -> {
            Toast.makeText(this, "Booking started for " + trip.getDestination(), Toast.LENGTH_SHORT).show();
        });
    }
}