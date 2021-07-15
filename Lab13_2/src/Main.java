import java.io.FileNotFoundException;
import java.util.List;

public class Main {
	public static void main(String args[]) throws FileNotFoundException {
		List<String> words = Scrabble.readFile("src\\7-Letter.txt");
		Dictionary dic = new Dictionary(words.size());
		for(String word : words) {
			dic.put(word);
		}
		
		System.out.println(dic.lookUp("adeelrt"));
		System.out.println(dic.getPermutations("adeelrt"));
		System.out.println(dic.longestChain());
		System.out.println(dic.longestChain().size());
	}
}
