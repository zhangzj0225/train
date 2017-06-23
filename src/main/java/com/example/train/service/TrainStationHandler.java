package com.example.train.service;

import com.example.train.filter.ConditionFilter;
import com.example.train.filter.PassFilter;
import com.example.train.modal.StationLine;
import com.example.train.modal.Trip;

import java.util.ArrayList;
import java.util.List;

import static com.example.train.modal.Graph.getGraphs;
import static com.example.train.modal.Graph.getStationLine;

public class TrainStationHandler {


    public static String getDistance(String begin, ArrayList<String> crossStations, String end) {

        String startStation = begin;
        crossStations.add(end);
        int totalDistance = 0;
        for (String stationName : crossStations) {
            StationLine stationLine = getStationLine(startStation, stationName);
            if (null == stationLine) {
                return "NO SUCH ROUTE";
            }
            totalDistance += stationLine.getDistance();
            startStation = stationName;
        }

        return totalDistance + "";
    }

    public static List<Trip> findTrips(String start, String end, PassFilter passFilter, ConditionFilter conditionFilter) {
        List<Trip> trips = findTrips(start, end, new ArrayList<>(), new Trip(), passFilter);
        if (null != conditionFilter) {
            trips = conditionFilter.filter(trips);
        }
        trips.stream().forEach(trip -> System.out.println(trip));
        return trips;
    }

    private static void deepFind(String endStation, ArrayList<Trip> resultTrips, Trip currentTrip, PassFilter filter) {
        if (null != filter && filter.canPass(currentTrip)) {
            if (currentTrip.isDestination(endStation)) {
                resultTrips.add(currentTrip);
            }
            findTrips(currentTrip.getLastStationLine().getEndStation(), endStation, resultTrips, currentTrip.deepCopy(), filter);
        }


    }

    private static ArrayList<Trip> findTrips(String startStation, String endStation, ArrayList<Trip> resultTrips, Trip currentTrip, PassFilter filter) {
        for (StationLine line : getGraphs()) {
            if (line.stationStartWith(startStation)) {
                Trip cloneTrip = currentTrip.deepCopy();
                cloneTrip.addStationLine(line);
                deepFind(endStation, resultTrips, cloneTrip, filter);
            }
        }

        return resultTrips;
    }
}
