import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

class BST{
    private Node root;
    private class Node{
        private int key;
        private int value;
        private int count;
        private Node left;
        private Node right;
        private Node(int key, int value){
            this.key = key;
            this.value = value;
        }

    }

    public int size(){ // size of the BST
        return size(root);
    }

    public int size(Node x){
        if(x==null)
            return 0;
        return x.count;
    }

    public void put(int key, int value){
        root = put(root, key, value);
    }

    private Node put(Node x, int key, int value){
        if(x==null)
            return new Node(key, value);
        if(key<x.key)
            x.left = put(x.left, key, value);
        else if(key>x.key)
            x.right = put(x.right, key, value);
        else
            x.value = value; // if key exists, reset value (BST cannot have duplicate keys)
        x.count = +size(x.left)+size(x.right);
        return x;
    }

    public Integer get(int key){
        Node x = root;
        while(x!=null){
            if(key<x.key)
                x = x.left;
            else if(key>x.key)
                x = x.right;
            else
                return x.value; // If value is found convert to int
        }
        return null; // if returned value is null return NOT FOUND
    }

    public int rank(int key){
        return rank(root, key);
    }
    public int rank(Node x, int key){
        if(x==null)
            return 0;
        if(key<x.key)
            return rank(x.left, key);
        if(key>x.key)
            return 1+size(x.left)+rank(x.right, key);
        else
            return size(x.left);
    }

    public Iterable<Integer> keys(){
        Queue<Integer> q = new LinkedList<>();
        inorder(root, q);
        return q;
    }

    public void inorder(Node x, Queue<Integer> q){
        if(x==null)
            return;
        inorder(x.left, q);
        q.add(x.key);
        inorder(x.right, q);
    }

    public void delete(int key){
        root = delete(root, key);
    }

    public Node min(Node x){
        if(x.left == null)
            return x;
        return min(x.left);
    }

    private Node delete(Node x, int key){
        if(x == null) return null;
        if(key<x.key)
            x.left = delete(x.left, key);
        else if(key>x.key)
            x.right = delete(x.right, key);
        else {
            if(x.right == null)
                return x.left;
            if(x.left == null)
                return x.right;
            // replace with successor
            Node temp = x;
            x = min(temp.right);
            x.right = delete(temp, min(temp.right).key);
            x.left = temp.left;
        }
        x.count = size(x.left) + size(x.right) +1;
        return x;
    }

}

public class BSTtest{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("1.For insert\n2.For Delete\n3.For get\n4.For Display\n");
        System.out.println("Enter the number of queries:");
        int n = sc.nextInt();
        BST bst = new BST();
        for(int i=0; i<n; i++){
            int choice = sc.nextInt();
            if(choice == 1){
                System.out.println("Enter the key and value:");
                bst.put(sc.nextInt(), sc.nextInt());
            } else if(choice == 2){
                System.out.println("Enter the key to delete:");
                bst.delete(sc.nextInt());
            } else if(choice == 3){
                System.out.println("Enter the key to fetch:");
                System.out.println(bst.get(sc.nextInt()));
            } else {
                System.out.println("The BST now in in-order traversal:");
                for(int ele:bst.keys()){
                    System.out.println(ele);
                }
            }
        }
        sc.close();
    }
}