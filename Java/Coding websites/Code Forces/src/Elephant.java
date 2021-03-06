import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Elephant {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int x = Integer.parseInt(in.readLine());
		
		int c = x / 5;
		if(x % 5 != 0) c++;
		
		out.println(c);
		
		out.flush();
		out.close();
	}
}
