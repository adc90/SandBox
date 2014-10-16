/* The interpreter pattern provides a way to evaluate langage grammar or
 * expressions. In this example there are 4 terminal expressions:
 *      1) Robert
 *      2) John
 *      3) Jullie
 *      4) Married
 *
 *      The first two expressions are passed to a non-terminal OrExpression. 
 *      This example is flawed because it simply test to see if either John or
 *      Robert are in the Male category and returns true. Further a similiar 
 *      thing is done with Julie and Married in the AndExpression.
 *
 *
 *  Terminal vs Non-Terminal:
 *  x can become xa | Here 'a' is a terminal expression because no rule
 *  x can become a  | exist that can change it to something else. 
 *                  | Conversly therefore 'x' is non-terminal
 * */




//----------------------------------------------------
// Main class
//----------------------------------------------------
public class interpreter{

    public static Expression getMaleExpression(){
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExpression(robert,john);
    }

    public static Expression getmarriedWomanExpression(){
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie,married);
    }

    public static void main(String[] args) {
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getmarriedWomanExpression();

        System.out.println("John is male? " + isMale.interpret("John"));
        System.out.println("Juilie is a married woman? "
                            + isMarriedWoman.interpret("Married Julie"));
    }
}

//----------------------------------------------------
// Interface for Expression
//----------------------------------------------------
interface Expression{
    public boolean interpret(String context);
}

//----------------------------------------------------
// Concrete implementation of Expression that test to 
// see if the context passed into interpret is contained
// in the data
//----------------------------------------------------
class TerminalExpression implements Expression{

    private String data;

    public TerminalExpression(String data){
        this.data = data;
    }

    @Override public boolean interpret(String context){
        if(context.contains(data)){
            return true;
        }
        return false;
    }
}

//----------------------------------------------------
// Concrete implementation of Expression that test if
// either expressions are true.
//----------------------------------------------------
class OrExpression implements Expression{

    private Expression expr1 = null;
    private Expression expr2 = null;

    public OrExpression(Expression expr1, Expression expr2){
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override public boolean interpret(String context){
        return expr1.interpret(context) || expr2.interpret(context);
    }
}

//----------------------------------------------------
// Concrete implementation of Expression that test if
// both expressions are true.
//----------------------------------------------------
class AndExpression implements Expression{

    private Expression expr1 = null;
    private Expression expr2 = null;

    public AndExpression(Expression expr1, Expression expr2){
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override public boolean interpret(String context){
        return expr1.interpret(context) && expr2.interpret(context);
    }
}

