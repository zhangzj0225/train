package com.example.train.modal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Trip {

    private ArrayList<StationLine> trip = new ArrayList<>();

    public Trip(StationLine... lines) {
        trip = new ArrayList<>(Arrays.asList(lines));
    }

    public ArrayList<StationLine> getTripDetails() {
        return trip;
    }

    public boolean addStationLine(StationLine line) {
        return trip.add(line);
    }

    public StationLine getLastStationLine() {
        return trip.get(trip.size() - 1);
    }

    public boolean isDestination(String destinationStation) {
        return this.getLastStationLine().getEndStation().equals(destinationStation);
    }

    public Trip deepCopy() {
        Trip cloneTrip = new Trip(this.trip.toArray(new StationLine[]{}));
        return cloneTrip;
    }

    public boolean hasRepetitiveRoute() {
        return trip.stream().distinct().collect(Collectors.toList()).size() != trip.size();
    }

    public int getTripDistance() {
        int distance = 0;
        for (StationLine line: trip) {
            distance += line.getDistance();
        }
        return distance;
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
