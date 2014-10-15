/* The Observer pattern can be summed up in two patterns:
 * 1) Subject: Holds both a State and a list of Observers that
 *    would like to be moddified to changes in that state.
 * 2) Observers: A class that peforms some operation on the information held
 *    by the Subject and will perform this operation when notified to any changes
 *    in the Subject
 *
 *    Note: This can be thought of as a subscription model. You subscribe to a 
 *    news letter and they update you on any changes. The Subject class could in
 *    some cases be made a Singleton, though the benifit is not known.
 *
 */

import java.util.ArrayList;
import java.util.List;

//----------------------------------------------------
// Main class
//----------------------------------------------------
public class observer{
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state chagne: 10");
        subject.setState(10);
    }
}

//----------------------------------------------------
// The subject class is responsible for a maintaining
// a state (in this case an `int`) as well as a list 
// of Observer classes which is holds and notifies 
// of any changes to it's state.
//----------------------------------------------------
class Subject{
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState(){
        return state;
    }

    public void setState(int state){
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        } 
    }
}

//----------------------------------------------------
// Abstract class for the Observers which defines two
// necessary components:
// 1) The subject which the Observer attaches itself.
// 2) The update method called by the subject.
//----------------------------------------------------
abstract class Observer{
    protected Subject subject;
    public abstract void update();
}

//----------------------------------------------------
// Concrete implmentation of the Observer
//----------------------------------------------------
class BinaryObserver extends Observer{
    
    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(){
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}

//----------------------------------------------------
// Concrete implmentation of the Observer
//----------------------------------------------------
class OctalObserver extends Observer{
    
    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(){
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
    }
}

//----------------------------------------------------
// Concrete implmentation of the Observer
//----------------------------------------------------
class HexaObserver extends Observer{

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(){
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}

