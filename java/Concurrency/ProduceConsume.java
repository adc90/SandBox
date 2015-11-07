public class ProduceConsume 
{
    public static void main(String[] args)
    {
        Thread t = new Thread();
    }
}

@NotThreadSafe class UnsafeSequence
{
    private int value;
    
    public int getNext()
    {
        return value++; 
    }    
}

@ThreadSafe class Sequence
{
    @GuardedBy("this") private int nextValue;

    public synchronized int getNext()
    {
        return nextValue++;
    }
}
