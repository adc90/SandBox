public class ProduceConsume 
{
    public static void main(String[] args)
    {
        System.out.println("Hello");
    }
}

@NotThreadSafe
class UnsafeSequence
{
    private int value;
    
    public int getNext(){
        return value++; 
    }    
}

@ThreadSafe
class Sequence
{
    @GuardedBy("this") private int nextValue;

    public synchronized int getNext(){
        return nextValue++;
    }
}
