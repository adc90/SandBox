import java.util.ArrayList;
import java.util.List;

//----------------------------------------------------
// Main class
//----------------------------------------------------
public class builder{
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());
    }
}

//----------------------------------------------------
// Item interface 
//----------------------------------------------------
interface Item{
    public String name();
    public Packing packing();
    public float price();
}

//----------------------------------------------------
// Packing interface
//----------------------------------------------------
interface Packing{
    public String pack();
}

//----------------------------------------------------
// Concrete implementation of Packing
//----------------------------------------------------
class Wrapper implements Packing{
    @Override
    public String pack(){
        return "Wrapper";
    }
}

//----------------------------------------------------
// Concrete implementation of Packing
//----------------------------------------------------
class Bottle implements Packing{
    @Override 
    public String pack(){
        return "Bottle";
    }
}

//----------------------------------------------------
// Abstract class detailing a basic blue print for a 
// burger and implementing the Item interface
//----------------------------------------------------
abstract class Burger implements Item{

    @Override
    public Packing packing(){
        return new Wrapper();
    }
    
    @Override
    public abstract float price();
}

//----------------------------------------------------
// Abstract class detailing a basic blue print for a 
// cold drink and implementing the Item interface
//----------------------------------------------------
abstract class ColdDrink implements Item{
    
    @Override 
    public Packing packing(){
        return new Bottle();
    }

    @Override
    public abstract float price();
}

//----------------------------------------------------
// A concrete implemenation of the Burger abstract 
// class.
//----------------------------------------------------
class VegBurger extends Burger{
    
    @Override
    public float price(){
        return 25.0f;
    }

    @Override
    public String name(){
        return "Veg Burger";
    }
}

//----------------------------------------------------
// A concrete implemenation of the Burger abstract 
// class.
//----------------------------------------------------
class ChickenBurger extends Burger{
    
    @Override
    public float price(){
        return 50.5f;
    }

    @Override
    public String name(){
        return "Chicken Burger";
    }
}

//----------------------------------------------------
// A concrete implemenation of the ColdDrink abstract
// class
//----------------------------------------------------
class Coke extends ColdDrink{

    @Override
    public float price(){
        return 30.0f; 
    }

    @Override
    public String name(){
        return "Coke";
    }
}

//----------------------------------------------------
// A concrete implemenation of the ColdDrink abstract
// class
//----------------------------------------------------
class Pepsi extends ColdDrink{

    @Override
    public float price(){
        return 35.0f; 
    }

    @Override
    public String name(){
        return "Pepsi";
    }
}

//----------------------------------------------------
// Class that gets the is responsible for getting the 
// cost of a meal and displaying that information.
//----------------------------------------------------
class Meal{
    private List<Item> items = new ArrayList<Item>();
    
    public void addItem(Item item){
        items.add(item); 
    }

    public float getCost(){
        float cost = 0.0f;
        for(Item item: items){
            cost += item.price();
        } 
        return cost;
    }

    public void showItems(){
        for(Item item: items){
            System.out.print("Item: " + item.name());
            System.out.print(", Packing: " + item.packing().pack());
            System.out.println(", Price: " + item.price());
        }
    }
}

//----------------------------------------------------
// Class that creates a new meal by adding the 
// differnt elements to the Meal such as a VegBurger
// and a Coke and returning it as a Meal object.
//----------------------------------------------------
class MealBuilder{
    
    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}

