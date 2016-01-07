import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LuckyString {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int n = Integer.parseInt(in.readLine());
		
		char[] arr = {'a', 'b', 'c', 'd'};
		
		int j = 0;
		
		for (int i = 0; i < n; i++) {
			if(j == 4)
				j = 0;
			
			out.print(arr[j++]);
		}
		
		out.flush();
		out.close();
	}
}
