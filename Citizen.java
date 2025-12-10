/**
 * 
 * 
 * @author Ellie Russo
 * @version 1.0
 * @since 12/10/2025
 */
public class Citizen {
    private String firstName;
    private String lastName;

    /**
     * No-arg constructor sets firstName and lastName to "No Name"
     */
    public Citizen() {
        this.firstName = "No Name";
        this.lastName = "No Name";
    }

    /**
     * Constructor to set firstName and lastName
     * @param inFirst First name of the citizen
     * @param inLast Last name of the citizen
     */
    public Citizen(String inFirst, String inLast) {
        this.firstName = inFirst;
        this.lastName = inLast;
    }

    /**
     * Gets the first name
     * @return firstName of citizen
     */
    public String getFirstName() { return firstName; }

    /**
     * Sets the first name
     * @param inFirst First name to set
     */
    public void setFirstName(String inFirst) { this.firstName = inFirst; }

    /**
     * Gets the last name
     * @return lastName of citizen
     */
    public String getLastName() { return lastName; }

    /**
     * Sets the last name
     * @param inLast Last name to set
     */
    public void setLastName(String inLast) { this.lastName = inLast; }

    /**
     * Returns the full name as "firstName lastName"
     * @return String representation of citizen's name
     */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
