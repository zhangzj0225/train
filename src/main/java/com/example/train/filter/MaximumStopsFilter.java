package com.example.train.filter;

import com.example.train.modal.Trip;

public class MaximumStopsFilter implements TripFilter {

    private int maximumStops;

    public MaximumStopsFilter(int maximumStops) {
        this.maximumStops = maximumStops;
    }

    @Override
    public boolean canPass(Trip trip) {
        return trip.getTripDetails().size() <= maximumStops;
    }
}
