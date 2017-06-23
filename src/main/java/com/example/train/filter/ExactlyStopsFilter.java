package com.example.train.filter;

import com.example.train.modal.Trip;

import java.util.List;
import java.util.stream.Collectors;

public class ExactlyStopsFilter implements ConditionFilter {

    public int getExactlyStops() {
        return exactlyStops;
    }

    private int exactlyStops;

    public ExactlyStopsFilter(int exactlyStops) {
        this.exactlyStops = exactlyStops;
    }

    @Override
    public List<Trip> filter(List<Trip> trips) {
        return trips.stream().filter(trip -> trip.getTripDetails().size() == exactlyStops).collect(Collectors.toList());
    }
}
