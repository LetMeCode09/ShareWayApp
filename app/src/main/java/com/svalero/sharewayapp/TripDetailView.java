package com.svalero.sharewayapp;

import android.os.Bundle;
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

        if (trip.getPrice() != null) {
            tvPrice.setText(trip.getPrice() + "€");
        }

        if (trip.getAvailableSeats() != null) {
            tvSeats.setText(trip.getAvailableSeats() + " plazas libres");
        }

        if (trip.getDateTime() != null) {
            tvDate.setText(trip.getDateTime().toString());
        }

        tvTransport.setText(trip.getTransportTypes());

        findViewById(R.id.btn_book).setOnClickListener(v -> {
            Toast.makeText(this, "Reserva iniciada para " + trip.getDestination(), Toast.LENGTH_SHORT).show();
        });
    }
}