import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HammingDistanceSum {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String input1 = in.readLine();
		String input2 = in.readLine();
		
//		char[] s2 = new char[input2.length()];
//		
//		for (int i = 0; i < s2.length; i++) {
//			s2[i] = input2.charAt(i);
//		}
		
		int size = input1.length();
		
		int total = 0;
		
		for (int i = 0; i < input2.length() - size + 1; i++) {
			int current = 0;
			
			for (int j = i; j < i + size; j++) {
				if(input1.charAt(j - i) != input2.charAt(j))
					current++;
				
				System.out.print(input2.charAt(j));
			}
			
			System.out.println(" : " + current);
			
			total += current;
		}
		
		System.out.println(total);
	}
}
