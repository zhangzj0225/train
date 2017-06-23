package com.example.train.filter;

import com.example.train.modal.StationLine;
import com.example.train.modal.Trip;

public interface TripFilter {
    boolean canPass(Trip trip);
}
