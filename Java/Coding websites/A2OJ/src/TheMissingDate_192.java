import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class TheMissingDate_192 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());

		while(T-- > 0){
			StringTokenizer s = new StringTokenizer(in.readLine());

			int y1 = Integer.parseInt(s.nextToken());
			int m1 = Integer.parseInt(s.nextToken());

			s = new StringTokenizer(in.readLine());

			int y2 = Integer.parseInt(s.nextToken());
			int m2 = Integer.parseInt(s.nextToken());
			
			int y3 = y1 + y2 + ((m1 + m2) / 12);
			int m3 = ((m1 + m2) % 12);
			
			if(m3 == 0){
				m3 = 12;
				y3--;
			}
			
			out.println(y3 + " " + m3);
		}
		
		out.flush();
		out.close();
	}
}
