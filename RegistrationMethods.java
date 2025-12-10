import java.io.*;
import java.util.*;

/**
 * 
 * 
 * @author Ellie Russo
 * @version 1.0
 * @since 12/10/2025
 */
public class RegistrationMethods {
    private String inputFileName;
    private String outputFileName;
    public static final int REG_MONTH = 4;
    public static final int REG_YEAR = 2025;

    /**
     * Prompts user for input/output file paths and validates input file
     * @throws IOException if file cannot be found or read
     */
    public void setFileNames() throws IOException {
        Scanner sc = new Scanner(System.in);
        File inputFile;

        // Input file
        do {
            System.out.print("Enter the path to the registrations.csv file: ");
            inputFileName = sc.nextLine();
            inputFile = new File(inputFileName);
            if (!inputFile.exists()) {
                System.out.println("File not found. Please try again.");
            }
        } while (!inputFile.exists());

        // Output file
        System.out.print("Enter the path where output.txt should be saved: ");
        outputFileName = sc.nextLine();
    }

    /**
     * Returns the number of data lines in the CSV (excluding header)
     * @return number of CarOwner records
     * @throws IOException if file cannot be read
     */
    public int getArraySize() throws IOException {
        File file = new File(inputFileName);
        Scanner sc = new Scanner(file);
        sc.nextLine(); // skip header
        int count = 0;
        while (sc.hasNextLine()) {
            sc.nextLine();
            count++;
        }
        sc.close();
        return count;
    }

    /**
     * Reads CSV and fills CarOwner array
     * @param inArray array to store CarOwner objects
     * @throws IOException if file cannot be read
     */
    public void processTextToArray(CarOwner[] inArray) throws IOException {
        File file = new File(inputFileName);
        Scanner sc = new Scanner(file);
        sc.nextLine(); // skip header
        int index = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] tokens = line.split(","); // CSV split
            String last = tokens[0].trim();
            String first = tokens[1].trim();
            String license = tokens[2].trim();
            int month = Integer.parseInt(tokens[3].trim());
            int year = Integer.parseInt(tokens[4].trim());

            inArray[index] = new CarOwner(first, last, license, month, year);
            index++;
        }
        sc.close();
    }

    /**
     * Prints array to file with header
     * @param inMsg header message to display in file
     * @param inArray array of CarOwner objects to print
     * @throws IOException if file cannot be written
     */
    public void printArrayToFile(String inMsg, CarOwner[] inArray) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(outputFileName, true));
        pw.println(inMsg);
        for (CarOwner owner : inArray) {
            pw.println(owner);
        }
        pw.println();
        pw.close();
    }

    /**
     * Returns array of owners whose registration is over 12 months old
     * @param inArray array of CarOwner objects
     * @return array of overdue CarOwner objects
     */
    public CarOwner[] flagOverdueOwners(CarOwner[] inArray) {
        int totalMonths = REG_YEAR * 12 + REG_MONTH;
        int count = 0;

        for (CarOwner owner : inArray) {
            int ownerMonths = owner.getYear() * 12 + owner.getMonth();
            if (totalMonths - ownerMonths > 12) {
                count++;
            }
        }

        CarOwner[] overdue = new CarOwner[count];
        int idx = 0;
        for (CarOwner owner : inArray) {
            int ownerMonths = owner.getYear() * 12 + owner.getMonth();
            if (totalMonths - ownerMonths > 12) {
                overdue[idx++] = owner;
            }
        }
        return overdue;
    }

    /**
     * Returns array of owners whose registration will expire in 3 months or less (10-12 months old)
     * @param inArray array of CarOwner objects
     * @return array of almost-due CarOwner objects
     */
    public CarOwner[] flagAlmostDueOwners(CarOwner[] inArray) {
        int totalMonths = REG_YEAR * 12 + REG_MONTH;
        int count = 0;

        for (CarOwner owner : inArray) {
            int ownerMonths = owner.getYear() * 12 + owner.getMonth();
            int diff = totalMonths - ownerMonths;
            if (diff > 9 && diff <= 12) {
                count++;
            }
        }

        CarOwner[] almostDue = new CarOwner[count];
        int idx = 0;
        for (CarOwner owner : inArray) {
            int ownerMonths = owner.getYear() * 12 + owner.getMonth();
            int diff = totalMonths - ownerMonths;
            if (diff > 9 && diff <= 12) {
                almostDue[idx++] = owner;
            }
        }
        return almostDue;
    }

    /**
     * Returns the path of the output file
     * @return output file path as String
     */
    public String getOutputFileName() {
        return outputFileName;
    }
}
