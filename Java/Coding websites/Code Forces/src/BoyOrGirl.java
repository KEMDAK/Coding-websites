import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class BoyOrGirl {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String s = in.readLine();
		
		HashSet<Character> set = new HashSet<Character>();
		
		int count = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if(!set.contains(s.charAt(i))){
				set.add(s.charAt(i));
				count++;
			}
		}
		
		System.out.println((count % 2 == 0) ? "CHAT WITH HER!" : "IGNORE HIM!");
	}
}
