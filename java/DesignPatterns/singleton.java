//----------------------------------------------------
// Main class
//----------------------------------------------------
public class singleton{
    public static void main(String[] args) 
    {
        SingleObject object = SingleObject.getInstance();
        object.showMessage();
    }
}

//----------------------------------------------------
// Singleton class, only one singleton object can be
// created at one time 
//----------------------------------------------------
class SingleObject
{
    private static SingleObject instance = new SingleObject();

    /* The constructor is delcared private so that we can not
     * initialize the object normally */
    private SingleObject()
    {
        System.out.println("Hello World");
    }

    /* Instead we use the static method here which only allows us
     * to create one instance of this object */
    public static SingleObject getInstance()
    {
        if(instance == null){
            instance = new SingleObject();
        }
        return instance;
    }
    
    /* This is just a plain on instance method */
    public void showMessage()
    {
        System.out.println("Hello World!");
    }

    public void showMessage()
    {
        System.out.println("Hello World");
    }
}

