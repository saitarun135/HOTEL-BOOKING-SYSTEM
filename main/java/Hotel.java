public class Hotel {

    public String hotelName;
    public int regWeekdayRate;
    public int regWeekendRate;
    public int hotelRating;
    public int rewWeekdayRate;
    public int rewWeekendRate;

    public int getRewWeekdayRate() {
        return rewWeekdayRate;
    }

    public void setRewWeekdayRate(int rewWeekdayRate) {
        this.rewWeekdayRate = rewWeekdayRate;
    }

    public int getRewWeekendRate() {
        return rewWeekendRate;
    }

    public void setRewWeekendRate(int rewWeekendRate) {
        this.rewWeekendRate = rewWeekendRate;
    }

    public int getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(int hotelRating) {
        this.hotelRating = hotelRating;
    }

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

    public Hotel(String hotelName, int regWeekdayRate, int regWeekendRate, int hotelRating) {
        super();
        this.hotelName = hotelName;
        this.regWeekdayRate = regWeekdayRate;
        this.regWeekendRate = regWeekendRate;
        this.hotelRating = hotelRating;
    }

    public Hotel(String hotelName, int regWeekdayRate, int regWeekendRate, int hotelRating, int rewWeekdayRate,
                 int rewWeekendRate) {
        super();
        this.hotelName = hotelName;
        this.regWeekdayRate = regWeekdayRate;
        this.regWeekendRate = regWeekendRate;
        this.hotelRating = hotelRating;
        this.rewWeekdayRate = rewWeekdayRate;
        this.rewWeekendRate = rewWeekendRate;
    }

}