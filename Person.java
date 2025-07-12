import java.time.LocalDate;
import java.time.Period;

// This class represents a person with basic attributes like
public class Person {
    protected String name;
    protected char gender;
    protected LocalDate dob;
    protected String address;
    protected String phoneNumber;

    // Constructor to initialize a Person object with name, date
    public Person(String name, LocalDate dob, char gender, String address, String phoneNumber) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;

    }

    // Method to calculate the age of the person based on the date of birth
    // and the current date
    public int getAge() {
        LocalDate today = LocalDate.now();
        Period period = Period.between(dob, today);
        return period.getYears();
    }

    // Getters for the attributes
    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}