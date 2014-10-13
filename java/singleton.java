//----------------------------------------------------
// Main class
//----------------------------------------------------
public class singleton{
    public static void main(String[] args) {
        SingleObject object = SingleObject.getInstance();

        object.showMessage();
    }
}

//----------------------------------------------------
// Singleton class, only one singleton object can be
// created at one time 
//----------------------------------------------------
class SingleObject{

    private static SingleObject instance = new SingleObject();

    private SingleObject(){}

    public static SingleObject getInstance(){
        if(instance == null){
            instance = new SingleObject();
        }
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }
}

