import java.util.*;

class Employee {

    int id;
    String name;
    String department;
    double basicSalary;
    double allowance;
    double deduction;

    Employee(int id, String name, String department,
             double basicSalary, double allowance, double deduction) {

        this.id = id;
        this.name = name;
        this.department = department;
        this.basicSalary = basicSalary;
        this.allowance = allowance;
        this.deduction = deduction;
    }

    double grossSalary() {
        return basicSalary + allowance;
    }

    double netSalary() {
        return grossSalary() - deduction;
    }

    void display() {
        System.out.println("----------------------------------------");
        System.out.println("ID           : " + id);
        System.out.println("Name         : " + name);
        System.out.println("Department   : " + department);
        System.out.println("Basic Salary : " + basicSalary);
        System.out.println("Allowance    : " + allowance);
        System.out.println("Deduction    : " + deduction);
        System.out.println("Gross Salary : " + grossSalary());
        System.out.println("Net Salary   : " + netSalary());
        System.out.println("----------------------------------------");
    }
}

public class Employee1 {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Built-in departments
    static String[] departments = {
            "HR",
            "IT",
            "Finance",
            "Marketing",
            "Sales",
            "Operations",
            "Admin"
    };

    // Select Department
    static String selectDepartment() {

        System.out.println("\n========== DEPARTMENTS ==========");

        for (int i = 0; i < departments.length; i++) {
            System.out.println((i + 1) + ". " + departments[i]);
        }

        System.out.print("Enter department number: ");
        int choice = sc.nextInt();

        if (choice >= 1 && choice <= departments.length) {
            return departments[choice - 1];
        }

        System.out.println("Invalid department!");
        return null;
    }

    // 1. Add Employee
    static void addEmployee() {

        System.out.println("\n========== ADD EMPLOYEE ==========");

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee e : employees) {
            if (e.id == id) {
                System.out.println("Employee ID already exists!");
                return;
            }
        }

        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        String department = selectDepartment();

        if (department == null) {
            return;
        }

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

