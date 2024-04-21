import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Nurse extends Employee {

    // Constructor for Nurse, calling the superclass constructor with a name parameter
    public Nurse(String name) {
        super(name);
    }

    public List<Patient> getPatientsToAdmit(HashMap<Patient, Doctor> patientDoctorMap) {

        List<Patient> patientsToAdmit = new ArrayList<>();

        for (Map.Entry<Patient, Doctor> entry : patientDoctorMap.entrySet()) {
            if (entry.getKey().getNeedAmission()) {
                patientsToAdmit.add(entry.getKey());
            }
        }        
        return patientsToAdmit;
    }      

    public void checkInPatient(Room room) {
        room.setIsOccupied(true);
    }

    public void dischargPatient(Room room, Patient patient) {
        room.setIsOccupied(false);
        patient.setNeedAmission(false); 
    }    
}
