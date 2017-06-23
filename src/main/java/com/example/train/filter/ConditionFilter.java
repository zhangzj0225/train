package com.example.train.filter;

import com.example.train.modal.Trip;

import java.util.List;

public interface ConditionFilter {
    List<Trip> filter(List<Trip> trips);

}
