import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MusicalLoop_11496 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(true){
			int n = Integer.parseInt(in.readLine());
			
			if(n == 0)
				break;
			
			StringTokenizer s = new StringTokenizer(in.readLine());
			int[] m = new int[n];
			for (int i = 0; i < n; i++) {
				m[i] = Integer.parseInt(s.nextToken());
			}
			
			int c = 0;
			
			if((m[0] < m[n - 1] && m[0] < m[1]) || (m[0] > m[n - 1] && m[0] > m[1]))
				c++;
			if((m[n - 1] < m[n - 2] && m[n - 1] < m[0]) || (m[n - 1] > m[n - 2] && m[n - 1] > m[0]))
				c++;
			
			for (int i = 1; i < m.length - 1; i++)
				if((m[i] < m[i - 1] && m[i] < m[i + 1]) || (m[i] > m[i - 1] && m[i] > m[i + 1]))
					c++;
			
			out.println(c);
		}
		
		out.flush();
		out.close();
	}
}
