/* for index i, swap each element to its left that is greater than a[i] */

import java.util.Scanner;

public class InsertionSort {

    public static void sort(int[] a){
        for(int i=1; i<a.length; i++){
            for(int j=i; j>0; j--){
                if(a[j] < a[j-1])
                    exch(a, j, j-1);
                else
                    break;
            }
        }
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