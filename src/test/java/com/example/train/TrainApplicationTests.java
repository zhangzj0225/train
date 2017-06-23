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

    @Test
    public void length_of_the_shortest_route_from_A_to_C() throws CloneNotSupportedException {
        Assert.assertEquals("9", TrainStationHandler.findTrips("C", "C",1,true));
    }

    @Test
    public void length_of_the_shortest_route_from_B_to_B() throws CloneNotSupportedException {
        Assert.assertEquals("9", TrainStationHandler.findTrips("C", "C",4,true));
    }
    @Test
    public void  number_of_different_routes_from_C_to_C_with_a_distance_of_less_than_30() throws CloneNotSupportedException {
        Assert.assertEquals("7", TrainStationHandler.findTrips("C", "C",4,true));
    }



//	The distance of the route A-B-C.
//	The distance of the route A-D.
//	The distance of the route A-D-C.
//	The distance of the route A-E-B-C-D.
//	The distance of the route A-E-D.
//	The number of trips starting at C and ending at C with a maximum of 3 stops.  In the sample data below, there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops).
//	The number of trips starting at A and ending at C with exactly 4 stops.  In the sample data below, there are three such trips: A to C (via B,C,D); A to C (via D,C,D); and A to C (via D,E,B).
//	The length of the shortest route (in terms of distance to travel) from A to C.
//	The length of the shortest route (in terms of distance to travel) from B to B.
//	The number of different routes from C to C with a distance of less than 30.  In the sample data, the trips are: CDC, CEBC, CEBCDC, CDCEBC, CDEBC, CEBCEBC, CEBCEBCEBC.

//	Output #1: 9
//	Output #2: 5
//	Output #3: 13
//	Output #4: 22
//	Output #5: NO SUCH ROUTE
//	Output #6: 2
//	Output #7: 3
//	Output #8: 9
//	Output #9: 9
//	Output #10: 7

}
