import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pangram {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		String s = in.readLine();
		
		boolean[] alpha = new boolean[26];
		
		if(n < 26)
			System.out.println("NO");
		else{
			for (int i = 0; i < s.length(); i++) {
				if(Character.isUpperCase(s.charAt(i)))
					alpha[s.charAt(i) - 'A'] = true;
				else
					alpha[s.charAt(i) - 'a'] = true;
			}
			
			for (int i = 0; i < alpha.length; i++) {
				if(!alpha[i]){
					System.out.println("NO");
					return;
				}
			}
			
			System.out.println("YES");
		}
	}
}
