import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    private ArrayList<Patient> patientList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addPatient() {
        System.out.print("Enter patient's name: ");
        String name = scanner.nextLine();

        // Get and validate date of birth
        LocalDate dob = null;
        while (dob == null) {
            try {
                System.out.print("Enter date of birth (YYYY-MM-DD): ");
                String dobInput = scanner.nextLine();
                dob = LocalDate.parse(dobInput);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter in YYYY-MM-DD format.");
            }
        }

        // Get and validate gender
        char gender = ' ';
        while (gender != 'M' && gender != 'F') {
            System.out.print("Enter gender (M/F): ");
            String genderInput = scanner.nextLine().trim().toUpperCase();
            if (genderInput.length() == 1 && (genderInput.charAt(0) == 'M' || genderInput.charAt(0) == 'F')) {
                gender = genderInput.charAt(0);
            } else {
                System.out.println("Invalid input. Please enter M or F.");
            }
        }

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        // Get and validate insurance status
        boolean isInsured = false;
        while (true) {
            System.out.print("Is the patient insured? (yes/no): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes")) {
                isInsured = true;
                break;
            } else if (input.equals("no")) {
                isInsured = false;
                break;
            } else {
                System.out.println("Please enter 'yes' or 'no'.");
            }
        }

        Patient patient = new Patient(name, dob, gender, address, phoneNumber, isInsured);
        patientList.add(patient);
        System.out.println("\nPatient added successfully!");
        System.out.println("---------------------------");
        System.out.println(patient);
        System.out.println("---------------------------\n");
    }

    public void displayAllPatients() {
        if (patientList.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        System.out.println("All Patients:");
        for (Patient p : patientList) {
            System.out.println("---------------------------");
            System.out.println(p);
        }
        System.out.println("---------------------------");
    }

    // Optional: method to delete or search patients by name, etc.
}
