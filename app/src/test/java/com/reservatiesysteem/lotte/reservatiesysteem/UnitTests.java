package com.reservatiesysteem.lotte.reservatiesysteem;

import com.reservatiesysteem.lotte.reservatiesysteem.controller.ReservationController;
import com.reservatiesysteem.lotte.reservatiesysteem.model.Branch;
import com.reservatiesysteem.lotte.reservatiesysteem.model.City;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Jasper on 10/02/2017.
 */

public class UnitTests {
    ReservationController reservationController = new ReservationController();

    @Test
    public void test_getGemeentes(){
        ArrayList<City> cities = reservationController.getCities();
        assertNotNull("cities should not be empty",cities);
        //assertEquals("cities should contain 5548 items",cities.size(),5548);
    }

    @Test
    public void test_getBranchesExistingCity(){
        ArrayList<Branch> branches = reservationController.getBranchesByPostcode(2550);
        assertNotNull("branches should not be null",branches);
        assertTrue("Kontich should have more than 0 branches",branches.size()>0);
    }
}
