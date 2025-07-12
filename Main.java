import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager(); // Create an instance of Manager to manage patient data
        Scanner scanner = new Scanner(System.in); // Scanner object to read user input
        String option; // Variable to store user option
        String fileName;// Variable to store file name for saving/loading patient data
        // Main loop to display options and handle user input
        System.out.println("Welcome to the Clinic Patient Manager!");
        do {
            System.out.println("\nClinic Patient Manager");
            System.out.println("1. Add New Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Save To A File");
            System.out.println("4. Load Patients Data From A File");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    manager.addPatient();
                    break;
                case "2":
                    manager.displayAllPatients();
                    break;
                case "3":
                    System.out.print("Enter file name to save patients: ");
                    fileName = scanner.nextLine();
                    manager.savePatientsToFile(fileName);
                    System.out.println("Patients saved to " + fileName);
                    break;
                case "4":
                    System.out.print("Enter a file name: ");
                    fileName = scanner.nextLine();
                    manager.loadPatientsFromFile(fileName);
                    break;
                case "5":
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1, 2, 3, 4, or 5.");
            }
        } while (!option.equals("5"));

        scanner.close();
    }
}
