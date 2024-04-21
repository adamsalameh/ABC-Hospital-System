import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PharmacistWorkflow extends EmployeeWorkflow {

    
        public void workflow(Scanner scanner, ArrayList<Patient> patients, ArrayList<Doctor> doctors, ArrayList<Pharmacist> pharmacists, HashMap<Patient, Doctor> patientDoctorMap) {
        char choice;       
        Pharmacist pharmacist = getEmployeeByName(pharmacists, "Pharmacist", scanner);
            
        do {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Patients to issue medications:");
            List<Patient> myPatients = pharmacist.getPatientsNeedsMedication(patientDoctorMap);

            if (myPatients.isEmpty()) {
                System.out.println("No patients need medication.");
                break; // Break out of the loop if no patient is found
            } else {
                for (Patient patient : myPatients) {
                    Doctor doctor = patientDoctorMap.get(patient);                        
                    System.out.println("Patient: " + patient.getName() + " was examined by Dr. " + doctor.getName() +
                     ", has been prescribed " + patient.getMedication() + " for " 
                        + patient.getNumberOfDays() + " days.");
                }
            }
            System.out.println("-----------------------------------------------------------");
            System.out.print("Enter Patient Name: ");
            String patientName = scanner.nextLine();
            Patient patient = Patient.getPatientByName(patients, patientName);
            if (patient == null ) {
                System.out.println("No patient found with the specified name: " + patientName);
                break; // Break out of the loop if no patient is found
            }
            System.out.println("Patient: " + patient.getName() + " " + patient.getAge() +" year-old, has " 
                    + patient.getDiagnosis()+ " has been prescribed " + patient.getMedication() + " for " 
                    + patient.getNumberOfDays() + " days.");
            
            System.out.println("Has the patient " + patient.getName() + " got the medication?");
            System.out.println(" 1.Yes, the medication has been issue.");
            System.out.println(" 2.No, the medication has been order.");
            System.out.print("Enter the corresponding number: ");
            int issuedMedication = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            switch (issuedMedication) {
                case 1:
                    pharmacist.issueMedication(patient);
                    System.out.println("Patient " + patient.getName() + " issued " + patient.getMedication() + " for " 
                            + patient.getNumberOfDays() + " days.");
                    break;

                case 2:
                    System.out.println("Patient " + patient.getName() + " will remain in the queue as the medication has been order");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println("-----------------------------------------------------------");
            System.out.print("Do you want to enter another patient? (y/n): ");
            choice = scanner.nextLine().charAt(0);

            } while (choice == 'y' || choice == 'Y');       
    }
}
