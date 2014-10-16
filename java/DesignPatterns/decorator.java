/* The Decorator pattern allows you to add behavior to a 
 * class by decorating the each successive object with 
 * addtional behavior. In this example RedShapeDecorator
 * is passed a Circle object which has it's behavior held
 * inside the Decorator super class. The RedShapeDecorator then
 * redefines the draw() method calling it's additonal behavior 
 * as well as calling the previous behavior stored in the Decorator
 * base class.   */

//----------------------------------------------------
// Main class
//----------------------------------------------------
public class decorator{
    public static void main(String[] args) {
        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}

//----------------------------------------------------
// Shape interface
//----------------------------------------------------
interface Shape{
    void draw();
}

//----------------------------------------------------
// Concrete impmenetation of the Shape interface
//----------------------------------------------------
class Rectangle implements Shape{
    @Override public void draw(){
        System.out.println("Shape: Rectangle");
    }
}

//----------------------------------------------------
// Concrete impmenetation of the Shape interface
//----------------------------------------------------
class Circle implements Shape{
    @Override public void draw(){
        System.out.println("Shape: Circle");
    }
}

//----------------------------------------------------
// Abstract class that implements the Shape interface.
// The point of this class is to allow you to add in
// additional behavior further down the line without
// affecting the behavior of the original class.
//----------------------------------------------------
abstract class ShapeDecorator implements Shape{

    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}

//----------------------------------------------------
// In the class decoratedShape is passed to the 
// ShapeDecorator super class.
//----------------------------------------------------
class RedShapeDecorator extends ShapeDecorator{

    public RedShapeDecorator(Shape decoratedShape){
        super(decoratedShape);
    }

    @Override public void draw(){
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}

