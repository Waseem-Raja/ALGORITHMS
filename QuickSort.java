//ALL ABOUT QUICK SORT
// QUICK SORT ALGORITHM USES DIVIDE AND CONQUER APPROACH TO SORT AN ARRAY:
// TIME COMPLEXITY OF QUICK SORT
//Best Case : O(n log n)
//Average Case :  O(n log n)
//Worst Case : O(n2)
class QuickSortAlgorithm
{

    public int PartionArray(int lowerbond, int Upperbond, int []InputArray)// partition function to Partition the Array
    {
        int temp=0;
        int i=lowerbond,j=Upperbond;    // lower index and upper index
        int pivot=InputArray[lowerbond];       // pivot element
        while (i<j) {          // loop over the array only upto when i index less than the j index
            do {
                i++;     // incrementing the i
            }while (InputArray[i] <= pivot);   // to stop at the index which contains value greater or equal to the pivot element
            do {
                j--;      // decrementing the j
            }while (InputArray[j] > pivot); // to stop at the index which contains value lesser than the pivot element


                    if (i < j) {       // don't swap when i index is greater or equal to j index
                        // swap the value at ith index with value at jth index
                        temp = InputArray[i];
                        InputArray[i] = InputArray[j];
                        InputArray[j] = temp;
                    }

        }
        // after all the partitioning is done now the exact position of element will be at the jth index
        // so we have to swap the jth index value with pivot element to set it in the exact position
        temp=InputArray[lowerbond];
        InputArray[lowerbond]=InputArray[j];
        InputArray[j]=temp;
        return j;  // returning the jth index which is correct position of pivot element
    }
    public void  QuickSortFunc(int lowebond, int Upperbond, int []arr)// Quick sort Function
    {
        int j;
        if (lowebond<Upperbond)  // Firstly  check  i is less than j that is  At least there should be two elements
        {
            j=PartionArray(lowebond,Upperbond,arr);  // firstly partition the Array which will return us the index of pivot element
            QuickSortFunc(lowebond,j,arr);        // now partition the left half of the array
            QuickSortFunc(j+1,Upperbond,arr);     // now partition the right half of array
        }

    }
    public void DisplaySortedArray(int []arr)
    {
        int n = arr.length;
        System.out.print("Sorted Array :  [");
        for (int i = 0; i < n-1; ++i)
            System.out.print(arr[i] + ",");
        System.out.print("]");
    }

}
public class QuickSort {
    public static void main(String[] args) {

        int []arr={4,3,7,2,Integer.MAX_VALUE};
        QuickSortAlgorithm obj= new QuickSortAlgorithm();
        obj.QuickSortFunc(0,arr.length-1,arr);
        obj.DisplaySortedArray(arr);

    }
}
/*
When does the worst case of Quicksort occur?
The answer depends on the strategy for choosing pivot. 
In early versions of Quick Sort where the leftmost (or rightmost) element is chosen as a pivot, the worst occurs in the following cases. 

1) Array is already sorted in the same order. 
2) Array is already sorted in reverse order. 
3) All elements are the same (a special case of cases 1 and 2) 

Since these cases are very common to use cases, the problem was easily solved by choosing either a random 
index for the pivot, choosing the middle index of the partition, or (especially for longer partitions) choosing 
the median of the first, middle and last element of the partition for the pivot. With these modifications,
the worst case of Quicksort has fewer chances to occur, but a worst case can still occur if the input array is 
such that the maximum (or minimum) element is always chosen as the pivot. 
*/
