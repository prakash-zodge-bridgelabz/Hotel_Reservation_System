package com.bridgelabz;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

// Use case 3 :
// Ability to add weekday and weekend rates for each Hotel
// - For Lakewood Weekday & Weekend Rates per day is $110 & $90
// - For Bridgewood $150 and $50 -
// - For Ridgewood $220 and $150
@RunWith(JUnitParamsRunner.class)
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
    // Ability to add weekday and weekend rates for each Hotel
// - For Lakewood Weekday & Weekend Rates per day is $110 & $90
// - For Bridgewood $150 and $50 -
// - For Ridgewood $220 and $150

//    @Test
//    @Parameters({
//            {"Lakewood",110,90,"Hotel : Lakewood- Updated Weekday Rate : $110- Updated Weekend Rate : $90"},
//                {"Bridgewood",150,50,"Hotel : Bridgewood- Updated Weekday Rate : $150- Updated Weekend Rate : $50"},
//                {"Ridgewood",220,150,"Hotel : Ridgewood- Updated Weekday Rate : $220- Updated Weekend Rate : $150"}
//    })
    @Test
    public void testAddWeekendAndWeekdayRatesForEachHotel(){
        String lakewoodActual = h.addWeekendAndWeekdayRatesForEachHotel("Lakewood",110,90);
        String lakewoodExpected = "Hotel : Lakewood, Updated Weekday Rate : $110, Updated Weekend Rate : $90";
        Assert.assertEquals(lakewoodExpected,lakewoodActual);

        String bridgewoodActual = h.addWeekendAndWeekdayRatesForEachHotel("Bridgewood",150,50);
        String bridgewoodExpected = "Hotel : Bridgewood, Updated Weekday Rate : $150, Updated Weekend Rate : $50";
        Assert.assertEquals(bridgewoodExpected,bridgewoodActual);

        String ridgewoodActual = h.addWeekendAndWeekdayRatesForEachHotel("Ridgewood",220,150);
        String ridgewoodExpected = "Hotel : Ridgewood, Updated Weekday Rate : $220, Updated Weekend Rate : $150";
        Assert.assertEquals(ridgewoodExpected,ridgewoodActual);
    }
}
