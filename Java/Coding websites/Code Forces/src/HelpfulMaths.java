import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class HelpfulMaths {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		String input = in.readLine();
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for (int i = 0; i < input.length(); i++) 
			if (input.charAt(i) != '+')
				numbers.add(input.charAt(i) - '0');
		
		Collections.sort(numbers);
		
		for (int i = 0; i < numbers.size() - 1; i++) {
			out.append(numbers.get(i) + "+");
		}
		
		out.append(numbers.get(numbers.size() - 1));
		
		System.out.print(out);
	}
}
