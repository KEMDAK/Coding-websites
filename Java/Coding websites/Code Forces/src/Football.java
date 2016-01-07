import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Football {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		
		String s = in.readLine();
		
		int count = 1;
		
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i) == s.charAt(i - 1))
				count++;
			else
				count = 1;
			
			if(count == 7){
				System.out.println("YES");
				return;
			}
		}
		
		System.out.println("NO");
	}
}
