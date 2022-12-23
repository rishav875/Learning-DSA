package questions.arrays.searching;

import java.util.Arrays;

/*
Find Pair Given Difference
Given an array Arr[] of size L and a number N, you need to write a program to find if there exists a pair of elements in the array whose difference is N.

Example 1:

Input:
L = 6, N = 78
arr[] = {5, 20, 3, 2, 5, 80}
Output: 1
Explanation: (2, 80) have difference of 78.
Example 2:

Input:
L = 5, N = 45
arr[] = {90, 70, 20, 80, 50}
Output: -1
Explanation: There is no pair with difference of 45.
Your Task:
You need not take input or print anything. Your task is to complete the function findPair() which takes array arr, size of the array L and N as input parameters and returns True if required pair exists, else return False.

Expected Time Complexity: O(L* Log(L)).
Expected Auxiliary Space: O(1).
 */
public class FindPairGivenDifference {

    public static void main(String[] args) {

        int arr[]={5, 20, 3, 2, 5, 80};
        int size=6;
        int n=0;

        System.out.println("Answer through Binary Search: "+findPair_UsingBinarySearch(arr,size,n));
        System.out.println("Answer through best approach: "+findPair_nLogn(arr,size,n));
    }

// O(n*logn)
    public static boolean findPair_UsingBinarySearch(int arr[], int size, int n)
    {
        Arrays.sort(arr);

        int j=size-1;
        int i=0;

        for(int k=0;k<size;k++){

            int key= n+arr[k];

            boolean result=binarySearch(arr,k+1,size-1,key);

            if(result)
                return result;

        }

        return false;

    }

    private static boolean binarySearch(int arr[], int start, int end, int key){

        while(start<=end){

            int mid= start+(end-start)/2;

            if(arr[mid]==key)
                return true;

            if(arr[mid]>key)
                return binarySearch(arr,start,mid-1,key);
            else
                return binarySearch(arr,mid+1,end,key);

        }
        return false;
    }

//O(n*logn)
    static boolean findPair_nLogn(int arr[], int size, int n)
    {
        Arrays.sort(arr);
        int i = 0;
        int j = 1;

        while (i<size && j<size)
        {
            if (i != j && arr[j]-arr[i] == n)
            {
                return true;
            }
            else if (arr[j]-arr[i] < n)
                j++;
            else
                i++;
        }

        return false;
    }

}
