/* The state pattern changes behavior based on its state.
 * In this example the context saves the current state that 
 * defines the behavior. */

//----------------------------------------------------
// Main class
//----------------------------------------------------
public class state{
    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);
        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);
        System.out.println(context.getState().toString());
    }
}

//----------------------------------------------------
// Interface for State
//----------------------------------------------------
interface State{
    public void doAction(Context context);
}

//----------------------------------------------------
//
//----------------------------------------------------
class StartState implements State{
    public void doAction(Context context){
        System.out.println("Player is in a start state");
        context.setState(this);
    }

    public String toString(){
        return "Start State";
    }
}

//----------------------------------------------------
// 
//----------------------------------------------------
class StopState implements State{
    public void doAction(Context context){
        System.out.println("Player is in a stop state");
        context.setState(this);
    }

    public String toString(){
        return "Stop State";
    }
}

//----------------------------------------------------
// Saves the current state.
//----------------------------------------------------
class Context{
    private State state;

    public Context(){
        state = null;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return this.state;
    }
}

