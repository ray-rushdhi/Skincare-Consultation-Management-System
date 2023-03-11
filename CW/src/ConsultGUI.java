import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

public class ConsultGUI { // GUI to add a consultation

    static JPanel consultPanel = new JPanel(null);

    static JTextField name = new JTextField();
    static JTextField surname = new JTextField();
    static JTextField bYear = new JTextField();
    static JTextField bMonth = new JTextField();
    static JTextField bDate = new JTextField();
    static JTextField mobile = new JTextField();
    static JTextField patID = new JTextField();
    static JTextField cYear = new JTextField();
    static JTextField cMonth = new JTextField();
    static JTextField cDate = new JTextField();
    static JTextField noOfHours = new JTextField();
    static JComboBox doctorID;
    static JTextArea addNotes = new JTextArea();
    static long newDocNo;
    static boolean newPatient = false;

    static JButton submit = new JButton("Submit");
    static JButton view = new JButton("View");
    static JButton save = new JButton("Save");
    static JButton browse = new JButton("Add image");
    static File selectedImageFile;
    static String selectedImagePath;


    public ConsultGUI() throws IOException { // Constructor

        JFrame frame = new JFrame();
        frame.add(consultPanel);
        frame.setTitle("Skincare Consultation System");
        frame.setSize(640, 800);
        frame.setVisible(true);

        consultPanel.setBackground(new Color(0x123456));

        JLabel topicMain = new JLabel("Skincare Consultation Center");
        topicMain.setBounds(150, 5, 300, 40);
        topicMain.setFont(new Font("MV Boli", Font.BOLD, 20));
        topicMain.setForeground(Color.WHITE);
        topicMain.setBackground(Color.black);
        topicMain.setOpaque(true);
        consultPanel.add(topicMain);

        JLabel consultTitle = new JLabel("Add a Consultation");
        consultTitle.setBounds(230, 60, 300, 40);
        consultTitle.setFont(new Font("MV Boli", Font.BOLD, 16));
        consultTitle.setForeground(Color.WHITE);
        consultPanel.add(consultTitle);

        JLabel patientTitle = new JLabel("Enter Patient Information");
        patientTitle.setBounds(35, 110, 300, 40);
        patientTitle.setFont(new Font("MV Boli", Font.PLAIN, 15));
        patientTitle.setForeground(Color.WHITE);
        consultPanel.add(patientTitle);

        JLabel patientName = new JLabel("Enter name:");
        consultPanel.add(patientName);
        patientName.setBounds(35,160,300,40);
        patientName.setForeground(Color.WHITE);
        patientName.setFont(new Font("Arial", Font.PLAIN,15));

        JLabel patientSurname = new JLabel("Enter surname:");
        consultPanel.add(patientSurname);
        patientSurname.setBounds(35,200,300,40);
        patientSurname.setForeground(Color.WHITE);
        patientSurname.setFont(new Font("Arial", Font.PLAIN,15));

        JLabel birthTitle = new JLabel("Enter birthday");
        consultPanel.add(birthTitle);
        birthTitle.setBounds(35,240,300,40);
        birthTitle.setForeground(Color.WHITE);
        birthTitle.setFont(new Font("Arial", Font.PLAIN,15));

        JLabel birthYear = new JLabel("Year:");
        consultPanel.add(birthYear);
        birthYear.setBounds(35,280,300,40);
        birthYear.setForeground(Color.WHITE);
        birthYear.setFont(new Font("Arial", Font.PLAIN,15));

        JLabel birthMonth = new JLabel("Month:");
        consultPanel.add(birthMonth);
        birthMonth.setBounds(200,280,300,40);
        birthMonth.setForeground(Color.WHITE);
        birthMonth.setFont(new Font("Arial", Font.PLAIN,15));

        JLabel birthDate = new JLabel("Date:");
        consultPanel.add(birthDate);
        birthDate.setBounds(365,280,300,40);
        birthDate.setForeground(Color.WHITE);
        birthDate.setFont(new Font("Arial", Font.PLAIN,15));

        JLabel mobNo = new JLabel("Mobile Number:");
        consultPanel.add(mobNo);
        mobNo.setBounds(35,320,300,40);
        mobNo.setForeground(Color.WHITE);
        mobNo.setFont(new Font("Arial", Font.PLAIN,15));

        JLabel patientID = new JLabel("Patient ID:");
        consultPanel.add(patientID);
        patientID.setBounds(35,360,300,40);
        patientID.setForeground(Color.WHITE);
        patientID.setFont(new Font("Arial", Font.PLAIN,15));

        JLabel consultTopic = new JLabel("Enter the Date of the Consultation");
        consultPanel.add(consultTopic);
        consultTopic.setBounds(35,400,300,40);
        consultTopic.setForeground(Color.WHITE);
        consultTopic.setFont(new Font("Arial", Font.PLAIN,15));

        JLabel consultYear = new JLabel("Year:");
        consultPanel.add(consultYear);
        consultYear.setBounds(35,440,300,40);
        consultYear.setForeground(Color.WHITE);
        consultYear.setFont(new Font("Arial", Font.PLAIN,15));

        JLabel consultMonth = new JLabel("Month:");
        consultPanel.add(consultMonth);
        consultMonth.setBounds(200,440,300,40);
        consultMonth.setForeground(Color.WHITE);
        consultMonth.setFont(new Font("Arial", Font.PLAIN,15));

        JLabel consultDate = new JLabel("Date:");
        consultPanel.add(consultDate);
        consultDate.setBounds(365,440,300,40);
        consultDate.setForeground(Color.WHITE);
        consultDate.setFont(new Font("Arial", Font.PLAIN,15));

        JLabel docID = new JLabel("Select the ID of the Doctor:");
        consultPanel.add(docID);
        docID.setBounds(35,480,300,40);
        docID.setForeground(Color.WHITE);
        docID.setFont(new Font("Arial", Font.PLAIN,15));

        JLabel hoursTitle = new JLabel("Enter the number of hours:");
        consultPanel.add(hoursTitle);
        hoursTitle.setBounds(35,520,300,40);
        hoursTitle.setForeground(Color.WHITE);
        hoursTitle.setFont(new Font("Arial", Font.PLAIN,15));

        JLabel notes = new JLabel("Additional Notes:");
        consultPanel.add(notes);
        notes.setBounds(35,560,300,40);
        notes.setForeground(Color.WHITE);
        notes.setFont(new Font("Arial", Font.PLAIN,15));

        consultPanel.add(name);
        name.setBounds(160,160,100,25);

        consultPanel.add(surname);
        surname.setBounds(160,200,100,25);

        consultPanel.add(bYear);
        bYear.setBounds(80,280,70,25);

        consultPanel.add(bMonth);
        bMonth.setBounds(255,280,70,25);

        consultPanel.add(bDate);
        bDate.setBounds(410,280,70,25);

        consultPanel.add(mobile);
        mobile.setBounds(160,320,100,25);

        consultPanel.add(patID);
        patID.setBounds(160,360,100,25);

        consultPanel.add(cYear);
        cYear.setBounds(80,440,70,25);

        consultPanel.add(cMonth);
        cMonth.setBounds(255,440,70,25);

        consultPanel.add(cDate);
        cDate.setBounds(410,440,70,25);

        doctorID = new JComboBox<>(); // Add all doctor license numbers to a JComboBox
        for (int x=0; x<WestminsterSkinConsultationManager.doctorsList.size(); x++){
            doctorID.addItem(WestminsterSkinConsultationManager.doctorsList.get(x).getLicenseNo());
        }
        consultPanel.add(doctorID);
        doctorID.setBounds(240,490,100,25);

        consultPanel.add(noOfHours);
        noOfHours.setBounds(240,530,70,25);

        consultPanel.add(addNotes);
        addNotes.setBounds(160,570,400,60);

        consultPanel.add(browse);
        browse.setBounds(35,660,130,30);
        browse.addActionListener(this::actionPerformed);

        consultPanel.add(submit);
        submit.setBounds(240,710,100,30);
        submit.addActionListener(this::actionPerformed);

        consultPanel.add(view);
        view.setBounds(480,710,100,30);
        view.addActionListener(this::actionPerformed);

        consultPanel.add(save);
        save.setBounds(35,710,100,30);
        save.addActionListener(this::actionPerformed);

    }

