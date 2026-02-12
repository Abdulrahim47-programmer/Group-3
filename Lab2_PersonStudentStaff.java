
/**
 * Write a description of class Person here.
 *
 * @author (24BIA024)
 * @version (12/02/2026)
 */
 class Person
{
       // Private instance variables
    private String name;
    private String address;

    // Constructor
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Public getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    // Public setter (no setter for name)
    public void setAddress(String address) {
        this.address = address;
    }
    // toString method
    @Override
    public String toString() {
        return "Person[name=" + name + ", address=" + address + "]";
    }
}

class Student extends Person {
    // Private instance variables
    private String program;
    private int year;
    private double fee;

    // Constructor
    public Student(String name, String address, String program, int year, double fee) {
        super(name, address);  // Call Person constructor
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    // Getters and setters
    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    // toString method
    @Override
    public String toString() {
        return "Student[" + super.toString() +
                ", program=" + program +
                ", year=" + year +
                ", fee=" + fee + "]";
    }
}
class Staff extends Person {
    // Private instance variables
    private String department;
    private double salary;

    // Constructor
    public Staff(String name, String address, String department, double salary) {
        super(name, address);  // Call Person constructor
        this.department = department;
        this.salary = salary;
    }

    // Getters and setters
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // toString method
    @Override
    public String toString() {
        return "Staff[" + super.toString() +
                ", department=" + department +
                ", salary=" + salary + "]";
    }
}
public class Lab2_PersonStudentStaff {
    public static void main(String[] args) {

        System.out.println("-----------------");
        System.out.println("  Lab 2: Person, Student, and Staff Hierarchy");
        System.out.println("-------------------\n");

        // Section 1: Creating Objects 
        System.out.println("--- Section 1: Creating Objects ---");

        Person p1 = new Person("Amina Hassan", "Stonetown, Zanzibar");
        System.out.println(p1);

        Student s1 = new Student("Juma Ali", "Chwaka, Zanzibar", "BITA", 2, 1500000);
        Student s2 = new Student("Fatma Omar", "Mbweni, Zanzibar", "BCS", 1, 1800000);
        System.out.println(s1);
        System.out.println(s2);

        Staff staff1 = new Staff("Dr. Khalid Salum", "Vuga, Zanzibar", "SCCMS", 3500000);
        System.out.println(staff1);

        //Section 2: Inheritance in Action 
        System.out.println("\n-- Section 2: Inheritance in Action --");

        System.out.println("Student name: " + s1.getName());
        System.out.println("Student address: " + s1.getAddress());
        System.out.println("Student program: " + s1.getProgram());

        System.out.println("\nStaff name: " + staff1.getName());
        System.out.println("Staff department: " + staff1.getDepartment());

        s1.setAddress("Fumba, Zanzibar");
        System.out.println("\nAfter address change: " + s1);

        // Section 3: Polymorphism 
        System.out.println("\n--- Section 3: Polymorphism ---");

        Person[] people = {
                new Person("Bakari Juma", "Mwanakwerekwe, Zanzibar"),
                new Student("Zainab Moh'd", "Kiembe Samaki, Zanzibar", "BITA", 3, 1500000),
                new Student("Hassan Said", "Amani, Zanzibar", "BCS", 1, 1800000),
                new Staff("Prof. Mwanaisha Ali", "Mazizini, Zanzibar", "SCCMS", 4500000)
        };

        System.out.println("All people at SUZA:");
        for (Person p : people) {
            System.out.println("  " + p);
        }

        // Section 4: instanceof and Type Checking 
        System.out.println("\n--- Section 4: instanceof and Type Checking ---");

        int studentCount = 0;
        int staffCount = 0;

        for (Person p : people) {
            if (p instanceof Student) {
                Student s = (Student) p;
                System.out.println(s.getName() + " is a Student in " +
                        s.getProgram() + " Year " + s.getYear());
                studentCount++;
                            } else if (p instanceof Staff) {
                Staff st = (Staff) p;
                System.out.println(st.getName() + " is Staff in " +
                        st.getDepartment());
                staffCount++;
            } else {
                System.out.println(p.getName() + " is a Person (visitor/other)");
            }
        }

        System.out.println("\nSummary: " + studentCount +" students, " + staffCount + " staff members");
        System.out.println("\n-----------------------");
        System.out.println("  End of Lab 2");
        System.out.println("---------------------------");


}
}