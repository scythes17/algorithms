// max pq
import java.util.Scanner;
import java.util.ArrayList;
public class MaxPQ {
    private ArrayList<Integer> pq;
    private int n;

    MaxPQ(){ // first index "0" is extra and not used in the program so assigning null value
        pq = new ArrayList<>(1);
        pq.add(0, null);
        //pq.set
    }

    public boolean isEmpty(){
        return n==0;
    }

    public void insert(int value){
        pq.add(++n, value);
        swim(n); // value might be smaller than it's parents so sink
    }

    public int delMax(){
        int max = pq.get(1);
        exch(1, n);
        pq.set(n--, null);
        sink(1);
        return max;
    }

    public void swim(int k){
        while(k>1 && less(k/2, k)){ //while child is smaller than parent
            exch(k, k/2);
            k = k/2;
        }
    }

    public void sink(int k){
        while(2*k<=n){
            int j = 2*k;
            if(j<n && less(j, j+1)) j++; // gives which child is bigger
            if(!less(k, j)) break;
            exch(k,j);
            k=j;
        }
    }

    private int search(int value) {
        for(int i=1; i<=n; i++){
            if(pq.get(i)==value)
                return i;
        }
        return -1;
    }

    // when guaranteed that the value exists
    public int delete(int value){
        int index = search(value); // pq starts at 1, length of pq is n+1
        exch(index, n); // exchange value at index with last value
        pq.set(n--, null); // delete the exchanged value, avoid loitering.
        sink(index); // value at index is bigger now so sink it
        return value;
    }
    
    public void display() {
        for(Integer i: pq){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    private boolean less(int i, int j){
        return pq.get(i)<pq.get(j);
    }

    public void exch(int i, int j){
        int temp = pq.get(i);
        pq.set(i, pq.get(j));
        pq.set(j, temp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        MaxPQ pq = new MaxPQ(); // default heap index 0 = null
        for(int i=0; i<q; i++) {
            System.out.println("Heap right now is: ");
            pq.display();
            int option = sc.nextInt();
            if(option == 1){
                int ele = sc.nextInt();
                pq.insert(ele);
            } else if(option == 2) {
                int ele = sc.nextInt();
                pq.delete(ele);
            } else if(option == 3) {
                System.out.println(pq.delMax());
            } else {
                System.out.println("Wrong choice");
            }
        }
        sc.close();
    }
}