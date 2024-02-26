
/**
 * ShoppingCart
 *
 * @author (Mathew Sabu)
 * @version (9/20/2023)
 */
public class ShoppingCart
{  
    BagInterface<Item> bag;
    //instance variable
    int total; 
    
    //Constructor
    public ShoppingCart()
    {
        total = 0;
        bag = new ArrayBag(); // This shows that the bag is a ArrayBag.
        
    }
    
    //Parameterized Constructor
    public ShoppingCart(BagInterface<Item> passedBag)
    {
        total = 0;
        bag = passedBag;
    }
    
    //@param anItem - the item being added to the shopping cart
    public boolean add(Item anItem)
    {
        //keeps track of the total amount
        total += anItem.getPrice();
        System.out.println(anItem.toString() + ", has been added to the cart");
        System.out.println("The total is: " + total/100 + "." + total%100);
        return(bag.add(anItem));
    }
    
    //@param anItem - the item being added to the bag
    //@param totalItems- how many times of that item has been added to the bag
    public boolean addMultiple(Item anItem, int totalItems)
    {   
        
        //check to see if no items were placed in the bag
        if (totalItems <=0)
        {
            System.out.println("No items were placed in the bag");
            
        }
        for(int i = 0; i < totalItems; i++)
        {
            
            bag.add(anItem); //adding an item
            System.out.println("The item that has been added is "+ anItem.toString());
            total += anItem.getPrice(); // updating the total
        }
        System.out.println();
        
        //prints out the items and the amount of times it has been added
        System.out.println(anItem.getName() +" has been added " +totalItems+ " times" );
        System.out.println("The total is: " + total/100 + "." + total%100);
        
        return true;
        
    }
    
    // @param budgetAmount -  The budget/ the most you can spend
    
    public boolean checkBudget(int budgetAmount)
    {
        System.out.println("The budget is: " + budgetAmount/100+ "." +budgetAmount%100);
        while (total >=budgetAmount)
        {
            
            System.out.println("The total while taking out items: " + total/100 + "." + total%100);
            //while the total > budgetAmount, we remove an item until total < budgetAmount
            Item itemRemoved = bag.remove();
            total -= itemRemoved.getPrice();         
        }
        System.out.println("The total after taking out itmes: " + total/100 + "." + total%100);
        return true;
    }
    
    
    //removes a unspecified item
    public boolean removeUnspecified()
    {   
        //checks to see if the bag is empty 
        if(bag.isEmpty())
        {
            System.out.println("The bag is empty");
        }
        else
        {
            Item itemRemoved = bag.remove(); // calling remove() to remove an item
            total -= itemRemoved.getPrice(); // update the price after being removed 

            System.out.println("An item has been removed");
            System.out.println("The total is : " + total/100 + "." + total%100);
            System.out.println();
            

        }
        return true;
    }
    
    
    //Removes a specified item
    //@param anItem - the item to be removed in the bag
    public boolean removeSpecifiedItem(Item anItem)
    {
        boolean result = bag.remove(anItem);
        
        if(bag.isEmpty())
        {
            System.out.println("The cart is empty");
        }
        else if(result)
        {
            total -= anItem.getPrice(); //decrement the total based on the items price.
            System.out.println("The item that was removed is: " + anItem.toString());
            System.out.println("The total is: " + total/100 + "." + total%100);
            
            
        }
        return result;
    }
    
    
    
    
    public int checkOut()
    { 
        //while the bag is not empty continue to take items out
        while(!bag.isEmpty())
        {
            //calling the remove unspecified to remove an item until the bag is empty
            Item result = bag.remove();   
            System.out.println(result.toString()); 
        }

        //The bag is now empty, we will print the total price of everything in the bag
        System.out.println();
        System.out.println("The total is: " + total/100 + "." + total%100);
        System.out.println();

        return total; 
    }
    
    
    
    
    
}