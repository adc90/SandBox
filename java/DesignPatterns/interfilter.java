import java.util.List;
import java.util.ArrayList;

/*  The intercepting filter design pattern is used when we want do some pre/post
 *  processing with request or response of the application. Filters are defined
 *  and applied on the request before passing the request to the actual target
 *  application. Filters can do the authentication/authorization/logging
 *  or tracking of request and then pass the request to corresponding handlers.
 *  1) Filter         : Filter which will perform certain task prior or after
 *                      execution of request by request handlers.
 *  2) Filter Chain   : Carries multiple filters and help to execute them in 
 *                      defined order on targets.
 *  3) Target         : Target object is the request handler.
 *  4) Filter Manager : Filter Manager manages the filters and Filter Chain.
 *  5) Client         : Client is the object who sends request to the Target
 *                      object.
 */

//----------------------------------------------------
// Main class
//----------------------------------------------------
public class interfilter{
    public static void main(String[] args) {
        FilterManager filterManager = new FilterManager(new Target());    
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new DebugFilter());
        
        Client client = new Client();
        client.setFilterManager(filterManager);
        client.sendRequest("HOME");
    }
}

//----------------------------------------------------
// Filter interface
//----------------------------------------------------
interface Filter{
    public void execute(String request);
}

//----------------------------------------------------
// Concrete implementation of the Filter interface
// Simply exeutes the message.
//----------------------------------------------------
class AuthenticationFilter implements Filter{
    public void execute(String request){
        System.out.println("Authenticating request: " + request);
    }
}

//----------------------------------------------------
// Concrete implementation of the Filter interface
// Simply exeutes the message.
//----------------------------------------------------
class DebugFilter implements Filter{
    public void execute(String request){
        System.out.println("Request log: " + request);
    }
}

//----------------------------------------------------
// 
//----------------------------------------------------
class Target{
    public void execute(String request){
        System.out.println("Executing request: " + request);
    }
}

//----------------------------------------------------
// 
//----------------------------------------------------
class FilterChain{

    private List<Filter> filters = new ArrayList<Filter>();
    private Target target;

    public void addFilter(Filter filter){
        filters.add(filter);
    }

    public void execute(String request){
        for (Filter filter : filters) {
            filter.execute(request);
        }
        target.execute(request);
    }

    public void setTarget(Target target){
        this.target = target;
    }
}

//----------------------------------------------------
// 
//----------------------------------------------------
class FilterManager{
    private FilterChain filterChain;

    public FilterManager(Target target){
        filterChain = new FilterChain();
        filterChain.setTarget(target);
    }

    public void setFilter(Filter filter){
        filterChain.addFilter(filter);
    }

    public void filterRequest(String request){
        filterChain.execute(request);
    }
}

//----------------------------------------------------
// Client class, sends a request through the target 
// class through the filter manager.
//----------------------------------------------------
class Client{
    private FilterManager filterManager;

    public void setFilterManager(FilterManager filterManager){
        this.filterManager = filterManager;
    }

    public void sendRequest(String request){
        filterManager.filterRequest(request);
    }
}

