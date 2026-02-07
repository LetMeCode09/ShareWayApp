package com.svalero.sharewayapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.sharewayapp.R;
import com.svalero.sharewayapp.domain.Trip;

import java.util.List;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripHolder> {

    private Context context;
    private List<Trip> tripList;

    public TripAdapter(Context context, List<Trip> dataList) {
        this.context = context;
        this.tripList = dataList;
    }

    @NonNull
    @Override
    public TripHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trip_item, parent, false);
        return new TripHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TripHolder holder, int position) {
        Trip trip = tripList.get(position);

        holder.destination.setText(trip.getDestination());
        holder.origin.setText(trip.getOrigin());
    }

    @Override
    public int getItemCount() {
        return tripList.size();
    }

    public class TripHolder extends RecyclerView.ViewHolder {

        public TextView origin;
        public TextView destination;

        public TripHolder(@NonNull View itemView) {
            super(itemView);

            origin = itemView.findViewById(R.id.item_trip_origin);
            destination = itemView.findViewById(R.id.item_trip_destination);
        }
    }
}
