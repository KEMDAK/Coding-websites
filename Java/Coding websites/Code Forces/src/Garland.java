import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Garland {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String a = in.readLine();
		String b = in.readLine();
		
		int[] occA = new int[26];
		for (int i = 0; i < a.length(); i++)
			occA[a.charAt(i) - 'a']++;
		
		int[] occB = new int[26];
		for (int i = 0; i < b.length(); i++)
			occB[b.charAt(i) - 'a']++;
		
		int c = 0;
		
		for (int i = 0; i < 26; i++) {
			if(occA[i] == 0 && occB[i] != 0){
				System.out.println(-1);
				return;
			}
			
			c += Math.min(occA[i], occB[i]);
		}
		
		System.out.println(c);
	}
}
