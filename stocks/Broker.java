import java.util.NoSuchElementException;

/**
 *
 *
 * @Mathew Sabu
 * @version (a version number or a date)
 */
public class Broker
{
    //made a linked deque
    DequeInterface<StockLot> leger;    
    //variable to keep track the total
    double totalCapitalGainAndLosses;
    public Broker()
    {
        totalCapitalGainAndLosses=0.0;
        leger = new LinkedDeque();
    }

    // parameters - numberOfStocks = the stocks the user wants to buy/ stockPrice - the amount the user want to but the stock at
    public void buy(int numberOfStocks, double stockPrice)
    {
        //storing user input into a object of type StockLot
        StockLot stock = new StockLot(numberOfStocks,stockPrice);

        //check to see if the number is below 0
        if(numberOfStocks<0 && stockPrice < 0)
        {
            System.out.println("Invalid purchase");
        }
        //storing the object in the back
        else
        {
            leger.addToBack(stock);
            System.out.println("The number of stocks you bought is " + numberOfStocks+ " and the price is $"+ stockPrice);

        }
    }
    //parameters - the number of shares the user wants to sell and at what price (int numShares, double price)
    public void sell(int numShares, double price)
    {
        // while the numshares is greater than 0
        try
        {
            while(numShares > 0)
            {
                double tempGainloss = 0;
                // this gets the front of object

                StockLot lot = leger.getFront();
                //this gets the buyprice of the first lot
                double buyPrice = lot.getBuyPrice();
                // this gets the first shares
                int firstShares = lot.getShares();
                //if its parital lot
                if(firstShares > numShares)
                {
                    // get the remaining shares

                    System.out.println("First lot shares: " + firstShares);
                    System.out.println("Stocks to sell from lot " + numShares);

                    //gets the left over shares
                    int leftOverShares = firstShares - numShares;
                    lot.setShares(leftOverShares);
                    // get the price Difference
                    //(selling amount price - the price of the share )* sold
                    double priceDiff = (price - buyPrice);
                    tempGainloss += priceDiff * numShares;
                    //keep track of the gains/losses

                    numShares = 0;

                    System.out.println("Buy Price: " + buyPrice);
                    System.out.println("Sell Price: " + price);
                    System.out.println("Total gains and Losses: " + tempGainloss);
                    System.out.println("Shares remaining after Sale " + leftOverShares);
                    System.out.println("Sold Part of Lot");
                    System.out.println();

                }
                //selling the whole lot
                else
                {
                    //calculate the total

                    double priceDiff = (price - buyPrice);
                    tempGainloss = priceDiff * firstShares;

                    System.out.println("Stocks to sell: " + firstShares);
                    //finding the difference of the first share from the number the user inputed
                    numShares -= firstShares;
                    leger.removeFront();
                    //displaying the outputs
                    System.out.println("Buy Price: " + buyPrice);
                    System.out.println("Sell Price: " + price);
                    System.out.println("Total gains and Losses: " + tempGainloss);
                    System.out.println("Sold Full of a Lot");
                    System.out.println();

                }
                //updating totalCapitalGainAndLosses
                totalCapitalGainAndLosses += tempGainloss;
            }
        }
        // exception if they enter too mnay stocks to sell
        catch(Exception e)
        {

            if(e instanceof NoSuchElementException)
            {
                System.out.println("You are selling too many stocks ");
            }

        }
    }
    //displays the total
    public void getTotalCapitalGain()
    {
        System.out.println("The total is : " + totalCapitalGainAndLosses);
    }

}

