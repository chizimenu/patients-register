import java.time.LocalDate;

public class Patient extends Person {
    protected boolean isInsured = false;

    public Patient(String name, LocalDate dob, char gender, String address, String phoneNumber, boolean isInsured) {
        super(name, dob, gender, address, phoneNumber);
        this.isInsured = isInsured;

    }

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
}