package com.example.train.service;

import com.example.train.modal.StationLine;
import com.example.train.modal.Trip;

import java.util.ArrayList;

public class TrainStationHandler {

    private static ArrayList<StationLine> graphs = new ArrayList<>();
    String[] graph = new String[]{"AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"};

    static {
        graphs.add(new StationLine("A", "B", 5));
        graphs.add(new StationLine("B", "C", 4));
        graphs.add(new StationLine("C", "D", 8));
        graphs.add(new StationLine("D", "C", 8));
        graphs.add(new StationLine("D", "E", 6));
        graphs.add(new StationLine("A", "D", 5));
        graphs.add(new StationLine("C", "E", 2));
        graphs.add(new StationLine("E", "B", 3));
        graphs.add(new StationLine("A", "E", 7));
    }

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

    private static StationLine getStationLine(String startStation, String endStation) {
        StationLine stationLine = null;
        for (StationLine line : graphs) {
            if (line.lineEquals(startStation, endStation)) {
                stationLine = line;
                break;
            }
        }
        return stationLine;
    }

    public static String findTrips(String start, String end, int maximumStops,boolean exactly) throws CloneNotSupportedException {
        ArrayList<Trip> result = findTrips(start, end, new ArrayList<>(), maximumStops, new Trip(),exactly);
        result.stream().forEach(trip -> System.out.println(trip));
        return result.size() + "";
    }

    private static void deepFind(String endStation, ArrayList<Trip> resultTrips, Trip currentTrip, int maximumStops, boolean exactly) throws CloneNotSupportedException {
        StationLine line = currentTrip.getLastStationLine();
        int stopsSize = currentTrip.getTripDetails().size();

        if (stopsSize < maximumStops) {
            findTrips(currentTrip.getLastStationLine().getEndStation(), endStation, resultTrips, maximumStops, (Trip) currentTrip.clone(),exactly);
        }
        if (currentTrip.getLastStationLine().getEndStation().equals(endStation)) {
            if (exactly && stopsSize == maximumStops) {
                resultTrips.add(currentTrip);
            }
            if (!exactly && stopsSize <= maximumStops) {
                resultTrips.add(currentTrip);
            }
        }


    }

    private static ArrayList<Trip> findTrips(String startStation, String endStation, ArrayList<Trip> resultTrips, int maximumStops, Trip currentTrip, boolean exactly) throws CloneNotSupportedException {
        for (StationLine line : graphs) {
            if (line.stationStartWith(startStation)) {
                Trip cloneTrip = (Trip) currentTrip.clone();
                cloneTrip.addStationLine(line);
//                searchableTrips.add(cloneTrip);
                deepFind(endStation, resultTrips, cloneTrip, maximumStops,exactly);
            }
        }

        return resultTrips;
    }
}
