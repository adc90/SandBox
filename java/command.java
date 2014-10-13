//=======================================================
// Command Pattern in Java
//=======================================================

import java.util.ArrayList;
import java.util.List;

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

interface Order {
    void execute();
}

//------------------------------------
// The stock class holds the methods 
// needed to manager the stock itself
//------------------------------------
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
//---------------------------------
// This class abstracs the execute
// method from the stock
//---------------------------------
class BuyStock implements Order{
    private Stock abcStock;

    public BuyStock(Stock abcStock){
        this.abcStock = abcStock; 
    }

    public void execute(){
        abcStock.buy(); 
    }
}

class SellStock implements Order{
    private Stock abcStock;

    public SellStock(Stock abcStock){
        this.abcStock = abcStock; 
    }

    public void execute(){
        abcStock.sell(); 
    }
}

//---------------------------------------
// The Brocker executes differnt commands
// based on what is passed to it.
//---------------------------------------
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

