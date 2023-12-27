package com.bridgelabz;
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
// Use case 1 :
// Ability to add Hotel in a Hotel Reservation System with Name and rates for Regular Customer…
class Hotel{
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
}
public class HotelReservation {
    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation Program");
        // Creating hotels
        Hotel Lakewood = new Hotel("Lakewood",110,
                80,90,80,3);
        Hotel Bridgewood = new Hotel("Bridgewood",160,
                110,60,50,4);
        Hotel Ridgewood = new Hotel("Ridgewood",220,
                100,150,40,5);
        System.out.println("------------------------------------------------------"+
                "\nLakewood Hotel information : "+Lakewood);
        System.out.println("------------------------------------------------------"+
                "\nBridgewood Hotel information : "+Bridgewood);
        System.out.println("------------------------------------------------------"+
                "\nRidgewood Hotel information : "+Ridgewood);
    }
}
