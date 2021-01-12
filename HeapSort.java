import java.util.Scanner;
public class HeapSort {

    public static int[] sort(MaxPQ pq, int n, int[] ar){
        /* use delMax to get the maximum element and put it at the end of the array. 
         need to create a class for in-place sort which doesn't make the end value null
         everytime decrease n so that the next max deleted will be placed at n-i
         thus each maxelement will keep getting added to the end of the pq and it will become
         min ... third max, second max, first max */
        for(int i=0; i<n; i++){
            ar[n-1-i]=pq.delMax();
        }
        return ar;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n);
        int ar[] = new int[n];
        MaxPQ pq = new MaxPQ();
        for(int i=0; i<n; i++){
            pq.insert(sc.nextInt());
        }
        ar = sort(pq, n, ar);
        for(int i: ar)
            System.out.print(i+" ");
        sc.close();
    }
}