
import java.io.*;
//Backtracking and recursion approach for 0-1 knapsack problem
public class KnapsackBacktrack {


    static int max(int a, int b)
    {
        return (a > b) ? a : b;    //ternary operator to calculate maximum one
    }

    static int knapSack(int cap, int weight[], int price[], int n) //cap as capacity and n as number of items
    {
        // Base Case
        if (n == 0 || cap == 0)
            return 0;

        if (weight[n - 1] > cap)  //if weight of nth item is larger than the capacity then do not include it
            return knapSack(cap, weight, price, n - 1);

        else
            return max(price[n - 1] +
                    knapSack(cap - weight[n - 1], weight, price, n - 1),
                    knapSack(cap, weight, price, n - 1));
    }

    public static void main(String args[])
    {
      int capacity=9;

        int [] weight={3,4,5,6};
        int [] price = {4,6,7,11};


        int k = knapSack(capacity, weight, price, 4);
        System.out.println(k);
    }
}
