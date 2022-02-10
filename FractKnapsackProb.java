import java.util.Scanner;

//FRACTIONAL KNAPSACK PROBLEM
//FKP using GREEDY APPROACH
// FKP: here we have n items with n associated values say profits for each item
// and we have a knapsack bag with some predefined capacity
// now we have to fill this bag  with these n items in a such a way so  that we should not overflow the bag's
// predifined capacity and we should have maximum profit at the end
class KnapsackProblem
{
    double [] RatioArray;
    double [] WeightArray;
    double [] ProfitArray;
    int size;
    int count;
    double KnapsackBagCapacity;
     KnapsackProblem(int size, int Capacity)
    {
        RatioArray = new double[this.size = size];
        WeightArray =new double[this.size=size];
        ProfitArray = new double[this.size];
        count=0;
        KnapsackBagCapacity=Capacity;
    }
    public void SortTheRatio(double weight , double profit)
    {
        double Ratio= profit/weight;
        count++;
        double temporaryRatio, temporarayWeight, temporararyProfit;
        for (int i=0;i<count;i++)
        {
            if (Ratio>RatioArray[i])
            {
//                this.profit+=profit;
                temporaryRatio=RatioArray[i];
                RatioArray[i]= Ratio;
                temporarayWeight=WeightArray[i];
                WeightArray[i]=weight;
                temporararyProfit=ProfitArray[i];
                ProfitArray[i]=profit;
                Ratio=temporaryRatio;
                weight=temporarayWeight;
                profit=temporararyProfit;

            }

        }
    }
    public void FillTheBag()
    {

            int itemss=0;
            double ChoosenWeight=0;
            double totalProfit=0;
            double RemainingWeight=0;
             int temp=0;

            for (int i=0;i<this.size;i++) {

                if(ChoosenWeight<this.KnapsackBagCapacity)
                {
                    if (RemainingWeight<WeightArray[i])
                    {
                        ChoosenWeight=ChoosenWeight+RemainingWeight;
                        totalProfit= totalProfit+ (RemainingWeight/WeightArray[i])* ProfitArray[i];
                        itemss++;
                        temp++;
                    }
                    if(temp==1) {
                        totalProfit = totalProfit + ProfitArray[i];
                        ChoosenWeight = ChoosenWeight + WeightArray[i];
                        RemainingWeight = this.KnapsackBagCapacity - ChoosenWeight;
                        itemss++;
                    }

                }
           }
        System.out.println("Capacity of Knapsack :"+ this.KnapsackBagCapacity);
        System.out.println("total Profit is : "+ totalProfit);
        System.out.print("by choosing  items having weight ");
        if(temp==2)
        {
            int h=0;
            for (int j = 0; j < itemss - 2; j++) {
                System.out.print(WeightArray[j] + ",");
                h=j;
            }
            System.out.println();
            System.out.println("And lastly take remaining weight from item having weight :"+ WeightArray[h+1]);
        }
        else {
            for (int j = 0; j < itemss - 1; j++)
                System.out.print(WeightArray[j] + ",");
        }


    }


}
public class FractKnapsackProb {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        double weight, profit;
       KnapsackProblem obj= new KnapsackProblem(4,60);

        for (int i=0;i<4;i++)
        {
            System.out.println("please Enter the weight ");
            weight=scan.nextDouble();
            System.out.println("please enter the profit");
            profit=scan.nextDouble();
            obj.SortTheRatio(weight, profit);
        }

        obj.FillTheBag();

    }
}
