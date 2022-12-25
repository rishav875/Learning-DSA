package questions.arrays.sorting;

public class InsertionSort {
    /*
    Keep on moving the array like a pack of card and place the small card at correct position.
    It is comparison based sorting algorithm.
    Inplace sorting algorithm.
    Time Complexity: worst case: O(n*n), Best Case: O(n)
    If Array is sorted or almost sorted, insertion sort is preferable.
     */
    public static void main(String[] args) {
        int[] arr={75,90,100,95,85,80};

        insertionSort(arr);

        for(int n: arr)
            System.out.print(n+",");
    }

    private static void insertionSort(int[] arr) {

        for(int i=0;i<arr.length;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0 && key<arr[j]){
                arr[j+1]=arr[j];
                j-=1;
            }
            arr[j+1]=key;
        }
    }
}
