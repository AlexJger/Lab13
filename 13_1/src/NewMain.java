import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewMain {
	public static void main(String args[]) {
//		System.out.println("normalize sdgexfETR to "+normalize("sdgexfETR"));
//		System.out.println("normalize sdgexfETR to "+normalize2("sdgexfETR"));
		Hashtable<String, List<String>> hashTable = initializeHT();
		
		printHT(hashTable);
		printStatistic(hashTable);
		printLongestChain(hashTable);
		String in = "adeelrt";
		List<String> wordIn = hashTable.get(normalize(in));
		System.out.println("Index: "+normalize(in)+" | words: "+wordIn.toString());
		printInput(in,hashTable);
		printInput("zzzzzzz",hashTable);
		//System.out.println("rand string: "+randomString());
//		randomInputs(10, hashTable);
//		getGoodRandIn(10, hashTable, 3);
	}
	
	public static Hashtable<String, List<String>> initializeHT(){
		Hashtable<String, List<String>> hashTable = new Hashtable<>();
		List<String> words = new ArrayList<>();
		try {
			words = get7LetterWords();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(String word : words) {
			if(hashTable.containsKey(normalize(word)))
            {
				if(!hashTable.get(normalize(word)).contains(word)) hashTable.get(normalize(word)).add(word);
            } else {
            	hashTable.put(normalize(word),new LinkedList<>());
            	hashTable.get(normalize(word)).add(word);
            }
		}
		return hashTable;
	}
	
	public static String normalize(String in) {
		String out = in.toUpperCase();
		out = Stream.of(out.split("")).sorted().collect(Collectors.joining());
		return out;
	}
	
	//Alternative
	public static String normalize2(String in) {
		char[] chars = in.toUpperCase().toCharArray();
		Arrays.sort(chars);
		String out = new String(chars);
		return out;
	}
	
	public static List<String> get7LetterWords() throws FileNotFoundException {
    	List<String> array = new ArrayList<String>();
    	File file = new File("C:\\Users\\alexj\\Desktop\\HTW\\#2 Module_sem2\\Info2\\Labs\\Lab13\\Words\\Words by LetterLenght\\7-Letter.txt");
    	Scanner sc = new Scanner(file);
    	while (sc.hasNextLine()) {
             String str = sc.nextLine();
             array.add(str);
        }
    	sc.close();
    	return array;
    }
	
	public static void printHT(Hashtable<String, List<String>> hT) {
		int counter=0;
		for(String s : hT.keySet()) {
			System.out.println("Index ["+counter+"]: "+s+" | ["+hT.get(s).size()+"] words: "+hT.get(s).toString());
				counter++;
		}
		//System.out.println("Counter: "+counter);
		printStatistic(hT);
	}
	
	public static void printLongestChain(Hashtable<String, List<String>> hT) {
		String lChain = "";
		for(String s : hT.keySet()) {
			if(lChain=="") lChain=s;
			if(hT.get(lChain).size()<hT.get(s).size()) lChain=s;
			}
		System.out.println("Longest Chain ["+hT.get(lChain).size()+"]: "+lChain+" | "+hT.get(lChain).toString());
	}
	
	public static void printStatistic(Hashtable<String, List<String>> hT) {
		int cIndex=0;
		int cWords=0;
		long start = System.currentTimeMillis();
		initializeHT();
		long end = System.currentTimeMillis();
		for(String s : hT.keySet()) {
			cIndex++;
			for(String word : hT.get(s)) {
				cWords++;
			}
		}
		
		System.out.println("Start: "+start+" end: "+end+" diff: "+(end-start));
		System.out.println("##### Statistic: [#keys: "+cIndex+", #words: "+cWords+", Total elements: "+(cIndex+cWords)+", elapsed time: "+(end-start)+" ms] #####");
	}
	
	public static void printInput(String in, Hashtable<String, List<String>> hT) {
		if(hT.containsKey(normalize(in))) System.out.println("Input: "+in+" | Index : "+normalize(in)+" | ["+hT.get(normalize(in)).size()+"] words: "+hT.get(normalize(in)).toString());
		else System.out.println("Input: "+in+ " could not be found in the Hashtable");
	}
	
	
	
//	public static String randomString() {
//	    //https://www.programiz.com/java-programming/examples/generate-random-string
//		// create a string of all characters
//	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//	    // create random string builder
//	    StringBuilder sb = new StringBuilder();
//	    // create an object of Random class
//	    Random random = new Random();
//	    // specify length of random string
//	    int length = 7;
//	    for(int i = 0; i < length; i++) {
//	      // generate random index number
//	      int index = random.nextInt(alphabet.length());
//	      // get character specified by index
//	      // from the string
//	      char randomChar = alphabet.charAt(index);
//	      // append the character to string builder
//	      sb.append(randomChar);
//	      }
//	    return sb.toString();
//}
//	    
//	    public static void randomInputs(int nrOfExe, Hashtable<String, List<String>> hT) {
//	    	System.out.println("##### Random Inputs ["+nrOfExe+"] #####");
//	    	while(nrOfExe!=0) {
//	    		String randStr = randomString();
//	    		if(hT.containsKey(normalize(randStr))) {
//	    			printInput(randStr, hT);
//	    			nrOfExe--;
//	    		}
//	    	}
//	    }
//	    
//	    public static void getGoodRandIn(int nrOfExe, Hashtable<String, List<String>> hT, int nrWords) {
//	    	System.out.println("##### Good Random Inputs ["+nrOfExe+"] with at least ["+nrWords+"] Words for each #####");
//	    	while(nrOfExe!=0) {
//	    		String randStr = randomString();
//	    		if(hT.containsKey(normalize(randStr)) && hT.get(normalize(randStr)).size()>=nrWords) {
//	    			printInput(randStr, hT);
//	    			nrOfExe--;
//	    		}
//	    	}
//	    }
//	    

	
//	public static void printLongestChain2(Hashtable<String, List<String>> hT) {
//	int top=0;
//	String lChain = "";
//	for(String s : hT.keySet()) {
//		int count=hT.get(s).size();
//		if(top<count) {
//			top=count;
//			lChain=s;
//			}
//		}
//	System.out.println("Longest Chain2 ["+top+"]: "+lChain+" | "+hT.get(lChain).toString());
//}

}
