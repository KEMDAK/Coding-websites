import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(s.nextToken());
		int x1 = Integer.parseInt(s.nextToken());
		int y1 = Integer.parseInt(s.nextToken());
		int x2 = Integer.parseInt(s.nextToken());
		int y2 = Integer.parseInt(s.nextToken());

		int r1 = 0;
		int r2 = 0;
		
		
		
		out.flush();
		out.close();
	}
	
	public static long ceil(double x){
		if(x - (int) x == x)
			return (int) x;
		return (int) x + 1;
	}
}
