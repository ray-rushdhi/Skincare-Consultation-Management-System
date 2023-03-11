import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class GUI { // GUI class to implement Java Swing

    // Declare static elements used in multiple methods
    static JButton consultation = new JButton("Add consultation");
    static JButton viewConsult = new JButton("View all Consultations");

    public GUI() {

        JFrame frame = new JFrame(); // Create a JFrame
        JPanel panel = new JPanel(null); // Set the panel layout to null in order to control the layout

        frame.add(panel);
        frame.setTitle("Skincare Consultation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the program on close
        frame.setSize(640, 500);
        frame.setVisible(true);

        panel.setBackground(new Color(0x123456));

        JLabel topicMain = new JLabel("Skincare Consultation Center");
        topicMain.setBounds(150, 5, 300, 40);
        topicMain.setFont(new Font("MV Boli", Font.BOLD, 20));
        topicMain.setForeground(Color.WHITE);
        topicMain.setBackground(Color.black);
        topicMain.setOpaque(true);
        panel.add(topicMain);

        JLabel doctorsTable = new JLabel("List of Registered Doctors");
        doctorsTable.setBounds(50, 60, 300, 40);
        doctorsTable.setFont(new Font("MV Boli", Font.BOLD, 15));
        doctorsTable.setForeground(Color.WHITE);
        panel.add(doctorsTable);

        // Code reference - https://www.youtube.com/watch?v=skryksKiIK0
        JTable table = new JTable(); // Create a table to view the list of doctors
        String[] col = new String[]{"First name", "Surname", "Birthday", "Mobile", "License No.","Specialization"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        TableRowSorter tableRowSorter = new TableRowSorter<>(tableModel); // Method to sort the table
        table.setRowSorter(tableRowSorter);
        tableModel.setColumnIdentifiers(col);
        table.setModel(tableModel);
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(50, 100, 500, 250);
        panel.add(jScrollPane);
        Object[] data = new Object[6];

        for (int i = 0; i < WestminsterSkinConsultationManager.doctorsList.size(); ++i) { // Add all doctors into the table
            data[0] = (WestminsterSkinConsultationManager.doctorsList.get(i)).getName();
            data[1] = (WestminsterSkinConsultationManager.doctorsList.get(i)).getSurname();
            data[2] = (WestminsterSkinConsultationManager.doctorsList.get(i)).getDob();
            data[3] = (WestminsterSkinConsultationManager.doctorsList.get(i)).getMobNo();
            data[4] = (WestminsterSkinConsultationManager.doctorsList.get(i)).getLicenseNo();
            data[5] = (WestminsterSkinConsultationManager.doctorsList.get(i)).getSpecialization();
            tableModel.addRow(data);
        }

        panel.add(consultation); // Button
        consultation.setBounds(420, 370, 130, 30);
        consultation.addActionListener(this::actionPerformed);

        panel.add(viewConsult); // Button
        viewConsult.setBounds(50, 370, 200, 30);
        viewConsult.addActionListener(this::actionPerformed);
    }

    public void actionPerformed(ActionEvent e) { // Action listener for the JButtons
        if (e.getSource() == consultation) {
            try {
                new ConsultGUI();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource()== viewConsult){
            new ViewConsultations();
        }
    }

}
