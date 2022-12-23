package questions.arrays.sorting;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr={50,20,40,70,10,60,39,64};
        int start=0;
        int end=arr.length-1;
        mergeSort(arr,start,end);

        for(int num:arr)
            System.out.print(num+",");

    }

    private static void mergeSort(int[] arr, int start, int end) {
//Small Problem
        if(start>=end){
            return;
        }
//Divide
        int mid=start+(end-start)/2;
//Conquer
        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);
//Combine
        mergeProcedure(arr,start,mid,end);

    }

    private static void mergeProcedure(int[] arr, int start, int mid, int end) {
        //Left Array Size=end-start-1
        int[] leftArray= new int[mid-start+1];
        //Right Array
        int[] rightArray= new int[end-mid];
        //Initializing Left Sub Array
        for(int i=start;i<=mid;i++)
            leftArray[i-start]=arr[i];
        //Initializing Right Sub Array
        for(int i=mid+1;i<=end;i++)
            rightArray[i-mid-1]=arr[i];

        int m=0;
        int n=0;
        int k=start;

        //Compare between left SubArray and Right Sub Array
        while(m<leftArray.length && n<rightArray.length){

            if(leftArray[m]<=rightArray[n]){
                arr[k]=leftArray[m];
                m+=1;
            }else{
                arr[k]=rightArray[n];
                n+=1;
            }
            k+=1;

        }

        //Putting the left out elements in Array
        while(m<leftArray.length){
            arr[k]=leftArray[m];
            k+=1;
            m+=1;
        }

        while(n<rightArray.length){
            arr[k]=rightArray[n];
            k+=1;
            n+=1;
        }

    }
}
