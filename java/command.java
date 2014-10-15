/* Command pattern is used to abstract various functionality into a common 
 * interface that can be called. In this example buy and sell stocks are placed 
 * into two concrete Order instatations where they can be executed all at once by a 
 * Broker object at a later time. */

import java.util.ArrayList;
import java.util.List;

//----------------------------------------------------
// Main class
//----------------------------------------------------
public class command{

    public static void main(String[] args) {
        Stock abcStock = new Stock();
        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);
        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);
        broker.placeOrders();
    }
}

//----------------------------------------------------
// Defines an interface for the Order hiarchy. 
//----------------------------------------------------
interface Order {
    void execute();
}

//----------------------------------------------------
// Stock class which holds a name and quality. 
// Implements the obvious buy and sell functionality 
// as well.
//----------------------------------------------------
class Stock {
    private String name = "ABC";
    private int quantity = 10;

    public void buy(){
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] bought");
    }

    public void sell(){
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] sold");
    }
}

//----------------------------------------------------
// The buy stock class uses the stocks buy functionality
// in a way that can be utilized by calling execute()
// from the Order interface
//----------------------------------------------------
class BuyStock implements Order{
    private Stock abcStock;

    public BuyStock(Stock abcStock){
        this.abcStock = abcStock; 
    }

    public void execute(){
        abcStock.buy(); 
    }
}

//----------------------------------------------------
// The functionality here is the same as the BuyStock
// class except in reverese (sell stock)
//----------------------------------------------------
class SellStock implements Order{
    private Stock abcStock;

    public SellStock(Stock abcStock){
        this.abcStock = abcStock; 
    }

    public void execute(){ //Sell is mapped to the execute function of the Order interface
        abcStock.sell(); 
    }
}
 
//----------------------------------------------------
// The Broker class mainly just iterates through a list
// or orders and executes them. The cleveness from this
// pattern comes from the fact that the abstraction allows the 
// Broker class to simply iterate and call order.execute()
//----------------------------------------------------
class Broker{
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order){
        orderList.add(order); 
    }

    public void placeOrders(){
        for(Order order: orderList){
            order.execute(); 
        }
        orderList.clear();
    }
}

