import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Dictionary implements HashTable {
	ArrayList<String>[] buffer;
	
	@SuppressWarnings("unchecked")
	public Dictionary(int size) {
		buffer = new ArrayList[size];
	}
	
	
	@Override
	public void put(String elem) {
		if(elem == null) return;
		if(buffer[indexOf(elem)] == null) {
			buffer[indexOf(elem)] = new ArrayList<String>();
		}
		buffer[indexOf(elem)].add(elem);
	}
	
	
	@Override
	public ArrayList<String> get(int index){
		return buffer[index];
	}
	
	
	@Override
	public ArrayList<String> getPermutations(String elem){
		 ArrayList<String> sorted = lookUp(elem);
		 Collections.sort(sorted);
		 for (int i = 0; i < sorted.size(); i++) {
			 if(!isPermutation(sorted.get(i) , elem)) sorted.remove(i);
		}
		 return sorted;
	}
	
	@Override
	public int indexOf(String elem) {
		return Math.abs(hash(normalize(elem))%buffer.length);
	}
	
	private int hash(String normalize) {
		return normalize.hashCode();
	}
	
	@Override
	public ArrayList<String> lookUp(String elem){
		return get(indexOf(elem));
	}

	public ArrayList<String> longestChain(){
		 ArrayList<String> longest = new ArrayList<>();
		 for( ArrayList<String> check : buffer) {
			 if(check != null && check.size()>longest.size()) {
				 longest = check;
			 }
		 }
		 Collections.sort(longest);
		 return longest;
	}
	
	public static String normalize(String in) {
		char[] chars = in.toUpperCase().toCharArray();
		Arrays.sort(chars);
		String out = new String(chars);
		return out;
	}
	
	public boolean isPermutation(String one, String two) {
	return normalize(one).equals(normalize(two));
	}
	
	
	
	
}
