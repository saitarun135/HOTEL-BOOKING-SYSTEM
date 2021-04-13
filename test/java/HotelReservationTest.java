import org.junit.Assert;

import org.junit.Test;

public class HotelReservationTest {
    @Test
    public void whenNewHotelAdded_shouldReturnTrue() {
        HotelReservation hotelReservationObject = new HotelReservation();
        Assert.assertTrue(hotelReservationObject.addHotel("Lakewood", 110));
        Assert.assertTrue(hotelReservationObject.addHotel("Bridgewood", 160));
        Assert.assertTrue(hotelReservationObject.addHotel("Ridgewood", 110));

        hotelReservationObject.printHotels();
    }

    /**
     * UC2 Testing
     */
    @Test
    public void whenFindCheapestHotelMethodCalled_shouldReturn_nameOfHotel() {
        HotelReservation hotelReservation = new HotelReservation();
        Assert.assertTrue(hotelReservation.addHotel("Lakewood", 110));
        Assert.assertTrue(hotelReservation.addHotel("Bridgewood", 160));
        Assert.assertTrue(hotelReservation.addHotel("Ridgewood", 220));
        boolean result = hotelReservation.findCheapestHotel("10 Sep 2020", "11 Sep 2020");
        Assert.assertTrue("Lakewood", result);
    }
//

    /**
     * UC3 testing
     */
    @Test
    public void whenNewHotelAddedWithWeekend_shouldReturnTrue() {
        HotelReservation hotelReservationObject = new HotelReservation();
        Assert.assertTrue(hotelReservationObject.addHotel("Lakewood", 110, 90));
        Assert.assertTrue(hotelReservationObject.addHotel("Bridgewood", 160, 60));
        Assert.assertTrue(hotelReservationObject.addHotel("Ridgewood", 220, 150));

        hotelReservationObject.printHotels();
    }

    /**
     * UC4 Testing
     */
    @Test
    public void whenFindCheapestHotelIsCalled_shouldReturn_nameOfHotelWithCheapestRent() {
        HotelReservation hotelReservation = new HotelReservation();
        Assert.assertTrue(hotelReservation.addHotel("Lakewood", 110, 90));
        Assert.assertTrue(hotelReservation.addHotel("Bridgewood", 160, 60));
        Assert.assertTrue(hotelReservation.addHotel("Ridgewood", 220, 150));
        Assert.assertTrue(hotelReservation.findCheapestHotel("11 Sep 2020", "12 Sep 2020"));
    }

    @Test
    public void whenNewHotelAddedWithRating_shouldReturnTrue() {
        HotelReservation hotelReservationObject = new HotelReservation();
        hotelReservationObject.addHotel("Lakewood", 110, 90, 3);
        hotelReservationObject.addHotel("Bridgewood", 160, 60, 4);
        hotelReservationObject.addHotel("Ridgewood", 220, 150, 5);

        hotelReservationObject.printHotels();
    }
    //uc6
    @Test
    public void whenCheapestBestRatedCalled_shouldReturn_bestRatedHotel() {
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel("Lakewood", 110, 90, 3);
        hotelReservation.addHotel("Bridgewood", 150, 50, 4);
        hotelReservation.addHotel("Ridgewood", 220, 150, 5);
        Assert.assertTrue(hotelReservation.cheapestBestRatedHotel("11 Sep 2020", "12 Sep 2020"));
    }
}