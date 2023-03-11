import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    public static ArrayList<Doctor> doctorsList = new ArrayList<>(); // Arraylist of Doctor objects
    public static ArrayList<Consultation> consultList = new ArrayList<>(); // Arraylist of Consultation objects
    public static ArrayList<Patient> patientsList = new ArrayList<>(); // Arraylist of Patient objects

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        initial:
        while (true) { // Creating a while loop to continuously run the program

            System.out.println(" ");
            System.out.println("----------Skin Care Consultation Center----------");
            System.out.println(" ");
            System.out.println("Menu Options");
            System.out.println(" ");
            System.out.println("1 - Add a new Doctor");
            System.out.println("2 - Delete a Doctor");
            System.out.println("3 - View the list of Doctors");
            System.out.println("4 - Save data");
            System.out.println("5 - Load Data");
            System.out.println("6 - Open the GUI");
            System.out.println("7 - Exit the Program.");
            System.out.println(" ");
            System.out.print("Enter an option : ");
            String option = sc.nextLine();
            System.out.println(" ");

            switch (option) { // Using a switch case to loop through all the functions

                case "1":
                    addNewDoctor();
                    break;
                case "2":
                    removeDoctor();
                    break;
                case "3":
                    viewListOfDoctors();
                    break;
                case "4":
                    saveData();
                    break;
                case "5":
                    loadData();
                    break;
                case "6":
                    new GUI();
                    break;
                case "7":
                    break initial;
                default:
                    System.out.println("Please enter a valid input");
            }
        }
    }

    public static void addNewDoctor() { // Method to add a doctor to the list

        boolean available = checkAvailability(); // Check if the doctors list contains less than 10 doctors
        if (available) {
            while (true) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the first name of the doctor : ");
                if (sc.hasNextLine()) {
                    String docFirstName = sc.nextLine();
                    while (!docFirstName.matches("[a-zA-Z ]+")) { // Check if user has input any number
                        System.out.print("Please enter a valid name! : ");
                        docFirstName = sc.nextLine();
                    }
                    System.out.print("Enter the surname of the doctor : ");
                    if (sc.hasNextLine()) {
                        String docSurname = sc.nextLine();
                        while (!docSurname.matches("[a-zA-Z ]+")) { // Check if user has input any number
                            System.out.print("Please enter a valid name! : ");
                            docSurname = sc.nextLine();
                        }
                        System.out.println();
                        System.out.println("Enter the date of birth of the doctor");
                        System.out.println();
                        System.out.print("Enter the year : ");
                        if (sc.hasNextInt()) {
                            int year = sc.nextInt();
                            while (!(year > 1930 && year <= 2001)) { // Input validation
                                System.out.print("Please enter a valid year : ");
                                year = sc.nextInt();
                            }
                            System.out.print("Enter the month : ");
                            if (sc.hasNextInt()) {
                                int month = sc.nextInt();
                                while (!(month > 0 && month < 13)) { // Input validation
                                    System.out.print("Please enter a valid month : ");
                                    month = sc.nextInt();
                                }
                                System.out.print("Enter the date : ");
                                if (sc.hasNextInt()) {
                                    int date = sc.nextInt();
                                    while (!(date > 0 && date <= 31)) { // Input validation
                                        System.out.print("Please enter a valid date : ");
                                        date = sc.nextInt();
                                    }
                                    System.out.print("Enter the mobile number : ");
                                    if (sc.hasNextLong()) {
                                        long mobNo = sc.nextLong();
                                        while (!(mobNo > 0 && mobNo <= 999999999)) { // Input validation
                                            System.out.print("Please enter a valid mobile number : ");
                                            mobNo = sc.nextLong();
                                        }
                                        System.out.print("Enter the license number : ");
                                        if (sc.hasNextLong()) {
                                            long licenseNo = sc.nextLong();
                                            while (!(licenseNo > 0 && licenseNo <= 999999)) { // Input validation
                                                System.out.print("Please enter a valid license number : ");
                                                licenseNo = sc.nextLong();
                                            }
                                            System.out.print("Enter the specialization of the doctor : ");
                                            if (sc.hasNext()) {
                                                String docSpecialization = sc.next();
                                                while (!docSpecialization.matches("[a-zA-Z ]+")) { // Check if user has input any number
                                                    System.out.print("Please enter a valid input! : ");
                                                    docSpecialization = sc.next();
                                                }
                                                System.out.println(" ");
                                                // Add and display the doctor has been added to the list
                                                System.out.println("Dr." + docFirstName + " " + docSurname + " has been added to the list of doctors");
                                                doctorsList.add(new Doctor(docFirstName, docSurname, LocalDate.of(year, month, date), mobNo, licenseNo, docSpecialization));
                                                break;
                                            } else {
                                                System.out.println("Please enter a valid input");
                                            }
                                        } else {
                                            System.out.println("Please enter a valid license number");
                                        }
                                    } else {
                                        System.out.println("Please enter a valid mobile number");
                                    }
                                } else {
                                    System.out.println("Please enter a valid date");
                                }
                            } else {
                                System.out.println("Please enter a valid month");
                            }
                        } else {
                            System.out.println("Please enter a valid year");
                        }
                    } else {
                        System.out.println("Please enter a valid name");
                    }
                } else {
                    System.out.println("Please enter a valid name");
                }
            }
        } else {
            System.out.println("There are no more available slots for doctors");
        }
    }

    public static void removeDoctor() { // Method to remove a doctor from the list

        if (doctorsList.size() > 0) { // Check if doctors list has any doctors
            System.out.println("Number of available doctors : " + doctorsList.size());
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the medical license number of the doctor you wish to remove : ");
            if (sc.hasNextLong()) {
                long licenseNo = sc.nextLong();
                while (!(licenseNo > 0 && licenseNo <= 999999)) { // Input validation
                    System.out.print("Please enter a valid license number : ");
                    licenseNo = sc.nextLong();
                }
                boolean doctorAvailable = false;
                for (int x = 0; x < doctorsList.size(); x++) {
                    if (licenseNo == doctorsList.get(x).getLicenseNo()) { // Check if the doctor is in the list
                        doctorAvailable = true;
                        System.out.println(" ");
                        // Remove the doctor according to the license number
                        System.out.println("Dr." + doctorsList.get(x).getName() + " " + doctorsList.get(x).getSurname() + " has been removed from the list");
                        doctorsList.remove(x);
                    }
                }
                if (!doctorAvailable) {
                    System.out.println("The license number doesn't match any of the doctors in the list");
                }
            } else {
                System.out.println("Please enter a valid license number");
            }
        } else {
            System.out.println("There are no available doctors");
        }
    }

    static class NameComparator implements Comparator<Doctor> { // Comparator method to sort the doctors list

        // Code reference - https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
        @Override
        public int compare(Doctor doc1, Doctor doc2) {
            return doc1.getSurname().compareTo(doc2.getSurname());
        }

    }

    public static void viewListOfDoctors() { // Method to sort the doctors list
        ArrayList<Doctor> doctorsListCopy = (ArrayList<Doctor>) doctorsList.clone(); // Clone a list of doctors which will be sorted and printed
        Collections.sort(doctorsListCopy, new NameComparator()); // Implement the comparator method to the cloned list
        System.out.println("------------------------------------------List of Doctors------------------------------------------");
        System.out.println();
        System.out.printf("%-15s%-15s%-20s%-20s%-20s%-20s\n", "First Name", "Last Name", "Date of Birth", "Mobile Number", "License Number", "Specialization");
        System.out.println("\n");
        for (int x = 0; x < doctorsListCopy.size(); x++) { // Print the sorted list
            System.out.printf("%-15s%-15s%-20s%-20d%-20d%-20s\n", doctorsListCopy.get(x).getName(), doctorsListCopy.get(x).getSurname(), doctorsListCopy.get(x).getDob(),
                    doctorsListCopy.get(x).getMobNo(), doctorsListCopy.get(x).getLicenseNo(), doctorsListCopy.get(x).getSpecialization());
        }
        doctorsListCopy.clear(); // Clear the cloned list
    }

    public static void saveData() throws IOException { // Method to save data into CSV files

        Scanner sc = new Scanner(System.in);
        FileWriter myWriterDoc = new FileWriter("doctorData.txt"); // Create a FileWriter object
        FileWriter myWritePat = new FileWriter("patientData.txt"); // Create a FileWriter object
        FileWriter myWriteCon = new FileWriter("consultData.txt"); // Create a FileWriter object
        System.out.println("Are you sure you want to overwrite the saved data if data is already stored?");
        System.out.print("Enter Y / N : ");
        if (sc.hasNextLine()) { // Input validation
            String ans = sc.nextLine().toUpperCase();
            if (ans.equals("Y")) {

                for (int x = 0; x < doctorsList.size(); x++) { // Write details of the doctor to the file in a specific format
                    myWriterDoc.write(getDoctorString(x));
                }
                myWriterDoc.close();

                for (int x = 0; x < patientsList.size(); x++) {
                    myWritePat.write(getPatientString(x));
                }
                myWritePat.close();

                for (int x = 0; x < consultList.size(); x++) {
                    myWriteCon.write(getConsultString(x));
                }
                myWriteCon.close();

                System.out.println("The data has been successfully stored");
            } else {
                System.out.println("The saved data won't be overwritten");
            }
        } else {
            System.out.println("Please enter a valid input. Try again");
        }
    }

    public static void loadData() throws IOException { // Method to load data from CSV files

        // Code reference - https://www.youtube.com/watch?v=-Aud0cDh-J8
        File docFile = new File("doctorData.txt"); // Create a File object
        Scanner docRead = new Scanner(docFile); // Create a Scanner object to read the file
        File patFile = new File("patientData.txt");
        Scanner patRead = new Scanner(patFile);
        File conFile = new File("consultData.txt");
        Scanner conRead = new Scanner(conFile);
        Scanner sc = new Scanner(System.in);

        System.out.println("Are you sure you want to load data and overwrite the current data?");
        System.out.print("Enter Y/N : ");
        if (sc.hasNextLine()) { // Input validation
            String ans = sc.nextLine().toUpperCase();
            if (ans.equals("Y")) {
                // Clear existing data
                doctorsList.clear();
                String doctorDetails;
                while (docRead.hasNextLine()) { // Loop for 10 times to get all the doctor details in the CSV file
                    doctorDetails = docRead.nextLine();
                    // Store each line into an array and separate the data using commas
                    String[] parts = doctorDetails.split(",");
                    // Check if the line is an empty space
                    if (doctorDetails.length() > 2) {
                        // Add doctors using the comma separated values in the array above
                        String firstName = parts[0];
                        String surName = parts[1];
                        LocalDate dob = LocalDate.parse(parts[2]);
                        long mobNo = Long.parseLong(parts[3]);
                        long licenseNo = Long.parseLong(parts[4]);
                        String specialization = parts[5];
                        doctorsList.add(new Doctor(firstName, surName, dob, mobNo, licenseNo, specialization));
                    }
                }
                docRead.close();

                patientsList.clear();
                String patientDetails;
                while (patRead.hasNextLine()) {
                    patientDetails = patRead.nextLine();
                    String[] parts = patientDetails.split(",");
                    if (patientDetails.length() > 2) {
                        String patFirstName = parts[0];
                        String patSurName = parts[1];
                        LocalDate patDOB = LocalDate.parse(parts[2]);
                        long patMobNo = Long.parseLong(parts[3]);
                        int patID = Integer.parseInt(parts[4]);
                        patientsList.add(new Patient(patFirstName, patSurName, patDOB, patMobNo, patID));
                    }
                }
                patRead.close();

                consultList.clear();
                String consultDetails;
                while (conRead.hasNextLine()) {
                    consultDetails = conRead.nextLine();
                    String[] parts = consultDetails.split(",");
                    if (consultDetails.length() > 2) {
                        String conFirstName = parts[0];
                        String conSurName = parts[1];
                        LocalDate conDOB = LocalDate.parse(parts[2]);
                        long conMobNo = Long.parseLong(parts[3]);
                        int conID = Integer.parseInt(parts[4]);
                        Patient patient = new Patient(conFirstName, conSurName, conDOB, conMobNo, conID);
                        LocalDate conDate = LocalDate.parse(parts[5]);
                        int hours = Integer.parseInt(parts[6]);
                        int cost = Integer.parseInt(parts[7]);
                        String notes = parts[8];
                        long docID = Long.parseLong(parts[9]);
                        consultList.add(new Consultation(patient, conDate, hours, cost, notes, docID));
                    }
                }
                conRead.close();

                System.out.println("The data has been successfully loaded");

            } else {
                System.out.println("The data won't be overwritten");
            }
        } else {
            System.out.println("Please enter a valid input. Try again");
        }
    }


    public static boolean checkAvailability() { // Method to check if the doctors list has more than 10 entries

        boolean available = false;
        if (doctorsList.size() < 10) {
            available = true;
        }
        return available;
    }

    public static String getDoctorString(int x) { // Method to return a formatted String to write into CSV files
        String data;
        String firstName = doctorsList.get(x).getName();
        String lastName = doctorsList.get(x).getSurname();
        LocalDate dob = doctorsList.get(x).getDob();
        long mobNo = doctorsList.get(x).getMobNo();
        long licenseNo = doctorsList.get(x).getLicenseNo();
        String specialization = doctorsList.get(x).getSpecialization();
        data = firstName + "," + lastName + "," + dob + "," + mobNo + "," + licenseNo + "," + specialization + "\n";
        return data;
    }

    public static String getPatientString(int x) { // Method to return a formatted String to write into CSV files
        String data;
        String firstName = patientsList.get(x).getName();
        String lastName = patientsList.get(x).getSurname();
        LocalDate dob = patientsList.get(x).getDob();
        long mobNo = patientsList.get(x).getMobNo();
        int patID = patientsList.get(x).getPatientID();
        data = firstName + "," + lastName + "," + dob + "," + mobNo + "," + patID + "\n";
        return data;
    }

    public static String getConsultString(int x) { // Method to return a formatted String to write into CSV files
        String data;
        String firstName = consultList.get(x).getPatient().getName();
        String lastName = consultList.get(x).getPatient().getSurname();
        LocalDate dob = consultList.get(x).getPatient().getDob();
        long mobNo = consultList.get(x).getPatient().getMobNo();
        int patID = consultList.get(x).getPatient().getPatientID();
        LocalDate conDate = consultList.get(x).getConsultDate();
        int hours = consultList.get(x).getNoOfHours();
        int cost = consultList.get(x).getCost();
        String notes = consultList.get(x).getNotes();
        long docID = consultList.get(x).getDocID();
        data = firstName + "," + lastName + "," + dob + "," + mobNo + "," + patID + "," + conDate + "," + hours + "," + cost + "," + notes + "," + docID + "\n";
        return data;
    }
}

