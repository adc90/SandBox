import java.util.Stack;

/* A stack is a LIFO data structure
 * empty()          : Test if the stack is empty
 * peek()           : Shows the object at the top of the stack
 *                    without removing it from the stack
 * pop()            : Removes the object at the top of the stack
 *                    returing that value
 * push(E item)     : Pushes an item to the top of the stack
 * search(Object o) : Returns the 
*/

public class stack{
    public static void main(String[] args){
        Stack<Integer> lifo = new Stack<Integer>(); 

        for(int i = 1; i <= 10; i++){
            lifo.push(new Integer(i));
        }
        
        while(!lifo.empty()){
            System.out.println(lifo.pop()); 
        }
    }
}
