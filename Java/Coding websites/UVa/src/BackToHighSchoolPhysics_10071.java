import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BackToHighSchoolPhysics_10071 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(in.ready()){
			StringTokenizer s = new StringTokenizer(in.readLine());
			
			int v = Integer.parseInt(s.nextToken());
			int t = Integer.parseInt(s.nextToken());
			
			out.println(2 * v * t);
		}
		
		out.flush();
		out.close();
	}
}
