package com.example.train.modal;

import java.util.ArrayList;
import java.util.Arrays;

public class Trip implements Cloneable{

    private ArrayList<StationLine> trip = new ArrayList<>();

    public Trip(StationLine... lines) {
        trip = new ArrayList<>(Arrays.asList(lines));
    }

    public ArrayList<StationLine> getTripDetails() {
        return trip;
    }

    public void setTrip(ArrayList<StationLine> trip) {
        this.trip = trip;
    }

    public boolean addStationLine(StationLine line) {
        return trip.add(line);
    }

    public StationLine getLastStationLine() {
        return trip.get(trip.size() - 1);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Trip cloneTrip = new Trip(this.trip.toArray(new StationLine[]{}));
        return cloneTrip;
    }

    @Override
    public String toString() {
        StringBuffer sb = null;
        for (StationLine line : trip) {
            if (null == sb) {
                sb = new StringBuffer(line.getStartStation());
            }
            sb.append("-" + line.getEndStation());
        }
        return "Trip{" + sb.toString() + '}';
    }
}
