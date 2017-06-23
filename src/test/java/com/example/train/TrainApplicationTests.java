package com.example.train;

import com.example.train.service.TrainStationHandler;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainApplicationTests {

    //AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
    @Test
    public void distance_of_A_B_C_should_be_9() {

        ArrayList<String> crossStations = new ArrayList<>();
        crossStations.add("B");

        Assert.assertEquals("9", TrainStationHandler.getDistance("A", crossStations, "C"));
    }

    @Test
    public void distance_of_A_D_should_be_5() {

        ArrayList<String> crossStations = new ArrayList<>();

        Assert.assertEquals("5", TrainStationHandler.getDistance("A", crossStations, "D"));
    }
    @Test
    public void distance_of_A_D_C_should_be_13() {

        ArrayList<String> crossStations = new ArrayList<>();
        crossStations.add("D");

        Assert.assertEquals("13", TrainStationHandler.getDistance("A", crossStations, "C"));
    }
    @Test
    public void distance_of_A_E_B_C_D_should_be_22() {

        ArrayList<String> crossStations = new ArrayList<>();
        crossStations.add("E");
        crossStations.add("B");
        crossStations.add("C");

        Assert.assertEquals("22", TrainStationHandler.getDistance("A", crossStations, "D"));
    }

    @Test
    public void distance_of_A_E_D_should_be_no_route() {

        ArrayList<String> crossStations = new ArrayList<>();
        crossStations.add("E");

        Assert.assertEquals("NO SUCH ROUTE", TrainStationHandler.getDistance("A", crossStations, "D"));
    }

    @Test
    public void number_of_trips_from_C_to_C_with_maximum_of_3_stops() throws CloneNotSupportedException {
        Assert.assertEquals("2", TrainStationHandler.findTrips("C", "C",3,false));
    }

    @Test
    public void number_of_trips_from_A_to_C_with_exactly_of_4_stops() throws CloneNotSupportedException {
        Assert.assertEquals("2", TrainStationHandler.findTrips("C", "C",4,true));
    }

//    @Test
//    public void length_of_the_shortest_route_from_A_to_C() throws CloneNotSupportedException {
//        Assert.assertEquals("9", TrainStationHandler.findTrips("C", "C",1,true));
//    }
//
//    @Test
//    public void length_of_the_shortest_route_from_B_to_B() throws CloneNotSupportedException {
//        Assert.assertEquals("9", TrainStationHandler.findTrips("C", "C",4,true));
//    }
//    @Test
//    public void  number_of_different_routes_from_C_to_C_with_a_distance_of_less_than_30() throws CloneNotSupportedException {
//        Assert.assertEquals("7", TrainStationHandler.findTrips("C", "C",4,true));
//    }





}
