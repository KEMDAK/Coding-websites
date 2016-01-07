import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class WordCapitalization {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder s = new StringBuilder(in.readLine());
		
		s.replace(0, 1, Character.toUpperCase(s.charAt(0)) + "");
		
		System.out.println(s);
	}
}
