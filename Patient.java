import java.time.LocalDate;

// This class represents a patient, which is a specialized type of person
// It extends the Person class and adds an insurance status attribute
public class Patient extends Person {
    protected boolean isInsured = false;

    // Constructor to initialize a Patient object with name, date
    public Patient(String name, LocalDate dob, char gender, String address, String phoneNumber, boolean isInsured) {
        super(name, dob, gender, address, phoneNumber);
        this.isInsured = isInsured;

    }

    // Override the toString method to provide a string representation of the
    // patient
    // This includes all the attributes from the Person class and the insurance
    // status
    @Override
    public String toString() {
        return "Name: " + getName() +
                "\nGender: " + getGender() +
                "\nDate of Birth: " + getDob() +
                "\nAddress: " + getAddress() +
                "\nPhone Number: " + getPhoneNumber() +
                "\nAge: " + getAge() +
                "\nInsured: " + (isInsured ? "Yes" : "No");
    }

    // Getter for the insurance status
    public boolean isInsured() {
        return isInsured;
    }
}