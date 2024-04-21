import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pharmacist extends Employee {

    // Constructor for Pharmacist, calling the superclass constructor with a name parameter
    public Pharmacist(String name) {
        super(name);
    }

    public List<Patient> getPatientsNeedsMedication(HashMap<Patient, Doctor> patientDoctorMap) {
        List<Patient> patientsToIssueMedication = new ArrayList<>();

        for (Map.Entry<Patient, Doctor> entry : patientDoctorMap.entrySet()) {
            if (entry.getKey().getNeedMedication()) {
                patientsToIssueMedication.add(entry.getKey());
            }
        }        
        return patientsToIssueMedication;
    }  

    public void issueMedication(Patient patient) {
        patient.setNeedMedication(false);
    }    
}
