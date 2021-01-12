/* For index i, select minimum from the remaining array and swap with a[i]
thus everything before a[i] will be sorted with a[0] being minimum, a[1] being
second minimum and so on */

import java.util.Scanner;

class SelectionSort {
    public static void sort(int a[]){
        for(int i = 0; i < a.length; i++){
            int min = i;
            for(int j = i+1; j < a.length; j++){
                if(a[j] < a[min])
                    min = j;
            }
            exch(a, i, min);
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