//ALL ABOUT QUICK SORT
// ALGORITHM USES DIVIDE AND CONQUER APPROACH TO SORT AN ARRAY
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
        while (i<j) {          // loop over the array only upto, when i index is less than the j index

            while (InputArray[i] <= pivot) {   // to stop at the index which contains value greater than pivot element
                i++;     // incrementing the i
            }

            while (InputArray[j] > pivot) { // to stop at the index which contains value lesser than or equal to the pivot element
                j--;      // decrementing the j
            }


            if (i < j) {       // don't swap when i index is greater or equal to j index
                // swap the value at ith index with value at jth index when i less than j
                temp = InputArray[i];
                InputArray[i] = InputArray[j];
                InputArray[j] = temp;
            }

        }
        // after all the partitioning is done now the exact position of element will be at the jth index,
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
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + ",");
        System.out.print("]");
    }

}
public class QuickSort {
    public static void main(String[] args) {

        int []arr={10,16,8,12,15,6,3,9,5};
        QuickSortAlgorithm obj= new QuickSortAlgorithm();
        obj.QuickSortFunc(0,arr.length-1,arr);
        obj.DisplaySortedArray(arr);

    }
}
