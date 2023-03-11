import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class ViewConsultations {

    public ViewConsultations(){ // GUI to view all the booked consultations

        JFrame frame = new JFrame();
        JPanel panel = new JPanel(null);

        frame.add(panel);
        frame.setTitle("Skincare Consultation System");
        frame.setSize(640, 500);
        frame.setVisible(true);

        panel.setBackground(new Color(0x123456));

        JLabel topicMain = new JLabel("View All Consultations");
        topicMain.setBounds(200, 5, 240, 40);
        topicMain.setFont(new Font("MV Boli", Font.BOLD, 20));
        topicMain.setForeground(Color.WHITE);
        topicMain.setBackground(Color.black);
        topicMain.setOpaque(true);
        panel.add(topicMain);

        JLabel doctorsTable = new JLabel("List of Consultations");
        doctorsTable.setBounds(50, 60, 300, 40);
        doctorsTable.setFont(new Font("MV Boli", Font.BOLD, 15));
        doctorsTable.setForeground(Color.WHITE);
        panel.add(doctorsTable);

        // Table to list all the data
        JTable table = new JTable();
        String[] col = new String[]{"Doctor License No.","Patient First Name","Patient Surname","Booked Date"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        TableRowSorter tableRowSorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(tableRowSorter);
        tableModel.setColumnIdentifiers(col);
        table.setModel(tableModel);
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(50, 100, 500, 250);
        panel.add(jScrollPane);
        Object[] data = new Object[4];

        for (int i = 0; i < WestminsterSkinConsultationManager.consultList.size(); ++i) {
            data[0] = (WestminsterSkinConsultationManager.consultList.get(i)).getDocID();
            data[1] = (WestminsterSkinConsultationManager.consultList.get(i)).getPatient().getName();
            data[2] = (WestminsterSkinConsultationManager.consultList.get(i)).getPatient().getSurname();
            data[3] = (WestminsterSkinConsultationManager.consultList.get(i)).getConsultDate();
            tableModel.addRow(data);
        }

    }

}
