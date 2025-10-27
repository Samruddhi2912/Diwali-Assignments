import java.io.*;
import java.util.*;

// Employee class
class Employee implements Serializable {
    String empName;
    int empID;
    String empRole;

    // No-arg constructor
    public Employee() {
        this.empID = 0;
        this.empName = "";
        this.empRole = "Intern"; // hardcoded by default
    }

    // Constructor with empID and empName, empRole hardcoded
    public Employee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.empRole = "Employee";
    }

    // Constructor with all parameters
    public Employee(int empID, String empName, String empRole) {
        this.empID = empID;
        this.empName = empName;
        this.empRole = empRole;
    }

    @Override
    public String toString() {
        return "Employee[ID=" + empID + ", Name=" + empName + ", Role=" + empRole + "]";
    }
}

// Main program with menu
public class EmployeeManager {
    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    removeEmployee();
                    break;
                case 3:
                    showAllEmployees();
                    break;
                case 4:
                    showAllEmployeesSorted();
                    break;
                case 5:
                    findEmployeeByName();
                    break;
                case 6:
                    saveEmployeesToFile();
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void printMenu() {
        System.out.println("\nEmployee Manager Menu:");
        System.out.println("1. Add Employee to list");
        System.out.println("2. Remove Employee from list");
        System.out.println("3. Show all Employees");
        System.out.println("4. Show all Employees sorted by empID");
        System.out.println("5. Find Employee by empName");
        System.out.println("6. Save all Employees into file");
        System.out.println("7. Quit");
    }

    static void addEmployee() {
        int id = getIntInput("Enter Employee ID: ");
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Role (leave blank for default): ");
        String role = scanner.nextLine();
        Employee emp;
        if (role.isEmpty()) {
            emp = new Employee(id, name);
        } else {
            emp = new Employee(id, name, role);
        }
        employees.add(emp);
        System.out.println("Employee added: " + emp);
    }

    static void removeEmployee() {
        int id = getIntInput("Enter Employee ID to remove: ");
        boolean removed = employees.removeIf(e -> e.empID == id);
        if (removed) {
            System.out.println("Employee removed.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    static void showAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to show.");
            return;
        }
        System.out.println("All Employees:");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    static void showAllEmployeesSorted() {
        if (employees.isEmpty()) {
            System.out.println("No employees to show.");
            return;
        }
        employees.stream()
            .sorted(Comparator.comparingInt(e -> e.empID))
            .forEach(System.out::println);
    }

    static void findEmployeeByName() {
        System.out.print("Enter Employee Name to find: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Employee e : employees) {
            if (e.empName.equalsIgnoreCase(name)) {
                System.out.println("Found: " + e);
                found = true;
            }
        }
        if (!found) System.out.println("Employee with name " + name + " not found.");
    }

    static void saveEmployeesToFile() {
        System.out.print("Enter file name to save: ");
        String fileName = scanner.nextLine();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employees);
            System.out.println("Employees saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    static int getIntInput(String prompt) {
        int result = -1;
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                result = Integer.parseInt(input);
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a valid integer.");
            }
        }
    }
}
