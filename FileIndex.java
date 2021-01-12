// Find all files from a list of files that contain a given query string (Using CSV here)
import java.io.File;
import java.util.*;
public class FileIndex {
    public static void main(String args[]){
        HashMap<String, Set<File>> hm = new HashMap<>();
        for(String filename: args){
            System.out.println("file: "+filename);
            File file = new File(filename);
            try{
                Scanner myReader = new Scanner(file);
                while(myReader.hasNextLine()){
                    String line = myReader.nextLine(); // Read lines
                    Scanner lineReader = new Scanner(line).useDelimiter(",");
                    while(lineReader.hasNext()){
                        String key = lineReader.next(); // Break lines using "," as delimeter
                        if(!hm.containsKey(key))
                            hm.put(key, new HashSet<File>());
                        Set<File> set = hm.get(key);
                        set.add(file);
                    }
                    lineReader.close();
                }
                myReader.close();
            } catch (Exception e){
                System.out.println("File not found!: "+filename);
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the query strings: ");
        while(sc.hasNext()){
            String query = sc.next();
            System.out.println(hm.get(query));
        }
        sc.close();
    }
}