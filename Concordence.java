import java.io.*;
import java.util.*;
// this program is case sensitive
public class Concordence {
    public static void main(String args[]){
        File file = new File(args[0]);
        HashMap<String, Set<Integer>> hm = new HashMap<>();
        String text ="";
        try{
            Scanner FileReader = new Scanner(file);
            while(FileReader.hasNextLine()){
                String line = FileReader.nextLine();
                text = text+" "+line;
                text = text.trim();
            }
            String words[] = text.split("\\s+");
            for(int i=0; i<words.length; i++){ // i = index of word in file
                String s = words[i];
                if(!hm.containsKey(s))
                    hm.put(s, new HashSet<Integer>());
                Set<Integer> pages = hm.get(s);
                pages.add(i);
            }
            // starting index of the next line
            FileReader.close();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter words to be searched: ");
            while(sc.hasNext()){
                String query = sc.next();
                Set<Integer> set = hm.get(query);
                System.out.println(set);
                if(set==null)
                    System.out.println("Word doesn't exist in the file");
                else {
                    for(int k:set){
                        System.out.print(words[k]+" ");
                        /*for(int i=3; i>=0; i--){
                            if(k-i>=0)
                                System.out.print(words[k-i]+" ");
                        }
                        for(int i=1; k+i<words.length && i<4;i++)
                            System.out.print(words[k+i]+" ");
                    */}
                }
            }
            sc.close();
        } catch (FileNotFoundException e){
            System.out.println(e);
            System.out.println("File not found!");
        }
    }   
}