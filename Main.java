import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);
        String option;

        do {
            System.out.println("\nClinic Patient Manager");
            System.out.println("1. Add New Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Exit");
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
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        } while (!option.equals("3"));

        scanner.close();
    }
}
