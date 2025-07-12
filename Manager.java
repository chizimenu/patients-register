import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Manager {
    private ArrayList<Patient> patientList = new ArrayList<>();// Empty Array list created to store Patient objects
    private Scanner scanner = new Scanner(System.in); // Scanner object to read user input

    public void addPatient() {
        // Get and validate patient name
        String name = null;
        while (name == null || name.trim().isEmpty()) {
            System.out.print("Enter patient name: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty. Please enter a valid name.");
            }
        }

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
        // Get address
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        // Get phone number
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
        // Create a new Patient object and add it to the list
        Patient patient = new Patient(name, dob, gender, address, phoneNumber, isInsured);
        patientList.add(patient);
        System.out.println("\nPatient added successfully!");
        System.out.println("---------------------------");
        System.out.println(patient);
        System.out.println("---------------------------\n");
    }

    // Method to display all patients
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

    // Method to save patients to a file
    public void savePatientsToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Patient p : patientList) {
                String line = String.join(",",
                        p.getName(),
                        p.getDob().toString(),
                        String.valueOf(p.getGender()),
                        p.getAddress(),
                        p.getPhoneNumber(),
                        String.valueOf(p.isInsured()));
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Patients saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving patients to file: " + e.getMessage());
        }
    }

    // Method to load patients from a file
    public void loadPatientsFromFile(String filename) {
        patientList.clear(); // Clear existing patients before loading
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String name = parts[0];
                    LocalDate dob = LocalDate.parse(parts[1]);
                    char gender = parts[2].charAt(0);
                    String address = parts[3];
                    String phoneNumber = parts[4];
                    boolean isInsured = Boolean.parseBoolean(parts[5]);

                    Patient patient = new Patient(name, dob, gender, address, phoneNumber, isInsured);
                    patientList.add(patient);
                }
            }

            System.out.println("Patients data succesffully loaded from " + filename);

        } catch (IOException e) {
            System.out.println("Error loading patient data: " + e.getMessage());

        }

    }
}