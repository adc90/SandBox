/* Example of dependency injection */

/* There are three types of dependency injection:
 * 1) Constructor : Dependencies are provided thorugh
 *                  a class constructor.
 * 2) Setter      : Dependencies are provided through 
 *                  a setter method.
 * 3) Interface   : The dependency provides an injector
 *                  method that will inject the dependency
 *                  into any client passed to it.
 */


abstract class Service{
    abstract public void execute();
    protected String message;

}

class Service1 extends Service{
    public Service1(String service){
        this.message = service;
    }

    public void execute() { 
        System.out.println("Service 1 says: " + this.message);
    }
}

class Service2 extends Service{
    public Service2(String service){
        this.message = service;
    }

    public void execute() { 
        System.out.println("Service 2 says: " + this.message);
    }
}

// Constructor injection
class Client{

    private Service service;

    //This is an example of constructor injection
    Client(Service service){
        this.service = service; 
    }

    public void setService(Service service){
        this.service = service; 
    }
}

