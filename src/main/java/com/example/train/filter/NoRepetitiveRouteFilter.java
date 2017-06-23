package com.example.train.filter;

import com.example.train.modal.Trip;

public class NoRepetitiveRouteFilter implements PassFilter {
    @Override
    public boolean canPass(Trip trip) {
        return !trip.hasRepetitiveRoute();
    }
}
