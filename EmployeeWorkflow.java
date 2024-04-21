import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeWorkflow {

    public <T extends Employee> T getEmployeeByName(List<T> employees, String employeeType, Scanner scanner) {
         System.out.println("\n#======|ABC Hospital|=================|" + employeeType + "|======#");
        System.out.print("Please enter your name: ");
        String employeeName = scanner.nextLine();
        T employee = employees.stream()
                .filter(e -> e.getName().equalsIgnoreCase(employeeName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(employeeType + " not found with the specified name: " + employeeName));
        System.out.println("-----------------------------------------------------------");
        System.out.println("Hello " + employee.getName() + "!");
        return employee;
    }  
}
