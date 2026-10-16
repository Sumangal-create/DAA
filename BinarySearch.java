import java.lang.reflect.Field;
import java.util.Scanner;

import javax.print.attribute.standard.Finishings;

public class BinarySearch{
    public static int Binary(int[] arr, int n, int key){
        int low=0;
        int high = n-1;

        while(low<=high){
            int mid = (low+high)/2;

            if(arr[mid]==key){
                return mid;
            } else if(arr[mid]<key){
                low=mid+1;
            } else{
                high = mid-1;
            }
        }
        return -1;
    }

    public static void sort(int []arr, int n){
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int [] arr = new int[n];

        System.out.print("Enter the array: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        long InitialTime = System.nanoTime();

        sort(arr, n);

        System.out.print("Enter the element to search: ");
        int key = sc.nextInt();

        int result = Binary(arr,n,key);

        if(result==-1){
            System.out.print("Element not found!");
        } else{
            System.out.println("Element found at index "+result);
        }
        long finishTime = System.nanoTime();

        long executionTime = finishTime - InitialTime;
        System.out.println("The Time taken for Binary Search is: "+executionTime+" nanoseconds!");
        sc.close();
    }
}