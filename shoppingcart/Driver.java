
/**
 * Driver for Shopping Cart
 *
 * @author (Mathew)
 * @version (9/20/2023)
 */
public class Driver
{
    public static void main (String[]args)
    {
        // Testing for Array Bag
        ShoppingCart cart = new ShoppingCart();

        // making items
        Item item1 = new Item("Carrot", 200); 
        Item item2 = new Item("Apple", 100); 
        Item item3 = new Item("Candy", 800);
        Item item4 = new Item("Shoes", 5000);
        Item item5 = new Item("computer", 10000);
        
        
       
        
        //check to see the add()
        System.out.println();
        System.out.println("Adding items...");
        System.out.println();
        cart.add(item1);
        System.out.println();
        cart.add(item2);
        System.out.println();
        cart.add(item3);
        System.out.println();
        cart.add(item5);
        System.out.println();
        
        System.out.println();
        System.out.println();
        
        //Test for addMultiple() 
        System.out.println("Adding Multiple Item...");
        System.out.println();
        cart.addMultiple(item4,5);
        
        
        System.out.println();
        System.out.println();
        
        //Test for removeSpecifiedItem() 
        System.out.println("Removing Specified...");
        System.out.println();
        cart.removeSpecifiedItem(item5);
        
        System.out.println();
        System.out.println();
        
        // Test for removeUnspecified()
        System.out.println("Removing unspecified...");
        System.out.println();
        cart.removeUnspecified();
        
        
        System.out.println();
        System.out.println();
        
        
        
        
        //checkBudget()
        System.out.println("CheckBudget....");
        System.out.println();
        cart.checkBudget(2000);
        
        System.out.println();
        System.out.println();

        //adding items to test checkout
        
        

        
        System.out.println();
        System.out.println();

        //checkout()
        System.out.println("Checkout....");
        cart.checkOut();

       
        System.out.println();

        

        

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

       
        
    }
}
