/**
 * 
 * 
 * @author Ellie Russo
 * @version 1.0
 * @since 12/10/2025
 */
public class CarOwner extends Citizen {
    private String license;
    private int month;
    private int year;

    /**
     * No-arg constructor sets default values
     */
    public CarOwner() {
        super(); // sets firstName and lastName to "No Name"
        this.license = "Not Assigned";
        this.month = 0;
        this.year = 0;
    }

    /**
     * Constructor to set all fields
     * @param inFirst First name
     * @param inLast Last name
     * @param inLicense License plate
     * @param inMonth Registration month
     * @param inYear Registration year
     */
    public CarOwner(String inFirst, String inLast, String inLicense, int inMonth, int inYear) {
        super(inFirst, inLast);
        this.license = inLicense;
        this.month = inMonth;
        this.year = inYear;
    }

    /**
     * Gets the license
     * @return license plate
     */
    public String getLicense() { return license; }

    /**
     * Sets the license
     * @param inLicense License plate to set
     */
    public void setLicense(String inLicense) { this.license = inLicense; }

    /**
     * Gets the registration month
     * @return registration month
     */
    public int getMonth() { return month; }

    /**
     * Sets the registration month
     * @param inMonth Month to set
     */
    public void setMonth(int inMonth) { this.month = inMonth; }

    /**
     * Gets the registration year
     * @return registration year
     */
    public int getYear() { return year; }

    /**
     * Sets the registration year
     * @param inYear Year to set
     */
    public void setYear(int inYear) { this.year = inYear; }

    /**
     * Returns full info as "firstName lastName license month/year"
     * @return String representation of CarOwner
     */
    @Override
    public String toString() {
        return super.toString() + "\t" + license + " " + month + "/" + year;
    }
}
