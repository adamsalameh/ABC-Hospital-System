import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorWorkflow extends EmployeeWorkflow {

    public void workflow(Scanner scanner, ArrayList<Patient> patients, ArrayList<Doctor> doctors, HashMap<Patient, Doctor> patientDoctorMap) {
        char choice; 
        Doctor doctor = getEmployeeByName(doctors, "Doctor", scanner);
        do {

            System.out.println("Patients assigned:");
            List<Patient> myPatients = doctor.getAssignedPatients(patientDoctorMap);
            if (myPatients.isEmpty()) {
                System.out.println("No patient assigned to you!");
                break; // Break out of the loop if no patient is found

            } else {
                for (Patient patient : myPatients) {                
                System.out.println(patient.getName() + " " + (patient.getIsChecked() ? "has been checked" : "has not been Checked"));
                }
            }              
            System.out.println("-----------------------------------------------------------");

            System.out.print("Enter the patient name to check: ");
            String patientName = scanner.nextLine();
            Patient patient = Patient.getPatientByName(patients, patientName);
            if (patient == null ) {
                System.out.println("No patient found with the specified name: " + patientName);
                break; // Break out of the loop if no patient is found
            }             
            System.out.println("The patient " + patient.getName() + "  " + patient.getAge() + " year-old, with condition " + patient.getCondition());

            System.out.println("Enter your diagnosis for the patient: ");
            String diagnosis = scanner.nextLine();
            doctor.checkPatient(patient, true, diagnosis);
            System.out.println("-----------------------------------------------------------");

            System.out.println("Does the patient need medication or admission?");
            System.out.println(" 1. Medication");
            System.out.println(" 2. Admission");
            System.out.print("Enter the corresponding number: ");
            int treatment = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt()


            switch (treatment) {
                case 1: 
                    System.out.print("Enter the medicine name: ");
                    String medicineName = scanner.nextLine();
                    System.out.print("Enter the duration of treatment (in days):");
                    int numberOfDays = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character left by nextInt()
                    doctor.prescribeMedication(patient, medicineName, numberOfDays);
                    System.out.println("The patient " + patient.getName() + " will have " + medicineName + " for " + numberOfDays + " days.");
                    break;

                case 2:                    
                    doctor.admitPatient(patient, true);
                    System.out.println("The patient " + patient.getName() + " will be admitted.");              
                    break;
                
                default:
                    System.out.println("Invalid value selected. Please try again.");
                    break;
            }

            System.out.println("\n#======|ABC Hospital|=================|Doctor|============#");
            System.out.print("Do you want to enter another patient? (y/n): ");
            choice = scanner.nextLine().charAt(0);

        } while (choice == 'y' || choice == 'Y');        
    }   
}
