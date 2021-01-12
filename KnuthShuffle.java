// The generation of random numbers is too important to be left to chance - Robert R Coveyon
import java.util.Scanner;
import java.util.Random;
public class KnuthShuffle {
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
        shuffle(a);
        printArray(a);
        sc.close();
    }
}