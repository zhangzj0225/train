package com.example.train.filter;

import com.example.train.modal.Trip;

public class DistanceLessThaFilter implements PassFilter{
    private int distanceLessThan = 0;

    public DistanceLessThaFilter(int distanceLessThan) {
        this.distanceLessThan = distanceLessThan;
    }

    @Override
    public boolean canPass(Trip trip) {
        return trip.getTripDistance() < distanceLessThan;
    }
}
