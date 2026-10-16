import java.util.Scanner;
public class MargeSort {
    public static void merge(int []arr,int low, int mid, int high){
        int i=low;
        int j=mid+1;
        int k = 0;

        int []temp = new int[high-low+1];

        while(i<= mid || j<=high){
            if(i>mid){
                temp[k]=arr[j];
                j++;
            }
            else if(j>high){
                temp[k]=arr[i];
                i++;
            }
            else if(arr[i]<=arr[j]){
                temp[k]=arr[i];
                i++;
            }
            else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }

        for(i=low,k=0; i<=high;i++,k++){
            arr[i]=temp[k];
        }
    }

    public static void mergesort(int []arr, int low, int high){
        int mid = (low+high)/2;

        if(low<high){
            mergesort(arr, low, mid);
            mergesort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array size: ");
        int n = sc.nextInt();
        int []arr = new int[n];

        System.out.print("Enter elements of array: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        long startTime = System.nanoTime();

        mergesort(arr,0, n-1);

        long finishTime = System.nanoTime();

        long executionTime = finishTime - startTime;

        System.out.print("The sorted array is: ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }

        System.out.println("The time required to execute the program is: "+executionTime+" nanoseconds");
        System.out.println("The time complexity of the code is: O(n log n)");

        sc.close();
    }
}
