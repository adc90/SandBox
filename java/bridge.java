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
// 
//----------------------------------------------------
interface DrawAPI{
    public void drawCircle(int radius, int x, int y);
}

//----------------------------------------------------
// 
//----------------------------------------------------
class RedCircle implements DrawAPI{
    @Override
    public void drawCircle(int radius, int x, int y){
        System.out.printf("\nDrawing Circle[color: red, radius: %d, x: %d, %d",radius, x, y);
    }
}

//----------------------------------------------------
// 
//----------------------------------------------------
class GreenCircle implements DrawAPI{
    @Override
    public void drawCircle(int radius, int x, int y){
        System.out.printf("\nDrawing Circle[color: green, radius: %d, x: %d, %d",radius, x, y);
    }
}

//----------------------------------------------------
// 
//----------------------------------------------------
abstract class Shape{

    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}

//----------------------------------------------------
// 
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

