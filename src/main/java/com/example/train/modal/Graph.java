package com.example.train.modal;

import java.util.ArrayList;

public class Graph {

    private static ArrayList<StationLine> graphs = new ArrayList<>();

    private Graph() {
    }

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


    public static StationLine getStationLine(String startStation, String endStation) {
        StationLine stationLine = null;
        for (StationLine line : getGraphs())
            if (line.lineEquals(startStation, endStation)) {
                stationLine = line;
                break;
            }
        return stationLine;
    }

    public static ArrayList<StationLine> getGraphs() {
        return graphs;
    }
}
