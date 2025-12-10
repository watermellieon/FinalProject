import java.io.IOException;

/**
 * 
 * 
 * @author Ellie Russo
 * @version 1.0
 * @since 12/10/2025
 */
public class RegistrationDemo {
    public static void main(String[] args) {
        try {
            RegistrationMethods dmv = new RegistrationMethods();

            // Set file names
            dmv.setFileNames();

            // Get array size
            int size = dmv.getArraySize();
            CarOwner[] ltState = new CarOwner[size];

            // Process CSV to array
            dmv.processTextToArray(ltState);

            // Print list of all CarOwners
            dmv.printArrayToFile("List of Car Owners", ltState);

            // Flag overdue owners and print
            CarOwner[] overdue = dmv.flagOverdueOwners(ltState);
            dmv.printArrayToFile("Owners with Expired Registration", overdue);

            // Flag almost-due owners and print
            CarOwner[] almostDue = dmv.flagAlmostDueOwners(ltState);
            dmv.printArrayToFile("Owners with registration expiring in three months or less", almostDue);

            // Print output file location
            System.out.println("The output file can be found at: " + dmv.getOutputFileName());

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
