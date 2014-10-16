/* The MVC (Model View Controller) pattern is used to serperate a program 
 * into three seperate components:
 * 1) Model      : The model is used to simply hold the objects information.
 *                 In this example the class Student just holds the name and 
 *                 roll number.
 * 2) View       : The view class is used to display the data in some manner.
 * 3) Controller : The controller class is used to manipulate the data in the 
 *                 Student model and update it. This calls the View class which
 *                 will display the information for the class.
 * */


//----------------------------------------------------
// Main class
//----------------------------------------------------
public class mvc {
    public static void main(String[] args) {

        //fetch student record based on his roll no from the database
        Student model  = retriveStudentFromDatabase();

        //Create a view : to write student details on console
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);
        controller.updateView();

        //update model data
        controller.setStudentName("John");
        controller.updateView();
    }

    private static Student retriveStudentFromDatabase(){
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}

//----------------------------------------------------
// Represents a student model
//----------------------------------------------------
class Student {
    private String rollNo;
    private String name;

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//----------------------------------------------------
// Represents a student view to print out a students 
// rollNo and name
//----------------------------------------------------
class StudentView {
    public void printStudentDetails(String studentName, String studentRollNo){
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }
}

//----------------------------------------------------
// Represents a class that uses the StudentView to 
// print out the data and the Student model to model
// the data
//----------------------------------------------------
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view){
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name){
        model.setName(name);		
    }

    public String getStudentName(){
        return model.getName();		
    }

    public void setStudentRollNo(String rollNo){
        model.setRollNo(rollNo);		
    }

    public String getStudentRollNo(){
        return model.getRollNo();		
    }

    public void updateView(){				
        view.printStudentDetails(model.getName(), model.getRollNo());
    }	
}

