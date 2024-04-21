import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);

            ArrayList<Patient> patients = new ArrayList<>();
            ArrayList<Receptionist> receptionists = new ArrayList<>();
            ArrayList<Doctor> doctors = new ArrayList<>();
            ArrayList<Nurse> nurses = new ArrayList<>();
            ArrayList<Pharmacist> pharmacists = new ArrayList<>();
            ArrayList<Room> rooms = new ArrayList<>();

            HashMap<Patient, Doctor> patientDoctorMap = new HashMap<>();
            HashMap<Patient, Room> patientRoomMap = new HashMap<>();
            
            receptionists.add(new Receptionist("Amy"));
            receptionists.add(new Receptionist("Joe"));

            doctors.add(new Doctor("Tom","Internal Medicine"));
            doctors.add(new Doctor("Nicole","Cardiology"));

            nurses.add(new Nurse("Jennifer"));
            nurses.add(new Nurse("Michael"));
            
            rooms.add(new Room(500));
            rooms.add(new Room(501));
            rooms.add(new Room(502));
            rooms.add(new Room(503));

            pharmacists.add(new Pharmacist("John"));
            pharmacists.add(new Pharmacist("Jane"));

            String role;

            do {
                System.out.println("\n#======================|ABC Hospital|=====================#");
                System.out.println("\nWelcome to ABC Hospital System. Please select your role:");
                System.out.println(" R. Receptionist");
                System.out.println(" D. Doctor");
                System.out.println(" N. Nurse");
                System.out.println(" P. Pharmacist");
                System.out.println(" E. Exit");
                System.out.print("Enter the letter corresponding to your role: ");
                role = scanner.nextLine().toLowerCase();
                

                switch (role) {
                    case "r":
                        ReceptionistWorkflow receptionistWorkflow = new ReceptionistWorkflow();
                        receptionistWorkflow.workflow(scanner, receptionists, patients, doctors, patientDoctorMap);
                        break;                
                    case "d":
                        DoctorWorkflow doctorWorkflow = new DoctorWorkflow();
                        doctorWorkflow.workflow(scanner, patients, doctors, patientDoctorMap);
                        break;
                    case "n":
                        NurseWorkflow nurseWorkflow = new NurseWorkflow();
                        nurseWorkflow.workflow(scanner, patients, doctors, nurses, patientDoctorMap, rooms, patientRoomMap);
                        break;
                    case "p":
                        PharmacistWorkflow pharmacistWorkflow = new PharmacistWorkflow();
                        pharmacistWorkflow.workflow(scanner, patients, doctors, pharmacists, patientDoctorMap);
                        break;
                    case "e":
                        System.out.println("The program is ended!");
                        break;
                    default:
                        System.out.println("Invalid role selected. Please try again.");
                        break;
                }

            } while (!role.equals("e"));

            scanner.close();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());            
        }
    }    
}
