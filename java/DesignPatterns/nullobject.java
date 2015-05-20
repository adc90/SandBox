/* The Null Object Patter is usefull for instances where you want to
 * define behavior for what happens when you have a NullInstance. In 
 * this example if a name is not found in the database then a NullInstance
 * object is returned which holds behavior for when you run into a null 
 * value. */

//----------------------------------------------------
// Main class
//----------------------------------------------------
public class nullobject
{
    public static void main(String[] args) 
    {
        
        AbstractCustomer customer1 = CustomerFactory.getCustomer("Rob");   
        AbstractCustomer customer2 = CustomerFactory.getCustomer("Bob");   
        AbstractCustomer customer3 = CustomerFactory.getCustomer("Julie");   
        AbstractCustomer customer4 = CustomerFactory.getCustomer("Laura");   
        
        System.out.println("Customers");
        System.out.println(customer1.getName());
        System.out.println(customer2.getName());
        System.out.println(customer3.getName());
        System.out.println(customer4.getName());
    }
}

//----------------------------------------------------
// Represents the AbstractCustomer. Defines a way to  
// get the name of the customer. As well as a method 
// for checking if the customer is non-existent.
//----------------------------------------------------
abstract class AbstractCustomer
{
    protected String name;
    public abstract boolean isNil();
    public abstract String getName();
}

//----------------------------------------------------
// Represents an instance of real customer.
//----------------------------------------------------
class RealCustomer extends AbstractCustomer
{
    
    public RealCustomer(String name)
    {
        this.name = name;
    }
    
    @Override public String getName()
    {
        return name;
    }
    
    @Override public boolean isNil()
    {
        return false;
    }
}

//----------------------------------------------------
// Represents behavior for an instance of null customer.
//----------------------------------------------------
class NullCustomer extends AbstractCustomer
{
    @Override public String getName()
    {
        return "Not Availiable in Customer Database";
    }
    
    @Override public boolean isNil()
    {
        return true;
    }
}

//----------------------------------------------------
// Checks the customer database (represented as names[])
// and if name exisit then an instance of real customer
// is returned else a NullCustomer is returned.
//----------------------------------------------------
class CustomerFactory
{
    public static final String[] names = {"Rob" ,"Joe", "Julie"};
    
    public static AbstractCustomer getCustomer(String name)
    {
        for (int i = 0; i < names.length; i++) 
        {
            if(names[i].equalsIgnoreCase(name))
            {
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}

