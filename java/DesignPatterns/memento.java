/* The Memento design pattern allows you to save the
 * state of an object into an immutable object called a memento.
 * In this example only States 2,3 are saved in the CareTaker
 * class. Basically the pattern boils down to three seperate classes:
 *
 * 1) Memento    : An immutable class that holds a state that is saved
 *                 by the Originator
 * 2) Originator : A mutable class that holds a current state and can further
 *                 save that state as a Memento in order to save that state
 *                 permanently
 * 3) Caretaker  : A class that holds all the previous states as Memento objects
 *
 * Note: A neat addition to this pattern would be to string together states in 
 * the chain allowing you to create an undo tree.
 * */

import java.util.ArrayList;
import java.util.List;

//----------------------------------------------------
// Main class
//----------------------------------------------------
public class memento{
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("State #1");
        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #4");

        System.out.println("Current State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}

//----------------------------------------------------
// Memento class that stores a state, set by it's
// constructor and is able to retrieve that state later
//----------------------------------------------------
class Memento{
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}

//----------------------------------------------------
// Acts as a enhanced Memento class esentially. Allows
// the setting of the current state as well as the saving
// of the state to an immutable Memento class.
//----------------------------------------------------
class Originator{

    private String state;

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento){
        state = memento.getState();
    }
}

//----------------------------------------------------
// The CareTaker class allows you to add a previous
// state to the list of immutable Memento objects.
//----------------------------------------------------
class CareTaker{
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }
}

