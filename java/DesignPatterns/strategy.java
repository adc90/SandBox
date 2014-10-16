/* The strategy pattern is useful in situations where we would like to
 * change the behavior of an object based on the context. In this example 
 * we have behavior defined using the Strategy interface which is implmenented
 * in Add, Subtract, and Multiplication. This behavior can be changed and 
 * added to the context which calls the same executeStrategy() method
 * regardless. */

//----------------------------------------------------
// Main class
//----------------------------------------------------
public class strategy{
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10,5));

        context = new Context(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(10,5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10,5));
    }
}

//----------------------------------------------------
// Interface for Strategy
//----------------------------------------------------
interface Strategy{
    public int doOperation(int num1, int num2);
}

//----------------------------------------------------
// Add operatation that implements Strategy
//----------------------------------------------------
class OperationAdd implements Strategy{
    @Override public int doOperation(int num1, int num2){
        return num1 + num2;
    }
}

//----------------------------------------------------
// Substract operation that implements Strategy
//----------------------------------------------------
class OperationSubtract implements Strategy{
    @Override public int doOperation(int num1, int num2){
        return num1 - num2;
    }
}

//----------------------------------------------------
// Multiplication operation that implements Stategy
//----------------------------------------------------
class OperationMultiply implements Strategy{
    @Override public int doOperation(int num1, int num2){
        return num1 * num2;
    }
}

//----------------------------------------------------
// Class that holds the current Strategy which can be 
// changed based on the situation.
//----------------------------------------------------
class Context{
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
