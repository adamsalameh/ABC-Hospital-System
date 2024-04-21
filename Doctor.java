import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Doctor extends Employee {

    private String specialization;

    public Doctor(String name, String specialization) {
        super(name); // Call the superclass constructor with the name parameter
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public List<Patient> getAssignedPatients(HashMap<Patient, Doctor> patientDoctorMap) {
        List<Patient> assignedPatients = new ArrayList<>();

        for (Map.Entry<Patient, Doctor> entry : patientDoctorMap.entrySet()) {
            if (entry.getValue().equals(this)) {
                assignedPatients.add(entry.getKey());
            }
        }       
        return assignedPatients;
    }    

    public void prescribeMedication(Patient patient, String medicineName, int numberOfDays) {
        patient.setMedication(medicineName);
        patient.setNumberOfDays(numberOfDays);
        patient.setNeedMedication(true);        
    }

    public void admitPatient(Patient patient, boolean needAmission) {
        patient.setNeedAmission(needAmission);  
    }

    public void checkPatient(Patient patient, boolean isChecked, String diagnosis) {
        patient.setIsChecked(isChecked);
        patient.setDiagnosis(diagnosis);
    }    
}
