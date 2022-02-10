 //ALL ABOUT MERGE SORT
 //Time Complexity in every case : O(n Log n)
    class MergeSortt {

        // Merge two subarrays LeftHalf and Rifhthalf into (arr) Array
       public void Merge(int arr[], int Lowerbond, int MiddleIndex, int Upperbnd) {

              // Calculating the Size of the two halfs
            int LeftHalffSize = MiddleIndex - Lowerbond + 1; // this will be the size of left half of an array
            int RightHalfSize = Upperbnd - MiddleIndex;      // size of right half of an array
// These two array's are temporary arrays used to contain two halfs of array
            int LeftHalf[] = new int[LeftHalffSize];
            int RightHalf[] = new int[RightHalfSize];
// copying the elements from original array with left half and right half  so that we can merge these two for sorting later on
            for (int i = 0; i < LeftHalffSize; i++)
                LeftHalf[i] = arr[Lowerbond + i];
            for (int j = 0; j < RightHalfSize; j++)
                RightHalf[j] = arr[MiddleIndex + 1 + j];

            // Maintain current index of sub-arrays and main array
            int i=0, j=0, k=Lowerbond;
           // Now Start Merging the two subarrays
            while (i < LeftHalffSize && j < RightHalfSize) {
                if (LeftHalf[i] <= RightHalf[j])
                    arr[k++] = LeftHalf[i++];

                 else
                    arr[k++] = RightHalf[j++];
            }

            // When we run out of elements in either LeftHalf
            // put  the remaining elements  in Original arr Array
            while (i < LeftHalffSize) {
                arr[k++] = LeftHalf[i++];
            }
           // When we run out of elements in either RightHalf
           // put  the remaining elements  in Original arr Array
            while (j < RightHalfSize) {
                arr[k++] = RightHalf[j++];
            }
       }

        // Divide the array into two subarrays, sort them and merge them
        public void DivideAndConquer(int arr[], int Lowerbond, int Upperbond) {
            if (Lowerbond < Upperbond) {         // we have to divide only upto two elements i.e one element is sorted

                // MiddleIndex is the point where the array is divided into two subarrays
                int MiddleIndex = (Lowerbond + Upperbond) / 2;

                DivideAndConquer(arr, Lowerbond, MiddleIndex);
                DivideAndConquer(arr, MiddleIndex + 1, Upperbond);

                // Merge the sorted subarrays
                Merge(arr, Lowerbond, MiddleIndex, Upperbond);
            }
        }

        // Print the Sorted Array
        public  void printSortedArray(int arr[]) {
            int n = arr.length;
            System.out.print("Sorted Array :  [");
            for (int i = 0; i < n; ++i)
                System.out.print(arr[i] + ",");
            System.out.print("]");
        }

    }
    public class MergeSort {

        public static void main(String args[]) {
            int arr[] = {4,3,7,2,8};

            MergeSortt ob = new MergeSortt();
            ob.DivideAndConquer(arr, 0, arr.length - 1);
            ob.printSortedArray(arr);
        }
    }



























//import java.util.Scanner;
//
////MERGE SORT USE'S DIVIDE AND CONQUER TECHNIQUE
//class MergeSortt
//{
//
//   public void MergeSortFunc(int []arr2,int []LeftHalf, int []RightHalf)
//    {
//        int i=0,j=0,k=0;
//        int LeftHalfSize=LeftHalf.length;
//        int RightHalfSize=RightHalf.length;
//
//               while (i<LeftHalfSize && j<RightHalfSize)
//               {
//                   if(LeftHalf[i]<=RightHalf[j])
//                       arr2[k++]=LeftHalf[i++];
//
//                   else
//                       arr2[k++]=RightHalf[j++];
//
//
//               }
//               while(i<LeftHalfSize)
//                   arr2[k++]=LeftHalf[i++];
//
//               while (j<RightHalfSize)
//                   arr2[k++]=RightHalf[j++];
//
//
//    }
//
//   public void DivideAndConquer( int []arr)
//    {
//        if (arr.length>2) {
//
//            int MiddleIndex= (arr.length) / 2;   //Locating the middle Index for Divison of Arraay
//            int []LeftHalf=new int[MiddleIndex];
//            int []RightHalf= new int[arr.length-MiddleIndex];
//
//            for( int i=0; i<MiddleIndex;i++)
//                LeftHalf[i]=arr[i];
//            for( int j=MiddleIndex; j<arr.length;j++)
//                RightHalf[j-MiddleIndex]=arr[j];
//
//            DivideAndConquer(LeftHalf); ///firstly left half is recursively called
//            DivideAndConquer(RightHalf); // Then right half is recursively called
//
//            MergeSortFunc( arr,LeftHalf,RightHalf);   // Merge call to merge function
//
//        }
//    }
//   public void DisplaySortedArray(int []sortedArray)
//    {
//        System.out.print("Sorted Array: [");
//        for (int i=0; i <sortedArray.length;i++)
//        {
//            System.out.print( sortedArray[i]+",");
//        }
//        System.out.print("]");
//    }
//
//
//}F
//public class MergeSort {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int size=4;
//        MergeSortt obj= new MergeSortt();
//        int []array={4,3,4,3};//new int[size];
//        obj.DivideAndConquer(array);
//        obj.DisplaySortedArray(array);
//
//    }
//}
