package com.example.train.modal;

public class StationLine {

    private String start;
    private String end;
    private int distance;

    @Override
    public String toString() {
        return "StationLine{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", distance=" + distance +
                '}';
    }

    public StationLine(String start, String end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    public String getStartStation() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEndStation() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean lineEquals(String start, String end) {
        return stationStartWith(start) && stationEndWith(end);
    }

    public boolean stationEndWith(String end) {
        return this.end.equals(end);
    }

    public boolean stationStartWith(String start) {
        return this.start.equals(start);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StationLine that = (StationLine) o;

        if (distance != that.distance) return false;
        if (!start.equals(that.start)) return false;
        return end.equals(that.end);
    }

    @Override
    public int hashCode() {
        int result = start.hashCode();
        result = 31 * result + end.hashCode();
        result = 31 * result + distance;
        return result;
    }
}
