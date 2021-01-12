// In a file containing CSV find a value based on a given key.
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
// java LookupCSV.java "filename.txt" keyIndex ValIndex
public class LookupCSV {
    public static void main(String args[]){
        HashMap<String, String> hm = new HashMap<>();
        try{
            File myObj = new File(args[0]); // File name
            Scanner myReader = new Scanner(myObj);
            int keyField = Integer.parseInt(args[1]); // index of key in CSV
            int valField = Integer.parseInt(args[2]); // index of value in CSV
            while(myReader.hasNextLine()){
                String line = myReader.nextLine();
                String tokens[] = line.split(",");
                String key = tokens[keyField];
                String val = tokens[valField];
                hm.put(key, val);
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("File not found!");
        }
        // Check if given keys are present in the dictionary
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the keys to look up");
        while(sc.hasNext()){ // use ctrl+D to mark the end of input
            String s = sc.next();
            if(!hm.containsKey(s))
                System.out.println("Key not found");
            else
                System.out.println(hm.get(s));
        }
        sc.close();
    }
}