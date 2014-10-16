/* The bridge pattern uses an interface to decouple the implementation
 * from the main logic. For example in this instance a DrawAPI interface
 * is used to define behavior for the circle path so that it can be 
 * implemented by the Shape class as a method call using draw() */

//----------------------------------------------------
// Main class
//----------------------------------------------------
public class bridge{
    public static void main(String[] args) {
        Shape redCircle = new Circle(100,100, 10, new RedCircle());
        Shape greenCircle = new Circle(100,100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}


//----------------------------------------------------
// Interface for the DrawAPI. This DrawAPI is designed
// for the Circle class so it can be implemented with 
// the draw() method in the shape class.
//----------------------------------------------------
interface DrawAPI{
    public void drawCircle(int radius, int x, int y);
}

//----------------------------------------------------
// Concrete implementation of the DrawAPI
//----------------------------------------------------
class RedCircle implements DrawAPI{
    @Override public void drawCircle(int radius, int x, int y){
        System.out.printf("\nDrawing Circle[color: red, radius: %d, x: %d, %d",radius, x, y);
    }
}

//----------------------------------------------------
// Concrete implementation of the DrawAPI
//----------------------------------------------------
class GreenCircle implements DrawAPI{
    @Override public void drawCircle(int radius, int x, int y){
        System.out.printf("\nDrawing Circle[color: green, radius: %d, x: %d, %d",radius, x, y);
    }
}

//----------------------------------------------------
// Abstract class defining behavior for Objects 
// inheriting from the Shape class
//----------------------------------------------------
abstract class Shape{

    protected DrawAPI drawAPI;          /* Set with a call to the constructor in the Circle class */
    protected Shape(DrawAPI drawAPI){   /* */
        this.drawAPI = drawAPI;         /* */
    }

    public abstract void draw();
}

//----------------------------------------------------
// Concrete implementation of the Shape class
//----------------------------------------------------
class Circle extends Shape{

    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI){
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw(){
        drawAPI.drawCircle(radius,x,y);
    }
}

