import java.time.LocalDate;

public class Consultation{

    // Attributes of the Consultation class
    private Patient patient;
    private LocalDate consultDate;
    private int noOfHours;
    private int cost;
    private String notes;
    private long docID;

    // Constructor of the Consultation class
    public Consultation(Patient patient,LocalDate consultDate,int noOfHours,int cost,String notes,long docID){
        this.patient = patient;
        this.consultDate = consultDate;
        this.noOfHours = noOfHours;
        this.cost = cost;
        this.notes = notes;
        this.docID = docID;
    }

    // Getters and Setters of the Consultation class
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getConsultDate() {
        return consultDate;
    }

    public void setConsultDate(LocalDate consultDate) {
        this.consultDate = consultDate;
    }

    public int getNoOfHours() {
        return noOfHours;
    }

    public void setNoOfHours(int noOfHours) {
        this.noOfHours = noOfHours;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public long getDocID() {
        return docID;
    }

    public void setDocID(long docID) {
        this.docID = docID;
    }
}
