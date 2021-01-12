// Djriksta's 3-way partitioning Quick sort
import java.util.Scanner;
import java.util.Random;
public class DutchFlagProblem {

    private static void sort(int[] a, int lo, int hi){
        if(hi <= lo)
            return;
        int lt = lo, gt = hi; // boundary indices of identical elements
        int v = a[lo];
        int i = lo;
        while(i <= gt){
            if(a[i] < v)
                exch(a, lt++, i++);
            else if(a[i] > v)
                exch(a, i++, gt--);
            else 
                i++;
        }
        sort(a, lo, lt-1); // left half
        sort(a, gt+1, hi); // right half
    }

    public static void sort(int[] a){
        shuffle(a);
        sort(a, 0, a.length-1);
    }

    public static void shuffle(int[] a){
        Random random = new Random(System.currentTimeMillis());
        for(int i=0; i<a.length; i++){
            int r = random.nextInt(a.length);
            exch(a, i, r);
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