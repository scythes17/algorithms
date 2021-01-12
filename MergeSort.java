/* Merges two sorted subarrays by comparing each element and storing the smaller in
the merged array */
import java.util.Scanner;
public class MergeSort {

    private static void merge(int a[], int aux[], int lo, int mid, int hi){
        for(int k=lo; k<=hi; k++){
            aux[k] = a[k];
        }
        int i = lo, j = mid+1;
        for(int k=lo; k<=hi; k++){
            if(i>mid) // if no more elements in first subarray
                a[k] = aux[j++];
            else if(j>hi) // if no more elements in second subarray
                a[k] = aux[i++];
            else if(aux[j]<aux[i]) // put smaller element from the two arrays in position
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

    private static void sort(int a[], int aux[], int lo, int hi){
        if(hi <= lo)
            return;
        int mid = lo + (hi-lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        if(a[mid]<a[mid+1])
            return;
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(int a[]){
        int aux[] = new int[a.length];
        sort(a, aux, 0, a.length-1);
    }

    public static void exch(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void printArray(int[] a){
        for(int i: a)
            System.out.print(i+" ");
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        sort(a);
        printArray(a);
        sc.close();
    }
}