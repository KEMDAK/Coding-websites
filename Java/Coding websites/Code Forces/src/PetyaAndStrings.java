import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PetyaAndStrings {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String A = in.readLine().toLowerCase();
		String B = in.readLine().toLowerCase();
		
		for (int i = 0; i < A.length(); i++) {
			if(A.charAt(i) > B.charAt(i)){
				System.out.println(1);
				return;
			}
			else if(A.charAt(i) < B.charAt(i)){
				System.out.println(-1);
				return;
			}
				
		}
		
		System.out.println(0);
	}
}
