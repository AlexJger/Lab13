import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scrabble {
	public static List<String> readFile(String path) throws FileNotFoundException {
    	List<String> array = new ArrayList<String>();
    	File file = new File(path);
    	Scanner sc = new Scanner(file);
    	while (sc.hasNextLine()) {
             String str = sc.nextLine();
             array.add(str);
        }
    	sc.close();
    	return array;
    }
	
}
