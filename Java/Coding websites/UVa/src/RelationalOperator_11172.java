import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RelationalOperator_11172 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int t = Integer.parseInt(in.readLine());
		
		while(t-- > 0){
			StringTokenizer s = new StringTokenizer(in.readLine());
			
			int a = Integer.parseInt(s.nextToken());
			int b = Integer.parseInt(s.nextToken());
			
			if(a > b)
				out.println(">");
			else if(a < b)
				out.println("<");
			else
				out.println("=");
		}
		
		out.flush();
		out.close();
	}
}
