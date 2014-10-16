import java.util.List;
import java.util.ArrayList;

/* The Data Access Object Pattern (DAO) is used to separate low level data
 * accessing API operations from high level business services. The pattern 
 * is separated into three different objects:
 * 1) Data Access Object Interface      : Interface defining the standard 
 *                                        operations to be performed on a models
 *                                        objects.
 * 2) Data Access Object concrete class : Implements the DAO interface. Responsible
 *                                        for getting data from a datasource.
 * 3) Model Object/Value Object         : Object containing get/set methods to store
 *                                        data retrieved using DAO class. 
 */


//----------------------------------------------------
// Main class
//----------------------------------------------------
public class dataaccess{
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();

        for (Student student : studentDao.getAllStudents()) {
            System.out.println("Student: [RollNo: " + student.getRollNo() + ", Name: " + student.getName() + "]");
        }

        Student student = studentDao.getAllStudents().get(0);
        student.setName("Micheal");
        studentDao.updateStudent(student);

        studentDao.getStudent(0);
        System.out.println("Student: [RollNo: " + student.getRollNo() + ", Name: " + student.getName() + "]");
    }
}

//----------------------------------------------------
// Student Model Value Object
//----------------------------------------------------
class Student{
    private String name;
    private int rollNo;

    Student(String name, int rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getRollNo(){
        return rollNo;
    }

    public void setRollNo(int rollNo){
        this.rollNo = rollNo;
    }
}

//----------------------------------------------------
// Data Access Object Interface
//----------------------------------------------------
interface StudentDao{
    public List<Student> getAllStudents();
    public Student getStudent(int rollNo);
    public void updateStudent(Student student);
    public void deleteStudent(Student student);
}

//----------------------------------------------------
// Concrete implementation of the above interface
//----------------------------------------------------
class StudentDaoImpl implements StudentDao{

    List<Student> students;

    public StudentDaoImpl(){
        students = new ArrayList<Student>();
        Student student1 = new Student("Robert",0);
        Student student2 = new Student("John",1);
        students.add(student1);
        students.add(student2);
    }

    @Override public void deleteStudent(Student student){
        students.remove(student.getRollNo());
        System.out.println("Student: Roll No " + student.getRollNo() + ", deleted from database");
    }

    @Override public List<Student> getAllStudents(){
        return students;
    }

    @Override public Student getStudent(int rollNo){
        return students.get(rollNo);
    }

    @Override public void updateStudent(Student student){
        students.get(student.getRollNo()).setName(student.getName());
        System.out.println("Student: Roll No " + student.getRollNo() + ", updated in the database");
    }
}

