import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class HQ9Plus {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String s = in.readLine();
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'Q' || s.charAt(i) == '9' || s.charAt(i) == 'H'){
				System.out.println("YES");
				return;
			}
		}
		
		System.out.println("NO");
	}
}
