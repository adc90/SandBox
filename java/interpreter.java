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

        System.out.println("John is male?" + isMale.interpret("John"));
        System.out.println("Juilie is a married woman?"
                            + isMarriedWoman.interpret("Married Julie"));
    }
}



//----------------------------------------------------
//
//----------------------------------------------------
interface Expression{
    public boolean interpret(String context);
}

//----------------------------------------------------
//
//----------------------------------------------------
class TerminalExpression implements Expression{

    private String data;

    public TerminalExpression(String data){
        this.data = data;
    }

    @Override
    public boolean interpret(String context){
        if(context.contains(data)){
            return true;
        }
        return false;
    }
}

//----------------------------------------------------
//
//----------------------------------------------------
class OrExpression implements Expression{

    private Expression expr1 = null;
    private Expression expr2 = null;

    public OrExpression(Expression expr1, Expression expr2){
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context){
        return expr1.interpret(context) || expr2.interpret(context);
    }
}

//----------------------------------------------------
//
//----------------------------------------------------
class AndExpression implements Expression{

    private Expression expr1 = null;
    private Expression expr2 = null;

    public AndExpression(Expression expr1, Expression expr2){
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context){
        return expr1.interpret(context) && expr2.interpret(context);
    }
}
