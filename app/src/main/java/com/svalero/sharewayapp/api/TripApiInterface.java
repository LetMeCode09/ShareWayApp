package com.svalero.sharewayapp.api;

import com.svalero.sharewayapp.domain.Trip;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TripApiInterface {

    @GET("trips")
    Call<List<Trip>> getTrips();

    @GET("trips/{id}")
    Call<Trip> getTrip();
}
