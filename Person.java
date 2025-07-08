import java.time.LocalDate;
import java.time.Period;

public class Person {
    protected String name;
    protected char gender;
    protected LocalDate dob;
    protected String address;
    protected String phoneNumber;

    public Person(String name, LocalDate dob, char gender, String address, String phoneNumber) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;

    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        Period period = Period.between(dob, today);
        return period.getYears();
    }

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

}