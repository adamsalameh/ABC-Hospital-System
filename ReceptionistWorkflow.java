import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceptionistWorkflow extends EmployeeWorkflow{

    public void workflow(Scanner scanner, ArrayList<Receptionist> receptionists, ArrayList<Patient> patients, ArrayList<Doctor> doctors, HashMap<Patient, Doctor> patientDoctorMap) {
        char choice;
        Receptionist receptionist = getEmployeeByName(receptionists, "Receptionist", scanner);         
        do {
            System.out.println("\nPlease enter the patient information");
            System.out.print("Enter Patient Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Patient Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt()

            System.out.print("Enter Patient Condition: ");
            String condition = scanner.nextLine();

            // Creating a Patient instance and adding it to the patients ArrayList
            Patient patient = new Patient(name, age, condition);
            receptionist.addPatient(patient, patients);
            System.out.println("Patient " + patient.getName() + " has been added successfully!");
            System.out.println("-----------------------------------------------------------");

            //Displaying the information of all patients in the ArrayList            
            if (doctors.isEmpty()) {
                System.out.println("No doctors are available.");
            } else {
                System.out.println("Available Doctors:");
                for (Doctor doctor : doctors) {
                    System.out.println("- Dr. " + doctor.getName() + " specialization: " + doctor.getSpecialization());
                }
            }
            System.out.print("Enter Doctor name to assign the patient to : ");
            String doctorName = scanner.nextLine();
            
            // Find the doctor to assign the patient
            Doctor assignedDoctor = doctors.stream()
                .filter(doctor -> doctor.getName().equalsIgnoreCase(doctorName))
                .findFirst()
                .orElse(null);                
       
            
            // Validate if the doctor is valid
            if (assignedDoctor == null) {
                System.out.println("No doctor found with the specified name. Please try again.");
            } else {
                // Assign the patient to the doctor
                receptionist.assignDoctorByName(assignedDoctor, patient, patientDoctorMap);
                System.out.println("The patient " + patient.getName() + " has been assigned to Dr. " + assignedDoctor.getName() + ".");
            }
            System.out.println("___________________________________________________________");           

            System.out.print("Do you want to enter another patient? (y/n): ");
            choice = scanner.nextLine().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }  
}
