
/**
 * Write a description of class Employee here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Employee
{
    private String employeeId;
    private String fullName;
    private String department;
    private double basicSalary;
    private int yearsOfService;

    public Employee() {
        this.employeeId = "";
        this.fullName = "";
        this.department = "";
        this.basicSalary = 500000; 
        this.yearsOfService = 0;
    }

    public Employee(String employeeId, String fullName, String department, double basicSalary) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.department = department;
        setBasicSalary(basicSalary);
        this.yearsOfService = 0; 
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDepartment() {
        return department;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setBasicSalary(double basicSalary) {
        if (basicSalary >= 500000) {
            this.basicSalary = basicSalary;
        } else {
            System.out.println("Error: Salary must be at least 500,000. Setting to minimum.");
            this.basicSalary = 500000;
        }
    }

    public void setYearsOfService(int yearsOfService) {
        if (yearsOfService >= 0) {
            this.yearsOfService = yearsOfService;
        } else {
            System.out.println("Error: Years of service cannot be negative. Setting to 0.");
            this.yearsOfService = 0;
        }
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double calculateBonus() {
        double bonusPercentage = 0.1 * yearsOfService;
        if (bonusPercentage > 0.5) {
            bonusPercentage = 0.5;
        }
        return basicSalary * bonusPercentage;
    }

    public double calculateNetSalary() {
        double gross = basicSalary + calculateBonus();
        double tax = 0.15 * gross;
        return gross - tax;
    }

    public void promote(String newDepartment, double salaryIncrease) {
        setDepartment(newDepartment);
        setBasicSalary(basicSalary + salaryIncrease);
        System.out.println(fullName + " promoted to " + newDepartment + " with new salary: " + basicSalary);
    }

    public void displayPayslip() {
        System.out.println("\n--- Payslip for " + fullName + " ---");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Department: " + department);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Years of Service: " + yearsOfService);
        System.out.println("Bonus: " + calculateBonus());
        System.out.println("Net Salary (after 15% tax): " + calculateNetSalary());
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        System.out.println("=== Employee Payroll Exercise ===\n");

        Employee employee1 = new Employee("EMP001", "Ali Hassan", "IT", 1500000);
        Employee employee2 = new Employee("EMP002", "Fatma Said", "HR", 1200000);

        employee1.setYearsOfService(5);
        employee2.setYearsOfService(2);
        
        employee1.displayPayslip();
        employee2.displayPayslip();

        employee1.promote("Senior IT", 300000);

        employee1.displayPayslip();

        System.out.println("\n=== Exercise Complete ===");
    }
}

