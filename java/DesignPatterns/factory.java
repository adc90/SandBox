//----------------------------------------------------
// Main class
//----------------------------------------------------
public class factory{
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();

        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw();
    }
}

//----------------------------------------------------
// Interface for Shape
//----------------------------------------------------
interface Shape{
    void draw();
}

//----------------------------------------------------
// Concrete implmentation of Shape in the form of Rectangle
//----------------------------------------------------
class Rectangle implements Shape{
    @Override public void draw(){
        System.out.println("Inside Rectangle::draw() method.");
    }
}

//----------------------------------------------------
// Concrete impementation of Shape in the form of Square
//----------------------------------------------------
class Square implements Shape{
    @Override public  void draw(){
        System.out.println("Inside Square::draw() method.");
    }
}

//----------------------------------------------------
// Concrete impementation of Shape in the form of Circle
//----------------------------------------------------
class Circle implements Shape{
    @Override public  void draw(){
        System.out.println("Inside Circle::draw() method.");
    }
}

//----------------------------------------------------
// Shape factory class, returns an instance of either
// a rectangle, circle, or square based on a request
// in the form a a String
//----------------------------------------------------
class ShapeFactory{
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null; // What is the point of this
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}

