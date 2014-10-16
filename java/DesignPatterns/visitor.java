/* The visitor pattern is used as a way of seperating algorithms from the 
 * class structure of a program. In this example the ComputerPartVisitor
 * holds a number of differnt visit() methods which are called by classes
 * implmenting the accept() method of the ComputerPart interface */

//----------------------------------------------------
// Main class
//----------------------------------------------------
public class visitor{
    public static void main(String[] args) {
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}

//----------------------------------------------------
// Interface for ComputerPart
//----------------------------------------------------
interface ComputerPart{
    public void accept(ComputerPartVisitor computerPartVisitor);
}

//----------------------------------------------------
// Concrete implementation of ComputerPart
//----------------------------------------------------
class Keyboard implements ComputerPart{
    @Override public void accept(ComputerPartVisitor computerPartVisitor){
        computerPartVisitor.visit(this);
    }
}

//----------------------------------------------------
// Concrete implementation of ComputerPart
//----------------------------------------------------
class Monitor implements ComputerPart{
    @Override public void accept(ComputerPartVisitor computerPartVisitor){
        computerPartVisitor.visit(this);
    }
}

//----------------------------------------------------
// Concrete implementation of ComputerPart
//----------------------------------------------------
class Mouse implements ComputerPart{
    @Override public void accept(ComputerPartVisitor computerPartVisitor){
        computerPartVisitor.visit(this);
    }
}

//----------------------------------------------------
// Concrete implementation of ComputerPart
//----------------------------------------------------
class Computer implements ComputerPart{
    ComputerPart[] parts;

    public Computer(){
        parts = new ComputerPart[] {new Mouse(), new Keyboard(), new Monitor()};
    }

    @Override public void accept(ComputerPartVisitor computerPartVisitor){
        for (int i = 0; i < parts.length; i++) {
            parts[i].accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}

//----------------------------------------------------
// Visitor interface for the computer parts
//----------------------------------------------------
interface ComputerPartVisitor{
    public void visit(Computer computer);
    public void visit(Mouse mouse);
    public void visit(Keyboard keyboard);
    public void visit(Monitor monitor);
}

//----------------------------------------------------
// Concrete implmentation of ComputerPartVisitor
//----------------------------------------------------
class ComputerPartDisplayVisitor implements ComputerPartVisitor{

    @Override public void visit(Computer computer){
        System.out.println("Displaying Computer.");
    }

    @Override public void visit(Mouse mouse){
        System.out.println("Displaying Mouse.");
    }

    @Override public void visit(Keyboard keyboard){
        System.out.println("Displaying Keyboard.");
    }

    @Override public void visit(Monitor monitor){
        System.out.println("Displaying Monitor.");
    }
}

