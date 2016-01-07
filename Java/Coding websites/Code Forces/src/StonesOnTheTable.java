import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StonesOnTheTable {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		in.readLine();
		
		String s = in.readLine();
		
		int count = 0;
		
		for (int i = 0; i < s.length() - 1; i++) {
			if(s.charAt(i) == s.charAt(i + 1))
				count++;
		}
		
		System.out.println(count);
	}
}
