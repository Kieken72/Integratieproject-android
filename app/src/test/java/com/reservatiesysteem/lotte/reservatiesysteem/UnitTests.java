package com.reservatiesysteem.lotte.reservatiesysteem;


import com.reservatiesysteem.lotte.reservatiesysteem.controller.ReservationController;
import com.reservatiesysteem.lotte.reservatiesysteem.model.City;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Jasper on 10/02/2017.
 */

public class UnitTests {
    ReservationController reservationController = new ReservationController();
    @Test
    public void test_getGemeentes(){
        ArrayList<City> cities = reservationController.getCities();
        assertNotNull("cities should not be empty",cities);
        assertTrue("cities should be bigger than 1",cities.size()>0);
        //assertEquals("cities should contain 5548 items",cities.size(),5548);
    }
}
