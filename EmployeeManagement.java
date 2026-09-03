import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// Employee class
class Employee {

    int id;
    String name;
    String department;
    double basicSalary;
    double allowance;
    double deduction;

    // Constructor
    Employee(int id, String name, String department,
             double basicSalary, double allowance, double deduction) {

        this.id = id;
        this.name = name;
        this.department = department;
        this.basicSalary = basicSalary;
        this.allowance = allowance;
        this.deduction = deduction;
    }

    // Calculate Gross Salary
    double grossSalary() {
        return basicSalary + allowance;
    }

    // Calculate Net Salary
    double netSalary() {
        return grossSalary() - deduction;
    }

    // Display employee details
    void display() {

        System.out.println("----------------------------------------");
        System.out.println("Employee ID  : " + id);
        System.out.println("Name         : " + name);
        System.out.println("Department   : " + department);
        System.out.println("Basic Salary : " + basicSalary);
        System.out.println("Allowance    : " + allowance);
        System.out.println("Deduction    : " + deduction);
        System.out.println("Gross Salary : " + grossSalary());
        System.out.println("Net Salary   : " + netSalary());
    }
}


// Main class
public class EmployeeManagement {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // 1. Add Employee
    static void addEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        double basicSalary = sc.nextDouble();

        System.out.print("Enter Allowance: ");
        double allowance = sc.nextDouble();

        System.out.print("Enter Deduction: ");
        double deduction = sc.nextDouble();

        Employee e = new Employee(
                id,
                name,
                department,
                basicSalary,
                allowance,
                deduction
        );

        employees.add(e);

        System.out.println("\nEmployee added successfully!");
    }


    // 2. Display Employees
    static void displayEmployees() {

        if (employees.isEmpty()) {
            System.out.println("\nNo employee records found.");
            return;
        }

        System.out.println("\n========== EMPLOYEE DETAILS ==========");

        for (Employee e : employees) {
            e.display();
        }
    }


    // 3. Search Employee
    static void searchEmployee() {

        if (employees.isEmpty()) {
            System.out.println("\nNo employee records found.");
            return;
        }

        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();

        boolean found = false;

        // Linear Search
        for (Employee e : employees) {

            if (e.id == id) {

                System.out.println("\nEmployee Found!");
                e.display();

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nEmployee not found.");
        }
    }


    // 4. Delete Employee
    static void deleteEmployee() {

        if (employees.isEmpty()) {
            System.out.println("\nNo employee records found.");
            return;
        }

        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < employees.size(); i++) {

            if (employees.get(i).id == id) {

                employees.remove(i);

                System.out.println("\nEmployee deleted successfully!");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nEmployee not found.");
        }
    }


    // 5. Calculate Payroll
    static void calculatePayroll() {

        if (employees.isEmpty()) {
            System.out.println("\nNo employee records found.");
            return;
        }

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        boolean found = false;

        for (Employee e : employees) {

            if (e.id == id) {

                System.out.println("\n========== PAYROLL ==========");

                System.out.println("Employee ID  : " + e.id);
                System.out.println("Name         : " + e.name);
                System.out.println("Basic Salary : " + e.basicSalary);
                System.out.println("Allowance    : " + e.allowance);
                System.out.println("Gross Salary : " + e.grossSalary());
                System.out.println("Deduction    : " + e.deduction);
                System.out.println("Net Salary   : " + e.netSalary());

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nEmployee not found.");
        }
    }


    // 6. Sort by Employee ID
    static void sortById() {

        if (employees.isEmpty()) {
            System.out.println("\nNo employee records found.");
            return;
        }

        employees.sort(Comparator.comparingInt(e -> e.id));

        System.out.println("\nEmployees sorted by Employee ID:");

        displaySimple();
    }


    // 7. Sort by Salary
    static void sortBySalary() {

        if (employees.isEmpty()) {
            System.out.println("\nNo employee records found.");
            return;
        }

        employees.sort(
                Comparator.comparingDouble(Employee::netSalary)
        );

        System.out.println("\nEmployees sorted by Net Salary:");

        displaySimple();
    }


    // Display sorted employees
    static void displaySimple() {

        System.out.println("-----------------------------------------------");

        System.out.printf(
                "%-10s %-15s %-15s%n",
                "ID",
                "Name",
                "Net Salary"
        );

        System.out.println("-----------------------------------------------");

        for (Employee e : employees) {

            System.out.printf(
                    "%-10d %-15s %.2f%n",
                    e.id,
                    e.name,
                    e.netSalary()
            );
        }

        System.out.println("-----------------------------------------------");
    }


    // Main method
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n==========================================");
            System.out.println("       EMPLOYEE MANAGEMENT & PAYROLL");
            System.out.println("==========================================");

            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Calculate Payroll");
            System.out.println("6. Sort by Employee ID");
            System.out.println("7. Sort by Salary");
            System.out.println("8. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    displayEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    deleteEmployee();
                    break;

                case 5:
                    calculatePayroll();
                    break;

                case 6:
                    sortById();
                    break;

                case 7:
                    sortBySalary();
                    break;

                case 8:
                    System.out.println("\nThank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("\nInvalid choice!");
            }
        }
    }
}