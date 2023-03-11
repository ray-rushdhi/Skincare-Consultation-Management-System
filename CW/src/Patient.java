import java.time.LocalDate;

public class Patient extends Person{ // Patient is a subclass of the superclass Person

    // Attributes of the Patient class
    private int patientID;

    // Constructor of the Patient class
    public Patient(String name, String surname, LocalDate dob, long mobNo, int patientID){
        super(name, surname, dob, mobNo);
        this.patientID = patientID;
    }

    // Getters and Setters of the Patient Class
    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }
}
