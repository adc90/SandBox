/* The iterator pattern provides a way to iterate through your data using
 * a defined interface. In this example the NamedRepository holds the data
 * as well as a refernce to the NamedIterator. By doing so you can simply
 * step along the data sequentially.  */

//----------------------------------------------------
// Main class
//----------------------------------------------------
public class iterator{
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();

        for(Iterator iter = nameRepository.getIterator(); iter.hasNext();){
            String name = (String)iter.next();
            System.out.println("Name: " + name);
        }
    }
}

//---------------------------------------------------
// Iterator interface
//---------------------------------------------------
interface Iterator{
    public boolean hasNext();
    public Object next();
}

//----------------------------------------------------
// Container interface. Make sure we return an 
// Iterator
//----------------------------------------------------
interface Container{
    public Iterator getIterator();
}

//----------------------------------------------------
// Container that holds the data and the iterator
//----------------------------------------------------
class NameRepository implements Container {
    public String names[] = {"Robert" , "John" ,"Julie" , "Lora"};

    @Override public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        //Checks to see if the array is at the end of the line or not
        @Override public boolean hasNext() {
            if(index < names.length){
                return true;
            }
            return false;
        }

        //Steps along the array sequentially
        @Override public Object next() {
            if(this.hasNext()){
                return names[index++];
            }
            return null;
        }		
    }
}

