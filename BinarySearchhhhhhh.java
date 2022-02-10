// BINARY SEARCH IN DIVIDE AND CONQUER
//Binary Search is a searching algorithm for finding an element's position in a sorted array.
// In this approach, the element is always searched in the middle of a portion of an array.
//Note binary search works on a sorted collection of elements.

class DivideAndConquerrr
{
    //    The recursive method follows the divide and conquer approach.
    public int BinarySearchh(int []arr, int element, int LowerIndex, int UpperIndex)
    {

        if(LowerIndex>UpperIndex)   //condition to stop Recursion so we have to recur upto when lowerIndex meets UpperIndex
            return 0;
        else
        {

            int mid=(LowerIndex+UpperIndex)/2; // Calculating the Mid of the Array to divide it


            if(element==arr[mid])              //checking if our searchedelement is at the mid
                return mid;                // if it is then wohoo return it
            else if (element>arr[mid])          //else if it is not over there then if its greater then the mid
                return BinarySearchh(arr,element,mid+1,UpperIndex);   // then check in the right side of the array from the mid+1
            else
                return BinarySearchh(arr,element,LowerIndex,mid-1);       //else check in the left side of array upto the mid-1
        }

    }
}
public class BinarySearchhhhhhh{
    public static void main(String[] args) {

        int [] SortedArray={100,101,166,233,432,434,666,777,888};
        int elmenttobesearched=6666;
        int LowerIndex=0; // first index of array
        int UpperIndex=SortedArray.length-1;   // last index of array

        // now call to our Binary Search Algo
        DivideAndConquerrr obj= new DivideAndConquerrr();
        int returnedvalue=obj.BinarySearchh(SortedArray,elmenttobesearched,LowerIndex,UpperIndex);
        if(returnedvalue==0)
            System.out.println("Element is not present in the Array");
        else
            System.out.println("Element Found At Index ["+returnedvalue+"]");
    }
}
/*
Divide and conquer is an approach of breaking down a problem into sub problems
and combining the solutions. In binary search, on a sorted array of numbers,
 we divide (decrease) the array of numbers(search space), conquer the sub problems by recursively looking
at the middle point for our target and splitting until we find our target the base case condition.


ALGORITHM:
binarySearch(arr, x, low, high)
    if low > high
        return False
    else
        mid = (low + high) / 2
        if x == arr[mid]
            return mid
        else if x > arr[mid]        // x is on the right side
            return binarySearch(arr, x, mid + 1, high)
        else                               // x is on the right side
            return binarySearch(arr, x, low, mid - 1)

Time Complexities:
Best case complexity: O(1)
Average case complexity: O(log n)
Worst case complexity: O(log n)
Space Complexity
The space complexity of the binary search is O(1).

Binary Search Applications
In libraries of Java, .Net, C++ STL
While debugging, the binary search is used to pinpoint the place where the error happens.
 */