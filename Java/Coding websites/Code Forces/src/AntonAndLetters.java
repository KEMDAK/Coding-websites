import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class AntonAndLetters {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String input = in.readLine();
		
		HashSet<Character> set = new HashSet<>();
		
		int count = 0;
		
		for (int i = 0; i < input.length(); i++) {
			if(Character.isAlphabetic(input.charAt(i))){
				if(!set.contains(input.charAt(i))){
					count++;
					set.add(input.charAt(i));
				}
			}
		}
		
		System.out.println(count);
	}
}
