package com.example.train.filter;

import com.example.train.modal.Trip;

import java.util.List;

public class ShortestTripFilter implements ConditionFilter {

    @Override
    public List<Trip> filter(List<Trip> trips) {
        Trip returnTrip = trips.get(0);
        for (int i = 1; i < trips.size(); i++) {
            Trip trip = trips.get(i);
            int tripDistance = trip.getTripDistance();
            if(tripDistance < returnTrip.getTripDistance()){
                returnTrip = trip;
            }
        }
        trips.clear();
        trips.add(returnTrip);
        return trips;
    }
}
