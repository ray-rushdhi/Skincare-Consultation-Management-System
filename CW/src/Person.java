import java.time.LocalDate;
public class Person {

    // Attributes of the Person class
    private String name;
    private String surname;
    private LocalDate dob;
    private long mobNo;

    // Constructor of the Person class
    public Person(String name, String surname, LocalDate dob, long mobNo){
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.mobNo = mobNo;
    }

    // Getters and Setters of the Person class
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public long getMobNo() {
        return mobNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setMobNo(int mobNo) {
        this.mobNo = mobNo;
    }
}

