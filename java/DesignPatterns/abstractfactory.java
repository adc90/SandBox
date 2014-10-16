//----------------------------------------------------
// Main class
//----------------------------------------------------
public class abstractfactory{
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();

        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

        Color color1 = colorFactory.getColor("RED");
        color1.fill();

        Color color2 = colorFactory.getColor("GREEN");
        color2.fill();

        Color color3 = colorFactory.getColor("BLUE");
        color3.fill();
    }

}

//----------------------------------------------------
// Interface for Shape
//----------------------------------------------------
interface Shape{
    void draw();
}

//----------------------------------------------------
// Interface for Color
//----------------------------------------------------
interface Color{
    void fill();
}

//----------------------------------------------------
// Concrete implmentation of Shape
//----------------------------------------------------
class Rectangle implements Shape{
    @Override
    public void draw(){
        System.out.println("Inside Rectangle::draw() method.");
    }
}

//----------------------------------------------------
// Concrete implmentation of Shape
//----------------------------------------------------
class Square implements Shape{
    @Override
    public void draw(){
        System.out.println("Inside Square::draw() method.");
    }
}

//----------------------------------------------------
// Concrete implmentation of Shape
//----------------------------------------------------
class Circle implements Shape{
    @Override
    public void draw(){
        System.out.println("Inside Circle::draw() method.");
    }
}

//----------------------------------------------------
// Concrete implmentation of Color
//----------------------------------------------------
class Red implements Color{
    @Override 
    public void fill(){
        System.out.println("Inside Red::fill() method.");
    }
}

//----------------------------------------------------
// Concrete implmentation of Color
//----------------------------------------------------
class Green implements Color{
    @Override 
    public void fill(){
        System.out.println("Inside Green::fill() method.");
    }
}

//----------------------------------------------------
// Concrete implmentation of Color
//----------------------------------------------------
class Blue implements Color{
    @Override 
    public void fill(){
        System.out.println("Inside Blue::fill() method.");
    }
}

//----------------------------------------------------
// Abstract class setting the blue print for creating 
// further factories
//----------------------------------------------------
abstract class AbstractFactory{
    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}

//----------------------------------------------------
// Implementation of the AbstractFactory
//----------------------------------------------------
class ShapeFactory extends AbstractFactory{
    
    @Override 
    Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
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

    @Override
    Color getColor(String color){
        return null;
    }
}

//----------------------------------------------------
// Implementation of the Abstract Factory
//----------------------------------------------------
class ColorFactory extends AbstractFactory{
    
    @Override 
    Shape getShape(String shapeType){
        return null;
    }

    @Override
    Color getColor(String color){
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        }else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        }else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }
}

//----------------------------------------------------
// A factory method for producing factories
//----------------------------------------------------
class FactoryProducer{
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        }else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}

