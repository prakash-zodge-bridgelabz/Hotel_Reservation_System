package com.bridgelabz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// HOTEL RESERVATION SYSTEM
// Rates --> Weekday
// Rates --> Weekend (Saturday, Sunday)
//                                                   3 HOTEL's
// Concepts                     | Lakewood      |   Bridgelwood     |   Ridgewood
// Ratings                      |   3           |       4           |       5
// RegularCustomerWeekdayRate $ |   110         |       160         |       220
// RewardCustomerWeekdayRate  $ |   80          |       110         |       100
// RegularCustomerWeekendRate $ |   90          |       60          |       150
// RewardCustomerWeekendRate  $ |   80          |       50          |       40
//
// Use case 2 :
// Ability to find the cheapest Hotel for a given Date Range
// - I/P – 10Sep2020, 11Sep2020
// - O/P – Lakewood, Total Rates: $220
class Hotel{
    Hotel(){
        //do nothing
    }
    String hotelName;
    int regularCustomerWeekdayRate,rewardCustomerWeekdayRate,
            regularCustomerWeekendRate,rewardCustomerWeekendRate,ratings;
    Hotel(String hotelName,int regularCustomerWeekdayRate,int rewardCustomerWeekdayRate,
          int regularCustomerWeekendRate,int rewardCustomerWeekendRate,int ratings){
        this.hotelName = hotelName;
        this.regularCustomerWeekdayRate = regularCustomerWeekdayRate;
        this.rewardCustomerWeekdayRate = rewardCustomerWeekdayRate;
        this.regularCustomerWeekendRate = regularCustomerWeekendRate;
        this.rewardCustomerWeekendRate = rewardCustomerWeekendRate;
        this.ratings = ratings;
    }
    @Override
    public String toString() {
        return "Hotel Name : "+hotelName+
                "\nRegular customer weekday rate : "+regularCustomerWeekdayRate+"$"+
                "\nReward customer weekday rate : "+rewardCustomerWeekdayRate+"$"+
                "\nRegular customer weekend rate : "+regularCustomerWeekendRate+"$"+
                "\nReward customer weekend rate : "+rewardCustomerWeekendRate+"$"+
                "\nRatings : "+ratings;
    }
    String day;
    String getDay(String strDate)throws ParseException {

        try {
            String inputDate = strDate.replace("sep","sept");     //Throws error --> if we provide "sep" so replaced with "sept"
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
            Date date = dateFormat.parse(inputDate);
            SimpleDateFormat DayOfWeek = new SimpleDateFormat("EEEE");
            day = DayOfWeek.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }
    int weekdayCount=0, weekendCount=0;
    String firstDay=" ",lastDay=" ";
    int getPrice(String firstDay, String lastDay){
        //Check whether day is weekend or weekday
        if(firstDay == "Saturday" || firstDay == "Sunday") {
            weekendCount++;                 //0
        } else{
            weekdayCount++;                 //1
        }
        if(lastDay == "Saturday" || lastDay == "Sunday") {
            weekendCount++;                 //1
        } else{
            weekdayCount++;
        }
        //Checking which hotel is cheap
        int price=0;
        if(weekendCount <= 0){
            // do nothing
        }
        else{
            price += regularCustomerWeekendRate * weekendCount;
        }
        if(weekdayCount <= 0){
            // do nothing
        }
        else{
            price += regularCustomerWeekdayRate * weekdayCount;
        }
        return price;
    }
    int price,lakewoodPrice,bridgewoodPrice,ridgewoodPrice;
    String findCheapestHotel(String fromDate, String toDate) throws ParseException {
        firstDay = getDay(fromDate);        //friday
        lastDay = getDay(toDate);           //saturday
        //Defining three hotels
        Hotel Lakewood = new Hotel("Lakewood",110,
                80,90,80,3);
        Hotel Bridgewood = new Hotel("Bridgewood",160,
                110,60,50,4);
        Hotel Ridgewood = new Hotel("Ridgewood",220,
                100,150,40,5);
        lakewoodPrice = Lakewood.getPrice(firstDay,lastDay);
        bridgewoodPrice = Bridgewood.getPrice(firstDay,lastDay);
        ridgewoodPrice = Ridgewood.getPrice(firstDay,lastDay);
        //Finding cheapest hotel
        if(lakewoodPrice < bridgewoodPrice && lakewoodPrice < ridgewoodPrice){
            return Lakewood.hotelName+", Total Rates: $"+lakewoodPrice;
        }
        else if(bridgewoodPrice < lakewoodPrice && bridgewoodPrice < ridgewoodPrice){
            return Bridgewood.hotelName+", Total Rates: $"+bridgewoodPrice;
        }
        else if(ridgewoodPrice < lakewoodPrice && ridgewoodPrice < bridgewoodPrice){
            return Ridgewood.hotelName+", Total Rates: $"+ridgewoodPrice;
        }
        else if(lakewoodPrice == bridgewoodPrice){
            if(Lakewood.ratings > Bridgewood.ratings){
                return Lakewood.hotelName+", Total Rates: $"+lakewoodPrice;
            }
            else {
                return Bridgewood.hotelName+", Total Rates: $"+bridgewoodPrice;
            }
        }
        else if(bridgewoodPrice == ridgewoodPrice) {
            if(Bridgewood.ratings > Ridgewood.ratings){
                return Bridgewood.hotelName+", Total Rates: $"+bridgewoodPrice;
            }
            else {
                return Ridgewood.hotelName+", Total Rates: $"+ridgewoodPrice;
            }
        }
        else{       // lakewoodPrice == ridgewoodPrice
            if(Lakewood.ratings > Ridgewood.ratings){
                return Lakewood.hotelName+", Total Rates: $"+lakewoodPrice;
            }
            else{
                return Ridgewood.hotelName+", Total Rates: $"+ridgewoodPrice;
            }
        }
    }
}
public class HotelReservation {
    public static void main(String[] args) throws ParseException {
        System.out.println("Welcome to Hotel Reservation Program");
    }
}