    public void actionPerformed(ActionEvent e) { // Action listener for the JButtons
        if (e.getSource()==submit){ // Add patients and consultations to the list on submit
            addPatient();
            addConsultation();

        } else if (e.getSource()==view) { // View the data already entered by the user
            JFrame viewConsult = new JFrame();
            JPanel viewPanel = new JPanel(null);
            viewConsult.add(viewPanel);
            viewConsult.setTitle("Skincare Consultation System");
            viewConsult.setSize(640, 800);
            viewConsult.setVisible(true);

            viewPanel.setBackground(new Color(0x123456));

            JLabel topicMain = new JLabel("View Consultation");
            topicMain.setBounds(200, 5, 200, 40);
            topicMain.setFont(new Font("MV Boli", Font.BOLD, 20));
            topicMain.setForeground(Color.WHITE);
            topicMain.setBackground(Color.black);
            topicMain.setOpaque(true);
            viewPanel.add(topicMain);

            JLabel fName = new JLabel("First Name : ");
            viewPanel.add(fName);
            fName.setBounds(35, 90, 300, 40);
            fName.setForeground(Color.WHITE);
            fName.setFont(new Font("Arial", Font.PLAIN, 18));

            JLabel fName1 = new JLabel(name.getText());
            viewPanel.add(fName1);
            fName1.setBounds(170, 90, 300, 40);
            fName1.setForeground(Color.WHITE);
            fName1.setFont(new Font("MV Boli", Font.PLAIN, 18));

            JLabel lName = new JLabel("Last Name : ");
            viewPanel.add(lName);
            lName.setBounds(35, 140, 300, 40);
            lName.setForeground(Color.WHITE);
            lName.setFont(new Font("Arial", Font.PLAIN, 18));

            JLabel lName1 = new JLabel(surname.getText());
            viewPanel.add(lName1);
            lName1.setBounds(170, 140, 300, 40);
            lName1.setForeground(Color.WHITE);
            lName1.setFont(new Font("MV Boli", Font.PLAIN, 18));

            JLabel mobNumber = new JLabel("Mobile Number : ");
            viewPanel.add(mobNumber);
            mobNumber.setBounds(35, 190, 300, 40);
            mobNumber.setForeground(Color.WHITE);
            mobNumber.setFont(new Font("Arial", Font.PLAIN, 18));

            JLabel mobile1 = new JLabel(mobile.getText());
            viewPanel.add(mobile1);
            mobile1.setBounds(210, 190, 300, 40);
            mobile1.setForeground(Color.WHITE);
            mobile1.setFont(new Font("MV Boli", Font.PLAIN, 18));

            JLabel cusID = new JLabel("Patient ID : ");
            viewPanel.add(cusID);
            cusID.setBounds(35, 240, 300, 40);
            cusID.setForeground(Color.WHITE);
            cusID.setFont(new Font("Arial", Font.PLAIN, 18));

            JLabel cusID1 = new JLabel(patID.getText());
            viewPanel.add(cusID1);
            cusID1.setBounds(170, 240, 300, 40);
            cusID1.setForeground(Color.WHITE);
            cusID1.setFont(new Font("MV Boli", Font.PLAIN, 18));

            JLabel consulTitle = new JLabel("Date of the Consultation : ");
            viewPanel.add(consulTitle);
            consulTitle.setBounds(35, 290, 300, 40);
            consulTitle.setForeground(Color.WHITE);
            consulTitle.setFont(new Font("Arial", Font.PLAIN, 18));

            int conYear = Integer.parseInt(cYear.getText());
            int conMonth = Integer.parseInt(cMonth.getText());
            int conDate = Integer.parseInt(cDate.getText());
            LocalDate consulDate = LocalDate.of(conYear, conMonth, conDate);
            JLabel consuDate = new JLabel(String.valueOf(consulDate));
            viewPanel.add(consuDate);
            consuDate.setBounds(290, 290, 300, 40);
            consuDate.setForeground(Color.WHITE);
            consuDate.setFont(new Font("MV Boli", Font.PLAIN, 18));

            JLabel hoursTitle = new JLabel("No. of Hours : ");
            viewPanel.add(hoursTitle);
            hoursTitle.setBounds(35, 340, 300, 40);
            hoursTitle.setForeground(Color.WHITE);
            hoursTitle.setFont(new Font("Arial", Font.PLAIN, 18));

            JLabel hoursNo = new JLabel(noOfHours.getText());
            viewPanel.add(hoursNo);
            hoursNo.setBounds(200, 340, 300, 40);
            hoursNo.setForeground(Color.WHITE);
            hoursNo.setFont(new Font("MV Boli", Font.PLAIN, 18));

            JLabel costTitle = new JLabel("Cost for the Consultation : ");
            viewPanel.add(costTitle);
            costTitle.setBounds(35, 390, 300, 40);
            costTitle.setForeground(Color.WHITE);
            costTitle.setFont(new Font("Arial", Font.PLAIN, 18));

            int cost;
            if (newPatient) { // Check whether the patient is a new patient and calculate the cost accordingly
                cost = 15 * Integer.parseInt(noOfHours.getText());
            } else {
                cost = 25 * Integer.parseInt(noOfHours.getText());
            }
            JLabel costAmount = new JLabel(cost+"£");
            viewPanel.add(costAmount);
            costAmount.setBounds(300, 390, 300, 40);
            costAmount.setForeground(Color.WHITE);
            costAmount.setFont(new Font("MV Boli", Font.PLAIN, 18));

            long docIndex = newDocNo;
            String doctorInfo = null;
            for (int x = 0; x < WestminsterSkinConsultationManager.doctorsList.size(); x++) {
                if (docIndex == WestminsterSkinConsultationManager.doctorsList.get(x).getLicenseNo()) {
                    doctorInfo = "Dr. " + WestminsterSkinConsultationManager.doctorsList.get(x).getName() + " " +
                            WestminsterSkinConsultationManager.doctorsList.get(x).getSurname();
                }
            }

            JLabel docInfo = new JLabel("Doctor : ");
            viewPanel.add(docInfo);
            docInfo.setBounds(35, 440, 300, 40);
            docInfo.setForeground(Color.WHITE);
            docInfo.setFont(new Font("Arial", Font.PLAIN, 18));

            JLabel doc1 = new JLabel(doctorInfo);
            viewPanel.add(doc1);
            doc1.setBounds(150, 440, 300, 40);
            doc1.setForeground(Color.WHITE);
            doc1.setFont(new Font("MV Boli", Font.PLAIN, 18));

            JLabel notesTitle = new JLabel("Additional Notes : ");
            viewPanel.add(notesTitle);
            notesTitle.setBounds(35, 490, 300, 40);
            notesTitle.setForeground(Color.WHITE);
            notesTitle.setFont(new Font("Arial", Font.PLAIN, 18));

            JLabel notes1 = new JLabel(addNotes.getText());
            viewPanel.add(notes1);
            notes1.setBounds(230, 490, 300, 40);
            notes1.setForeground(Color.WHITE);
            notes1.setFont(new Font("MV Boli", Font.PLAIN, 18));

            JLabel image = new JLabel();
            image.setBounds(170,550,300,150);
            viewPanel.add(image);
            ImageIcon ii = new ImageIcon(selectedImagePath);
            Image image1 = ii.getImage().getScaledInstance(image.getWidth(),image.getHeight(),Image.SCALE_SMOOTH);
            image.setIcon(new ImageIcon(image1));


        } else if (e.getSource()==save){ // Button to save all patient and consultation data into CSV files
            FileWriter myWriterDoc; // Create a FileWriter object
            try {
                myWriterDoc = new FileWriter("doctorData.txt");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            FileWriter myWritePat; // Create a FileWriter object
            try {
                myWritePat = new FileWriter("patientData.txt");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            FileWriter myWriteCon; // Create a FileWriter object
            try {
                myWriteCon = new FileWriter("consultData.txt");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            for (int x=0; x<WestminsterSkinConsultationManager.doctorsList.size(); x++){ // Write details of the doctor to the file in a specific format
                try {
                    myWriterDoc.write(WestminsterSkinConsultationManager.getDoctorString(x));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            try {
                myWriterDoc.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            for (int x=0; x<WestminsterSkinConsultationManager.patientsList.size(); x++){
                try {
                    myWritePat.write(WestminsterSkinConsultationManager.getPatientString(x));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            try {
                myWritePat.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            for (int x=0; x<WestminsterSkinConsultationManager.consultList.size(); x++){
                try {
                    myWriteCon.write(WestminsterSkinConsultationManager.getConsultString(x));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            try {
                myWriteCon.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource()==browse){ // Button to choose an image
            JFileChooser browseImageFile = new JFileChooser();
            FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES","png","jpg","jpeg");
            browseImageFile.addChoosableFileFilter(fnef);
            int showOpenDialogue = browseImageFile.showOpenDialog(null);
            if (showOpenDialogue == JFileChooser.APPROVE_OPTION){
                selectedImageFile = browseImageFile.getSelectedFile();
                selectedImagePath = selectedImageFile.getAbsolutePath();
            }
        }
    }

    public static void addPatient(){ // Method to add patients to the list

        String firstName = name.getText();
        String lastName = surname.getText();
        int dobYear = Integer.parseInt(bYear.getText());
        int dobMonth = Integer.parseInt(bMonth.getText());
        int dobDate = Integer.parseInt(bDate.getText());
        long mobNo = Long.parseLong(mobile.getText());
        int patientID = Integer.parseInt(patID.getText());

        boolean newPat = true;

        for (int x=0; x< WestminsterSkinConsultationManager.patientsList.size(); x++){
            if (WestminsterSkinConsultationManager.patientsList.get(x).getPatientID() == patientID) {
                newPat = false;
                break;
            }
        }

        if (newPat){
            WestminsterSkinConsultationManager.patientsList.add(new Patient(firstName,lastName, LocalDate.of(dobYear,dobMonth,dobDate),
                    mobNo,patientID));
            newPatient = true;
        }

    }

    public static void addConsultation(){ // Method to add consultations to the list

        String firstName = name.getText();
        String lastName = surname.getText();
        int dobYear = Integer.parseInt(bYear.getText());
        int dobMonth = Integer.parseInt(bMonth.getText());
        int dobDate = Integer.parseInt(bDate.getText());
        long mobNo = Long.parseLong(mobile.getText());
        int patientID = Integer.parseInt(patID.getText());

        boolean newPatient = true;
        for (int x=0; x< WestminsterSkinConsultationManager.patientsList.size(); x++){
            if (WestminsterSkinConsultationManager.patientsList.get(x).getPatientID() == patientID) {
                newPatient = false;
                break;
            }
        }

        int conYear = Integer.parseInt(cYear.getText());
        int conMonth = Integer.parseInt(cMonth.getText());
        int conDate = Integer.parseInt(cDate.getText());
        LocalDate consultationDate = LocalDate.of(conYear,conMonth,conDate);
        int hours = Integer.parseInt(noOfHours.getText());
        int cost;
        if (newPatient){
            cost = 15*hours;
        } else {
            cost = 25*hours;
        }
        String notes = addNotes.getText();
        long docNo = Long.parseLong(String.valueOf(doctorID.getSelectedItem()));

        boolean freeDoctor = true;

        for (int x=0; x<WestminsterSkinConsultationManager.consultList.size(); x++){
            if (docNo==WestminsterSkinConsultationManager.consultList.get(x).getDocID()){
                if (consultationDate==WestminsterSkinConsultationManager.consultList.get(x).getConsultDate()){
                    freeDoctor = false;
                    break;
                }
            }
        }

        if (freeDoctor){
            newDocNo = docNo;
            Patient patient = new Patient(firstName,lastName,LocalDate.of(dobYear,dobMonth,dobDate),mobNo,patientID);
            Consultation consultation = new Consultation(patient,consultationDate,hours,cost,notes,newDocNo);
            WestminsterSkinConsultationManager.consultList.add(consultation);
        } else {
            while (true){
                Random random = new Random();
                int randomIndex = random.nextInt(WestminsterSkinConsultationManager.consultList.size());
                if (!(WestminsterSkinConsultationManager.consultList.get(randomIndex).getConsultDate()==consultationDate)) {
                    newDocNo = WestminsterSkinConsultationManager.consultList.get(randomIndex).getDocID();
                    break;
                }
            }

            Patient patient = new Patient(firstName,lastName,LocalDate.of(dobYear,dobMonth,dobDate),mobNo,patientID);
            Consultation consultation = new Consultation(patient,consultationDate,hours,cost,notes,newDocNo);
            WestminsterSkinConsultationManager.consultList.add(consultation);
        }
    }
}




