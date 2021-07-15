import java.util.ArrayList;

public interface HashTable {

	void put(String elem);

	ArrayList<String> get(int index);

	ArrayList<String> getPermutations(String elem);
	
	int indexOf(String elem);
	
	ArrayList<String> lookUp(String elem);

}
