import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CaseoftheZerosandOnes {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in.readLine();
		String s = in.readLine();
		
		int zeros = 0, ones = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '1')
				ones++;
			else
				zeros++;
		}

		System.out.println(Math.abs(ones - zeros));
	}
}
