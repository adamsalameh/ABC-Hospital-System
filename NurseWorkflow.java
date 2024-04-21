import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NurseWorkflow extends EmployeeWorkflow {

    public void workflow(Scanner scanner, ArrayList<Patient> patients, ArrayList<Doctor> doctors, ArrayList<Nurse> nurses,HashMap<Patient, Doctor> patientDoctorMap, ArrayList<Room> rooms, HashMap<Patient, Room> patientRoomMap) {
        char choice;        
        Nurse nurse = getEmployeeByName(nurses, "Nurse", scanner);   
            
        do { 
            System.out.println("-----------------------------------------------------------");
            System.out.println("Patients to be admitted.");
            List<Patient> myPatients = nurse.getPatientsToAdmit(patientDoctorMap);
            if (myPatients.isEmpty()) {
                System.out.println("No patients need admission.");
                break; // Break out of the loop if no patient is found
            } else {   
                for (Patient patient : myPatients) {
                    Doctor doctor = patientDoctorMap.get(patient);                        
                    System.out.println("Patient: " + patient.getName() + " " + patient.getAge() +" year-old, has " + patient.getDiagnosis()+ " checked by DR." + doctor.getName());
                }
            }
            System.out.println("-----------------------------------------------------------");

            System.out.println("Admitted patients.");                    
            if (patientRoomMap.isEmpty()) {
                System.out.println("There are no admitted patients.");
            } else {
                for (Map.Entry<Patient, Room> entry : patientRoomMap.entrySet()) {
                    Patient admittedPatient = entry.getKey();
                    Room occupiedRoom = entry.getValue();

                    System.out.println("Patient: " + admittedPatient.getName() + ", checked-in room " + occupiedRoom.getNumber());
                }
            }
            System.out.println("-----------------------------------------------------------");             

            for (Room room : rooms) {                
                System.out.println("Room: " + room.getNumber() + " is " + (room.getIsOccupied() ? "Occupied" : "Vacant"));
            }
            System.out.println("-----------------------------------------------------------");

            System.out.println("Do you want to check-in or discharge a patient?");
            System.out.println(" 1.Check-in a patient.");
            System.out.println(" 2.Discharge a patient.");
            System.out.print("Enter the corresponding number: ");
            int action = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt() 
            

            switch (action) {
                case 1:
                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();
                    Patient patient = Patient.getPatientByName(patients, patientName);
                    if (patient == null ) {
                        System.out.println("No patient found with the specified name: " + patientName);
                        break; // Break out of the loop if no patient is found
                    }
                    System.out.println("The Patient " + patient.getName() + "  " + patient.getAge() + " year-old, with condition " + patient.getCondition());

                    System.out.print("Enter the room number to check-in the patient:");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character left by nextInt()

                    //Find the room by number
                    Room checkInRoom = rooms.stream()
                    .filter(room -> room.getNumber() == roomNumber)
                    .findFirst()
                    .orElse(null);

                    nurse.checkInPatient(checkInRoom);
                    patientRoomMap.put(patient, checkInRoom);                    
                    System.out.println("Patient: " + patient.getName() + " has been checked-in room " + checkInRoom.getNumber());
                    break;

                case 2:
                    System.out.println("-----------------------------------------------------------");                    
                    for (Map.Entry<Patient, Room> entry : patientRoomMap.entrySet()) {
                        Patient admittedPatient = entry.getKey();
                        Room occupiedRoom = entry.getValue();

                        System.out.println("Patient: " + admittedPatient.getName() + ", checked-in room " + occupiedRoom.getNumber());
                    }
                    System.out.println("-----------------------------------------------------------");
                    System.out.print("Enter patient name to discharge:");
                    String patientNameToDischarge = scanner.nextLine();

                    Patient patientToDischarge = Patient.getPatientByName(patients, patientNameToDischarge);                   
                    Room room = patientRoomMap.get(patientToDischarge);
                    if (room != null) {
                        nurse.dischargPatient(room, patientToDischarge);
                        patientRoomMap.remove(patientToDischarge);
                        System.out.println("Patient: " + patientToDischarge.getName() + " has been discharged from room " + room.getNumber());
                    } else {
                        System.out.println("Room not found for the specified patient: " + patientToDischarge.getName());
                    }         
                    break;
            
                default:
                    System.out.println("Invalid value selected. Please try again.");
                    break;
                }

                System.out.println("\n#======|ABC Hospital|=================|Nurse|=============#");
                System.out.print("Do you want to enter another patient? (y/n): ");
                choice = scanner.nextLine().charAt(0);

        } while (choice == 'y' || choice == 'Y');        
    }
}
