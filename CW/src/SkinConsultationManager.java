public interface SkinConsultationManager { // Interface for all the methods of the WestminsterSkinConsultationManager class
    static void addNewDoctor() {}
    static void removeDoctor() {}
    static void viewListOfDoctors() {}
    static void saveData() {}
    static void loadData() {}
    static boolean checkAvailability() {
        return false;
    }
    static String getDoctorString(int x) {
        return null;
    }
    static String getPatientString(int x){return null;}
    static String getConsultString(int x){return null;}
}
