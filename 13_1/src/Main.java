import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static List<String> permutation = new ArrayList<>();
	public static void main(String args[]) throws FileNotFoundException {
		String[] str = new String[1000];
		normalized(str);
		System.out.println(Arrays.toString(str));
		List<String> norm = normalize7Letter();
		
		Hashtable<String, List<String>> ht1 = new Hashtable<>();
		
		for(String s : norm) {
			ht1.put(s, new LinkedList<>());
		}
		String in = "ABCDEF";
		Set<String> perm = getPermutn(in, "");
		//System.out.println("Perm: "+perm.toString());
		System.out.println("Perm: "+perm.toString());
		Set<String> perm2 = permutationFinder(in);
		System.out.println("Perm2: "+perm2.toString());
		List<String> seven = get7LetterWords();
		//System.out.println("7-Letter: "+seven.toString());
		//for(String s : seven)System.out.println(s);
//		Set<String> keys = ht1.keySet();
//		for(String normS : keys) {
//			generatePermutation(normS, 0, normS.length());
//			List<String> permSet = permutation;
//			for(String per : permSet) {
//				//System.out.println("per= "+per);
//				for(String word : seven) {
//					if(per.equals(word)) {
//						//ht1.put(normS, add(word));
//						//System.out.println(word);
//						ht1.get(normS).add(word);
//					}
//				}
//			}
//		}
//		System.out.println("HashTable: "+ht1.toString());
//		System.out.println("HashTable2: "+ht1.get("ADEELRT"));
		String in2 = "ABCDEFG";
		Set<String> permutations = getPermutation(in2);
		System.out.println(permutations.toString());
		generatePermutation(in2, 0, in2.length());
		//System.out.println("permutations: "+permutation.get(3));
		//for(int i=0; i<=100; i++)System.out.println(i+" perm: "+permutation.get(i));
		//List<String>permu=generatePermutation(in2, 0, in2.length());
		//System.out.println("PermUU: "+permu.toString());
		//Hashtable<String, List<String>> ht2 = new Hashtable<>();
		//for(String s : norm)
		System.out.println();
	}
	
	public static String[] normalized(String[] array) {
		int counter=0;
		for(char i='A'; i<='Z'; i++) {
			for(char j=i; j<='Z'; j++) {
				String str = String.valueOf(i)+String.valueOf(j);
				System.out.println(str + " "+ counter);
				array[counter]=str;
				counter++;
			}
		}
		
		return array;
	}
	
	public static List<String> normalize7Letter() {
		String[] output = null;
		List<String> out = new ArrayList<>();
		int counter=0;
		for(char i='A'; i<='Z'; i++) {
			for(char j=i; j<='Z'; j++) {
				for(char k=j; k<='Z'; k++) {
					for(char l=k; l<='Z'; l++) {
						for(char m=l; m<='Z'; m++) {
							for(char n=m; n<='Z'; n++) {
								for(char o=n; o<='Z'; o++) {
									String str = String.valueOf(i)+String.valueOf(j)+String.valueOf(k)+String.valueOf(l)+String.valueOf(m)+String.valueOf(n)+String.valueOf(o);
									//output[counter]=str;
									out.add(str);
									counter++;
								}
							}
						}
					}
				}
			}
		}
		//printList(out);
		System.out.println(counter);
		return out;
	}
	
	static void printList(List<String> in) {
		for(String s : in) {
			System.out.println(s);
		}
	}
	
	
	   // Function to print all the permutations of str
    static Set<String> getPermutn(String str, String ans)
    {
    	Set<String> perm = new HashSet<String>();
        // If string is empty
        if (str.length() == 0) {
            //System.out.print(ans + " ");
            perm.add(ans);
            return perm;
        }
  
        for (int i = 0; i < str.length(); i++) {
  
            // ith character of str
            char ch = str.charAt(i);
  
            // Rest of the string after excluding 
            // the ith character
            String ros = str.substring(0, i) + 
                         str.substring(i + 1);
  
            // Recurvise call
            getPermutn(ros, ans + ch);
        }
        return perm;
    }
    
    
        public static Set<String> permutationFinder(String str) {
            Set<String> perm = new HashSet<String>();
            //Handling error scenarios
            if (str == null) {
                return null;
            } else if (str.length() == 0) {
                perm.add("");
                return perm;
            }
            char initial = str.charAt(0); // first character
            String rem = str.substring(1); // Full string without first character
            Set<String> words = permutationFinder(rem);
            for (String strNew : words) {
                for (int i = 0;i<=strNew.length();i++){
                    perm.add(charInsert(strNew, initial, i));
                }
            }
            return perm;
        }

        public static String charInsert(String str, char c, int j) {
            String begin = str.substring(0, j);
            String end = str.substring(j);
            return begin + c + end;
        }
    
        public static List<String> get7LetterWords() throws FileNotFoundException {
        	List<String> array = new ArrayList<String>();
        	File file = new File("C:\\Users\\alexj\\Desktop\\HTW\\#2 Module_sem2\\Info2\\Labs\\Lab13\\Words\\Words by LetterLenght\\7-Letter.txt");
        	Scanner sc = new Scanner(file);
        	//int counter=0;
        	while (sc.hasNextLine()) {
                 String str = sc.nextLine();
                 //System.out.println(str);
                 array.add(str);
                 //System.out.println(str);
            }
        	sc.close();
        	//System.out.println("7-Letter: "+array);
        	//for(String s: array)System.out.println(s);
        	return array;
        }
        
        
        public static Set<String> getPermutation(String str) {

            // create a set to avoid duplicate permutation
            Set<String> permutations = new HashSet<String>();

            // check if string is null
            if (str == null) {
              return null;
            } else if (str.length() == 0) {
              // terminating condition for recursion
              permutations.add("");
              return permutations;
            }

            // get the first character
            char first = str.charAt(0);

            // get the remaining substring
            String sub = str.substring(1);

            // make recursive call to getPermutation()
            Set<String> words = getPermutation(sub);

            // access each element from words
            for (String strNew : words) {
              for (int i = 0;i<=strNew.length();i++){

                // insert the permutation to the set
                permutations.add(strNew.substring(0, i) + first + strNew.substring(i));
              }
            }
            return permutations;
          }
        
        
      //Function for generating different permutations of the string  
        public static void generatePermutation(String str, int start, int end)  
        {  
            //List<String> perm = new ArrayList<>();
        	//Prints the permutations  
            if (start == end-1)  
                //System.out.println(str);
            	{
            	//perm.add(str);
            	permutation.add(str);
            	
            	}else  
            {  
                for (int i = start; i < end; i++)  
                {  
                    //Swapping the string by fixing a character  
                    str = swapString(str,start,i);  
                    //Recursively calling function generatePermutation() for rest of the characters   
                    generatePermutation(str,start+1,end);  
                    //Backtracking and swapping the characters again.  
                    str = swapString(str,start,i);  
                }  
            }
            //System.out.println("PermMM: "+perm.toString());
            //return perm;
        }
        
        
      //Function for swapping the characters at position I with character at position j  
        public static String swapString(String a, int i, int j) {  
            char[] b =a.toCharArray();  
            char ch;  
            ch = b[i];  
            b[i] = b[j];  
            b[j] = ch;  
            return String.valueOf(b);  
        }  
        
}
