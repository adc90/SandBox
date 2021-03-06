import java.lang.util.Random;
import java.util.HashMap;

/* This pattern allows for pooling of resources. For example
 * during the program 20 random colors are called, if a color 
 * is called that is already selected it is retrieved from the hash
 * map allowing for the reuse of that object. This pattern only makes
 * sense in certain context where unique objects aren't needed however */
 
//----------------------------------------------------
// Main class
//----------------------------------------------------
public class flyweight{
    private static final String colors[] = { "Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {
        for (int i = 0; i < 20; ++i) { 
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }

    private static String getRandomColor(){
        return colors[(int)(Math.random() * colors.length)];
    }

    private static int getRandomX(){
        return (int)(Math.random() * 100);
    }

    private static int getRandomY(){
        return (int)(Math.random() * 100);
    }
}

//----------------------------------------------------
// Interface for Shape
//----------------------------------------------------
interface Shape{
    void draw();
}

//----------------------------------------------------
// Concrete implementation of the Shape interface
//----------------------------------------------------
class Circle implements Shape{

    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color){
        this.color = color;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setRadius(int radius){
        this.radius = radius;
    }

    @Override public void draw(){
        System.out.println("Circle: Draw() [Color: "
                             + color +", x: " + x
                             +", y:" +", radius: "
                             + radius +"]");
    }
}

//----------------------------------------------------
//
//----------------------------------------------------
class ShapeFactory{
    private static final HashMap<String, Shape> circleMap = new HashMap();

    public static Shape getCircle(String color){
        Circle circle = (Circle)circleMap.get(color);
        if(circle == null){
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color: " + color);
        }
        return circle;
    }
}

