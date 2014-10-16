import java.util.ArrayList;
import java.util.List;

/* This pattern has a recursive list of Employee objects. What is meant by this
 * is that for example a Head Marketing Employee object may have a list of other
 * employee objects that are his subordinates.  */

//----------------------------------------------------
// Main class
//----------------------------------------------------
public class composite{
    public static void main(String[] args) {
        Employee CEO = new Employee("John","CEO",30000); 

        Employee headSales = new Employee("Robert","Head Sales",20000);

        Employee headMarketing = new Employee("Michel","Head Marketing",20000);

        Employee clerk1 = new Employee("Laura","Marketing", 10000);
        Employee clerk2 = new Employee("Bob","Marketing", 10000);

        Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob","Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1); /* Clerks one and two are added as subordinates to  */
        headMarketing.add(clerk2); /* head of marketing. In this way they can be respresented as a tree structure. */

        System.out.println(CEO);
        for (Employee headEmployee : CEO.getSubordinates()) {
            System.out.println(headEmployee);
            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println(employee);
            }
        }
    }
}

//----------------------------------------------------
// Employee class that keeps track of subordianates
// salary and the department the employee works in
//----------------------------------------------------
class Employee{
    private String name;
    private String dept;
    private int salary;
    private List<Employee> subordinates;

    public Employee(String name, String dept, int sal){
        this.name = name;
        this.dept = dept;
        this.salary = sal;
        subordinates = new ArrayList<Employee>();
    }

    public void add(Employee e){
        subordinates.add(e);
    }

    public void remove(Employee e){
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates(){
        return subordinates;
    }

    public String toString(){
        return ("Employee :[Name: " + name + ",dept: " + dept + ",salary :" + salary + "]");
    }
}

