import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PaintingEggs {

	static int diff;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int n = Integer.parseInt(in.readLine());

		diff = 0;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer s = new StringTokenizer(in.readLine());
			
			int a = Integer.parseInt(s.nextToken());
			int g = Integer.parseInt(s.nextToken());
			
			char safe = safer(a, g);
			
			if(safe == 'A'){
				out.print("A");
				diff += a;
			}
			else{
				out.print("G");
				diff -= g;
			}
		}
		
		if(Math.abs(diff) > 500){
			System.out.println(-1);
			return;
		}
		
		out.flush();
		out.close();
	}

	public static char safer(int a, int g) {
		int af = Math.abs(diff + a);
		int ag = Math.abs(diff - g);
		
		return (af <= ag)? 'A' : 'G';
	}
}
