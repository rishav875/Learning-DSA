package questions.arrays.sorting;

public class QuickSort {
    /*
    We select a pivot and place that pivot at correct position.
    It is inplace algorithm.
    Not a stable sorting algorithm.
    When array is not sorted at all, quick sort is preferable.
    There is no combine as well as extra space in quick sort that's why quick sort is more preferable over merge sort.
    Time Complexity: Best case: O(n*logn) Worst case: O(n*n)
     */

    public static void main(String[] args) {

        int[] arr={50,40,70,10,30,90,45,67,79};
        int start=0;
        int end=arr.length-1;
        quickSort(arr,start,end);

        for(int n: arr)
            System.out.print(n+",");
    }

    private static void quickSort(int[] arr, int start, int end) {
        if(start>=end)
            return;

       int index= quickSortProcedure(arr,start,end);
       quickSort(arr,start,index-1);
        quickSort(arr,index+1,end);
    }

    private static int quickSortProcedure(int[] arr, int start, int end) {


        int pivot=arr[start];
        int i=start;
        int j=start+1;

        while(j<=end){

            if(pivot>=arr[j]){
                i+=1;
                //index=i;
                swap(arr,i,j);
            }
            j+=1;
          //  System.out.println(i);
        }
        swap(arr,start,i);


        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


}
