import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HotelReservation {
    private static Map<String, Hotel> hotelMap;

    public HotelReservation() {
        hotelMap = new HashMap<>();
    }

    public boolean addHotel(String name, int regWeekdayRate) {
        Hotel hotelObject = new Hotel(name, regWeekdayRate);
        hotelMap.put(name, hotelObject);
        return true;
    }

    /**
     * UC3 adding hotel considering weekend rates
     *
     * @param name
     * @param regWeekdayRate
     * @param regWeekendRate
     * @return
     */
    public boolean addHotel(String name, int regWeekdayRate, int regWeekendRate) {
        Hotel hotelObject = new Hotel(name, regWeekdayRate, regWeekendRate);
        hotelMap.put(name, hotelObject);
        return true;
    }

    public boolean addHotel(String name, int regWeekdayRate, int regWeekendRate, int hotelRating) {
        Hotel hotelObject = new Hotel(name, regWeekdayRate, regWeekendRate, hotelRating);
        hotelMap.put(name, hotelObject);
        return true;
    }
    public boolean addHotel(String name, int regWeekdayRate, int regWeekendRate, int hotelRating, int rewWeekdayRate, int rewWeekendRate) {
        Hotel hotelObject = new Hotel(name, regWeekdayRate, regWeekendRate, hotelRating, rewWeekdayRate, rewWeekendRate);
        hotelMap.put(name, hotelObject);
        return true;
    }

    /**
     * Prints the hotels
     */
    public void printHotels() {
        for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
            System.out.println("Hotel Name : " + entry.getKey());
            System.out.println("Rate on weekdays for regular customers : " + entry.getValue().getRegWeekdayRate());
            System.out.println("Rate on weekends for regular customers : " + entry.getValue().getRegWeekendRate());
            System.out.println("Hotel Rating : " + entry.getValue().getHotelRating());
            System.out.println();
        }
    }

    /**
     * UC4 Find cheapest hotel for the given date range
     * Including weekend rates
     *
     * @param fromDate
     * @param toDate
     * @return
     */
    public Boolean findCheapestHotel(String fromDate, String toDate) {
        Map<Integer, ArrayList<Hotel>> rentMap = createRentMap(fromDate, toDate);
        int minimumRent = Integer.MAX_VALUE;						 //Assigns max possible value
        for (Map.Entry<Integer, ArrayList<Hotel>> entry : rentMap.entrySet()) {
            if (entry.getKey() < minimumRent) {
                minimumRent = entry.getKey();
            }
        }
        System.out.println("Cheapest Hotel for you is ");
        for (Hotel hotel : rentMap.get(minimumRent)) {
            System.out.print(hotel.getHotelName() + "  "); 			//getting every hotel with min rent
        }
        System.out.println("Total Rent : " + minimumRent);			//printing min rent
        return true;
    }

    /**
     * Creates rent map of hotels that are added
     * No need to repeat the same code to find the rent, following DRY
     *
     * @param fromDate
     * @param toDate
     * @return
     */
    public static Map<Integer, ArrayList<Hotel>> createRentMap(String fromDate, String toDate) {
        HashMap<Integer, ArrayList<Hotel>> rentMap = new HashMap<>();
        int days[] = numberOfDays(fromDate, toDate);
        for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
            int weekdayRent = entry.getValue().getRegWeekdayRate() * days[0];
            int weekendRent = entry.getValue().getRegWeekendRate() * days[1];
            int totalRent = weekdayRent + weekendRent;

            rentMap.computeIfAbsent(totalRent, key -> new ArrayList<>()).add(entry.getValue());
        }
        return rentMap;
    }

    /**
     * Calculate no. of week days between two dates
     *
     * @param fromDate
     * @param toDate
     * @return
     */
    public static int[] numberOfDays(String fromDate, String toDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");

        LocalDate from = LocalDate.parse(fromDate, formatter);    // convert String to LocalDate
        LocalDate to = LocalDate.parse(toDate, formatter);		 // convert String to LocalDate
        int numWeekdays = 0;
        int numWeekendDays = 0;
        int days[];
        days = new int[2];

        for (LocalDate date = from; date.isBefore(to.plusDays(1)); date = date.plusDays(1)) {
            DayOfWeek day = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
            switch(day) {
                case SATURDAY :
                    numWeekendDays++;
                    break;

                case SUNDAY :
                    numWeekendDays++;
                    break;

                default :
                    numWeekdays++;
                    break;
            }
        }
        days[0] = numWeekdays;
        days[1] = numWeekendDays;
        return days;
    }
    /**
     * UC10 Handles the exception for invalid inout
     *
     * @param customerType
     * @param fromDate
     * @param toDate
     * @throws InvalidEntryException
     */
    public void validateInputs(String customerType, String fromDate, String toDate) throws InvalidEntryException {
        String regex = "^[0-9]{2}[ ][A-Za-z]{3}[ ][0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcherFrom = pattern.matcher(fromDate);
        Matcher matcherTo = pattern.matcher(toDate);
        if (!matcherFrom.find() || !matcherTo.find() || !customerType.equalsIgnoreCase("Regular")
                || !customerType.equalsIgnoreCase("Reward")) {
            throw new InvalidEntryException("Invalid input, please enter a valid input");
        }
        return;
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Hotel Reservation Program");
    }

    public boolean cheapestBestRatedHotel(String reward, String fromDate, String toDate) {
        Map<Integer, ArrayList<Hotel>> rentMap = createRentMap(fromDate, toDate);
        int minimumRent = Integer.MAX_VALUE;
        for (Map.Entry<Integer, ArrayList<Hotel>> entry : rentMap.entrySet()) {
            if (entry.getKey() < minimumRent)
                minimumRent = entry.getKey();
        }
        ArrayList<Hotel> cheapestHotels = rentMap.get(minimumRent);
        String bestRatedCheapestHotel = "";
        int rating = 0;
        for (Hotel hotel : cheapestHotels) {
            if (hotel.getHotelRating() > rating) {
                bestRatedCheapestHotel = hotel.getHotelName();
                rating = hotel.getHotelRating();
            }
        }
        System.out.println("Cheapest Hotel for you is " + bestRatedCheapestHotel + " with rating  " + rating + " Total Rent : "
                + minimumRent + "\n");
        return true;
    }

    public boolean findBestRatedHotelForGivenDates(String fromDate, String toDate) {
        int rating = 0;
        int rent = 0;
        String bestRatedHotel = "";
        for (Map.Entry<String, Hotel> entry : hotelMap.entrySet()) {
            if (entry.getValue().getHotelRating() > rating) {
                rating = entry.getValue().getHotelRating();
                bestRatedHotel = entry.getKey();
                rent = calculateRent(fromDate, toDate, entry.getValue().getRegWeekdayRate(),
                                    entry.getValue().getRegWeekendRate());
            }
        }
        System.out.println("Best rated hotel : " + bestRatedHotel + ", Rent : " + rent);
        return true;
    }
    public static int calculateRent(String fromDate, String toDate, int weekdayRate, int weekendRate) {
        int[] numOfDays = numberOfDays(fromDate, toDate);
        int weekdayRent = weekdayRate * numOfDays[0];
        int weekendRent = weekendRate * numOfDays[1];
        int totalRent = weekdayRent + weekendRent;
        return totalRent;
    }


}