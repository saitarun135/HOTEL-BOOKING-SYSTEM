import org.junit.Assert;
import org.junit.Test;
//import org.junit.jupiter.api.Assertions;

public class HotelReservationTest {
    HotelReservation hotelReservation = new HotelReservation();

    @Test
    public void checkedGivenHotelNameAndRateAreAdded_True()
    {
        boolean result = hotelReservation.addHotel("Lakewood",110);
        Assert.assertTrue(result);
    }


}