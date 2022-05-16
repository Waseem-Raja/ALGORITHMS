//Las-Vegas algorithms(Identifying the repeated Element problem time(Ologn)
//problem :- Given an array of n numbers that has half distinct elements and half copies of another element, and
//you have to identify the repeated element
//solution using las vegas algorithm
import java.util.Random;

class  RepeatedElementProblem
{
    Random rand;
    RepeatedElementProblem()
    {
        rand=new Random();
    }
    public int IdentifyElement(int []arr)
    {
        while (true)
        {
            //what this algo does is simply picking randomly two different index's from the same array and checking their
            //value if it matches then we found our repeated element else repeat as many times as it takes to identify it
            int i= rand.nextInt(arr.length);
            int j= rand.nextInt(arr.length);
            if(i!=j&& arr[i]==arr[j])
                return arr[i];

        }

    }

}
public class LasVegas {
    public static void main(String[] args) {
         int []arr={1, 4, 2, 4, 4, 4, 3, 6, 4, 7,4,9};
        RepeatedElementProblem obj=new RepeatedElementProblem();
       int temp=obj.IdentifyElement(arr);
        System.out.println("Repeated Element Identified  :"+temp);
    }
}
