public class Hotel {

    public String hotelName;
    public int regWeekdayRate;
    public int regWeekendRate;

    public int getRegWeekendRate() {
        return regWeekendRate;
    }

    public void setRegWeekendRate(int regWeekendRate) {
        this.regWeekendRate = regWeekendRate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getRegWeekdayRate() {
        return regWeekdayRate;
    }

    public void setRegWeekdayRate(int regWeekdayRate) {
        this.regWeekdayRate = regWeekdayRate;
    }

    public Hotel(String hotelName, int regWeekdayRate) {
        super();
        this.hotelName = hotelName;
        this.regWeekdayRate = regWeekdayRate;
    }

    public Hotel(String hotelName, int regWeekdayRate, int regWeekendRate) {
        super();
        this.hotelName = hotelName;
        this.regWeekdayRate = regWeekdayRate;
        this.regWeekendRate = regWeekendRate;
    }
}