import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ToCarryOrNotToCarry_10469 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(in.ready()){
			StringTokenizer s = new StringTokenizer(in.readLine());
			
			int x = Integer.parseInt(s.nextToken());
			int y = Integer.parseInt(s.nextToken());
			
			int res = x ^ y;
			
			out.println(res);
		}
		
		out.flush();
		out.close();
	}
}
