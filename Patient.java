import java.util.ArrayList;

public class Patient {

    private String name;
    private int age;
    private String condition;
    private String medication;
    private int numberOfDays;
    private boolean needAmission;
    private boolean needMedication;
    private boolean isChecked;
    private String diagnosis;

    // Constructor
    public Patient(String name, int age, String condition) {
        this.name = name;
        this.age = age;
        this.condition = condition;        
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCondition() {
        return condition;
    }

    public String getMedication() {
        return medication;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public boolean getNeedAmission() {
        return needAmission;
    } 

    public boolean getNeedMedication() {
        return needMedication;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }    

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }    

    public void setNeedAmission(boolean needAmission) {
        this.needAmission = needAmission;
    }

     public void setNeedMedication(boolean needMedication) {
        this.needMedication = needMedication;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public static Patient getPatientByName(ArrayList<Patient> patients, String patientName) {
        return patients.stream()
                .filter(patient -> patient.getName().equalsIgnoreCase(patientName))
                .findFirst()
                .orElse(null); // Return null if no patient is found            
    }    
}
