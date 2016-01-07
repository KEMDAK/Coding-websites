import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DreamoonAndWiFi {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String s = in.readLine();
		String r = in.readLine();
		
		int numS = 0;
		int numD = 0;
		int q = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '+')
				numS++;
			else
				numS--;
			
			if(r.charAt(i) == '+')
				numD++;
			else if(r.charAt(i) == '-')
				numD--;
			else
				q++;
		}
		
		int total = (int) Math.pow(2, q);
		
		int mask = 0;
		int correct = 0;
		for (int i = 0; i < total; i++) {
			int current = 0;
			for (int j = 0; j < q; j++) {
				if((mask & 1 << j) != 0)
					current++;
				else
					current--;
			}
			
			if(numD + current == numS)
				correct++;
			
			mask++;
		}
		
		System.out.println((correct * 1.0) / total);
	}
}
