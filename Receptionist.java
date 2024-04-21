import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Receptionist extends Employee {

    // Constructor for Receptionist, calling the superclass constructor with a name parameter
    public Receptionist(String name) {
        super(name);
    }

    public void assignDoctorByName(Doctor  assignedDoctor, Patient patient, HashMap<Patient, Doctor> patientDoctorMap) {
        patientDoctorMap.put(patient, assignedDoctor);            
    }

    public void addPatient(Patient patient, ArrayList<Patient> patients) {
        patients.add(patient);
    } 
}
