
/**
 * Write a description of storageresour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
//import java.io.File;
public class storageresour {
    public static void main(){  // static -- can be compiled directly
        StorageResource sr = new StorageResource();
        sr.add("Hello");
        sr.add("World");
        sr.add("This is my try for StorageResource Class!");
        for (String s : sr.data()){
            System.out.println(s);
        }
    }
}
