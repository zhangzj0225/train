package com.example.train.filter;

import com.example.train.modal.Trip;

public interface PassFilter {

    boolean canPass(Trip trip);

}
