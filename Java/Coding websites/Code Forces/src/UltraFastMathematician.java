import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class UltraFastMathematician {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		String n1 = in.readLine();
		String n2 = in.readLine();
		
		for (int i = 0; i < n1.length(); i++) {
			if(n1.charAt(i) != n2.charAt(i))
				out.print(1);
			else
				out.print(0);
		}
		
		out.flush();
		out.close();
	}
}
