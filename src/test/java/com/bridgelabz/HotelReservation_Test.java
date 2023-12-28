package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

// Use case 2 :
// Ability to find the cheapest Hotel for a given Date Range
// - I/P – 10Sep2020, 11Sep2020
// - O/P – Lakewood, Total Rates: $220
public class HotelReservation_Test {
    Hotel h;
    @Before
    public void init(){
        h = new Hotel();
    }

    @Test
    public void testCheapestHotel() throws ParseException {
        try{
            String actual = h.findCheapestHotel("10Sep2020","11Sep2020");
            Assert.assertEquals("Lakewood, Total Rates: $220",actual);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
    }
}
