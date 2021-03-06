import java.util.*;

public class HelloRunnable 
{
    public static void main(String args[]) 
    {
        Producer producer = new Producer();
        new Thread(producer).start();
        Consumer consumer = new Consumer(producer);
        new Thread(consumer).start();
    }
}

class Consumer implements Runnable 
{
    Producer producer;

    public Consumer(Producer producer)
    {
        this.producer = producer;
    }

    public void run() 
    {
        while(true)
        {
            String message = producer.getMessage();
            System.out.println("Got message: " + message);
            try {
                Thread.sleep(4000);
            } catch(InterruptedException e) { }
        }
    }
}

class Producer implements Runnable
{
    static final int MAXQUEUE = 5;
    private List messages = new ArrayList();

    public void run()
    {
        while(true) {
            putMessage();
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) { }
        }
    }   
    private synchronized void putMessage()
    {
        while(messages.size() == MAXQUEUE)
        {
            try {
                wait();
            } catch(InterruptedException e) { }
        }
        messages.add(new java.util.Date().toString());
        notify();
    }
    public synchronized String getMessage()
    {
        while(messages.size() == 0) {
            try {
                notify();
                wait();
            } catch(InterruptedException e) { }
        }
        String message = (String)messages.remove(0);
        notify();
        return message;
    }
}

