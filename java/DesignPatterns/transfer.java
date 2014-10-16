import java.util.ArrayList;
import java.util.List;

//----------------------------------------------------
// 
//----------------------------------------------------
public class transfer{
    public static void main(String[] args) {
        StudentBO studentBusinessObject = new StudentBO();

        for (StudentVO student : studentBusinessObject.getAllStudents()) {
            System.out.println("Student: [RollNo: " 
                                + student.getRollNo() 
                                + ", Name: " + student.getName()
                                + student.getName() + "]");
        }

        StudentVO student = studentBusinessObject.getAllStudents().get(0);
        student.setName("Michael");
        studentBusinessObject.updateStudent(student);

        studentBusinessObject.getStudent(0);
        System.out.println("Student: [RollNo: " + student.getRollNo() + ", Name: " + student.getName() + "]");
    }
}

//----------------------------------------------------
// 
//----------------------------------------------------
class StudentVO{

    private String name;
    private int rollNo;

    public StudentVO(String name, int rollNo){
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
// 
//----------------------------------------------------
class StudentBO{

    List<StudentVO> students;

    public StudentBO(){
        students = new ArrayList<StudentVO>();
        StudentVO student1 = new StudentVO("Robert",0);
        StudentVO student2 = new StudentVO("John",1);
        students.add(student1);
        students.add(student2);
    }

    public void deleteStudent(StudentVO student){
        students.remove(student.getRollNo());
        System.out.println("Student: Roll No " 
                            + student.getRollNo() 
                            + ", deleted from database");
    }

    public List<StudentVO> getAllStudents(){
        return students;
    }

    public StudentVO getStudent(int rollNo){
        return students.get(rollNo);
    }

    public void updateStudent(StudentVO student){
        students.get(student.getRollNo()).setName(student.getName());
        System.out.println("Student: Roll No "
                            + student.getRollNo() 
                            + ", updated in the database");
    }
}