    // 3. Search Employee by ID - Linear Search
    static void searchEmployee() {

        System.out.println("\n========== SEARCH EMPLOYEE ==========");

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee e : employees) {

            if (e.id == id) {
                System.out.println("\nEmployee found!");
                e.display();
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    // 4. Search By Department
    static void searchByDepartment() {

        System.out.println("\n========== SEARCH BY DEPARTMENT ==========");

        String department = selectDepartment();

        if (department == null) {
            return;
        }

        boolean found = false;

        for (Employee e : employees) {

            if (e.department.equalsIgnoreCase(department)) {
                e.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No employees found in " + department);
        }
    }

    // 5. Update Employee
    static void updateEmployee() {

        System.out.println("\n========== UPDATE EMPLOYEE ==========");

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee e : employees) {

            if (e.id == id) {

                sc.nextLine();

                System.out.print("Enter New Name: ");
                e.name = sc.nextLine();

                String department = selectDepartment();

                if (department == null) {
                    return;
                }

                e.department = department;

                System.out.print("Enter New Basic Salary: ");
                e.basicSalary = sc.nextDouble();

                System.out.print("Enter New Allowance: ");
                e.allowance = sc.nextDouble();

                System.out.print("Enter New Deduction: ");
                e.deduction = sc.nextDouble();

                System.out.println("\nEmployee updated successfully!");
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    // 6. Delete Employee
    static void deleteEmployee() {

        System.out.println("\n========== DELETE EMPLOYEE ==========");

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()) {

            Employee e = iterator.next();

            if (e.id == id) {

                iterator.remove();

                System.out.println("Employee deleted successfully!");
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    // 7. Sort By ID
    static void sortById() {

        if (employees.isEmpty()) {
            System.out.println("\nNo employee records found.");
            return;
        }

        employees.sort(Comparator.comparingInt(e -> e.id));

        System.out.println("\nEmployees sorted by ID.");

        displayEmployees();
    }

    // 8. Binary Search
    static void binarySearch() {

        if (employees.isEmpty()) {
            System.out.println("\nNo employee records found.");
            return;
        }

        // Sort by ID before binary search
        employees.sort(Comparator.comparingInt(e -> e.id));

        System.out.print("\nEnter Employee ID to search: ");
        int id = sc.nextInt();

        int low = 0;
        int high = employees.size() - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            Employee e = employees.get(mid);

            if (e.id == id) {

                System.out.println("\nEmployee found!");
                e.display();
                return;

            } else if (e.id < id) {

                low = mid + 1;

            } else {

                high = mid - 1;
            }
        }

        System.out.println("Employee not found.");
    }

    // 9. Total Salary Expense
    static void totalSalary() {

        if (employees.isEmpty()) {
            System.out.println("\nNo employee records found.");
            return;
        }

        double total = 0;

        for (Employee e : employees) {
            total += e.netSalary();
        }

        System.out.println("\n========== TOTAL SALARY EXPENSE ==========");
        System.out.println("Total Salary Expense: " + total);
    }

    // 10. Average Salary
    static void averageSalary() {

        if (employees.isEmpty()) {
            System.out.println("\nNo employee records found.");
            return;
        }

        double total = 0;

        for (Employee e : employees) {
            total += e.netSalary();
        }

        double average = total / employees.size();

        System.out.println("\n========== AVERAGE SALARY ==========");
        System.out.println("Average Salary: " + average);
    }

    // 11. Employee Count
    static void employeeCount() {

        System.out.println("\n========== EMPLOYEE COUNT ==========");
        System.out.println("Total Employees: " + employees.size());
    }

    // 12. Salary Slip
    static void salarySlip() {

        System.out.println("\n========== SALARY SLIP ==========");

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee e : employees) {

            if (e.id == id) {

                System.out.println("\n================================");
                System.out.println("           SALARY SLIP");
                System.out.println("================================");
                System.out.println("Employee ID   : " + e.id);
                System.out.println("Employee Name : " + e.name);
                System.out.println("Department    : " + e.department);
                System.out.println("--------------------------------");
                System.out.println("Basic Salary  : " + e.basicSalary);
                System.out.println("Allowance     : " + e.allowance);
                System.out.println("Deduction     : " + e.deduction);
                System.out.println("--------------------------------");
                System.out.println("Gross Salary  : " + e.grossSalary());
                System.out.println("Net Salary    : " + e.netSalary());
                System.out.println("================================");

                return;
            }
        }

        System.out.println("Employee not found.");
    }

    // 13. Department Count
    static void departmentCount() {

        System.out.println("\n========== DEPARTMENT COUNT ==========");

        for (String department : departments) {

            int count = 0;

            for (Employee e : employees) {

                if (e.department.equalsIgnoreCase(department)) {
                    count++;
                }
            }

            System.out.println(department + " : " + count);
        }
    }

    // Main Method
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n==========================================");
            System.out.println("     EMPLOYEE MANAGEMENT & PAYROLL");
            System.out.println("==========================================");

            System.out.println("1.  Add Employee");
            System.out.println("2.  Display Employees");
            System.out.println("3.  Search Employee");
            System.out.println("4.  Search By Department");
            System.out.println("5.  Update Employee");
            System.out.println("6.  Delete Employee");
            System.out.println("7.  Sort By ID");
            System.out.println("8.  Binary Search");
            System.out.println("9.  Total Salary Expense");
            System.out.println("10. Average Salary");
            System.out.println("11. Employee Count");
            System.out.println("12. Salary Slip");
            System.out.println("13. Department Count");
            System.out.println("14. Exit");

            System.out.println("==========================================");

            System.out.print("Enter your choice: ");
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
                    searchByDepartment();
                    break;

                case 5:
                    updateEmployee();
                    break;

                case 6:
                    deleteEmployee();
                    break;

                case 7:
                    sortById();
                    break;

                case 8:
                    binarySearch();
                    break;

                case 9:
                    totalSalary();
                    break;

                case 10:
                    averageSalary();
                    break;

                case 11:
                    employeeCount();
                    break;

                case 12:
                    salarySlip();
                    break;

                case 13:
                    departmentCount();
                    break;

                case 14:
                    System.out.println("\nThank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("\nInvalid choice!");
            }
        }
    }
}