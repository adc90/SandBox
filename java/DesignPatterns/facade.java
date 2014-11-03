/* This pattern creates a facade in order to hide the logic of object creation.
 * In this example Rectangle,Circle, and Square are created in the ShapeMaker
 * class. From there you can simply call the differnt methods to draw the differn
 * shapes.  */

//----------------------------------------------------
// Main class
//----------------------------------------------------
public class facade{
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}

//----------------------------------------------------
// Shape interface
//----------------------------------------------------
interface Shape{
    void draw();
}

//----------------------------------------------------
// Concrete implemenation of the Shape interface
//----------------------------------------------------
class Rectangle implements Shape{
    @Override public void draw(){
        System.out.println("Rectangle::draw()");
    }    
}

//----------------------------------------------------
// Concrete implemenation of the Shape interface
//---------------------------------------------------
class Square implements Shape{
    @Override public void draw(){
        System.out.println(" Square::draw()"); 
    }    
}

//----------------------------------------------------
// Concrete implemenation of the Shape interface
//----------------------------------------------------
class Circle implements Shape{
    @Override public void draw(){
        System.out.println("Circle::draw()");
    }    
}

//----------------------------------------------------
// Facade for the draw method of the shapes
//----------------------------------------------------
class ShapeMaker{
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker(){
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }

    public void drawRectangle(){
        rectangle.draw();
    }

    public void drawSquare(){
        square.draw(); 
    }
}

