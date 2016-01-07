import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class PashmakAndGarden {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		int x1 = Integer.parseInt(s.nextToken());
		int y1 = Integer.parseInt(s.nextToken());
		int x2 = Integer.parseInt(s.nextToken());
		int y2 = Integer.parseInt(s.nextToken());
		
//		System.out.println(((y2 - y1) / ((x2 - x1) * 1.0)));
		
		if(x2 - x1 == 0){
			System.out.println((x1 + (y2 - y1)) + " " + y1 + " " + (x2 + (y2 - y1)) + " " + y2);
			return;
		}
		else if(((y2 - y1) / (x2 - x1)) == 0){
			System.out.println(x1 + " " + (y1 - (x2 - x1)) + " " + x2 + " " + (y2 - (x2 - x1)));
			return;
		}
		else if(((y2 - y1) / ((x2 - x1) * 1.0)) == 1.0){
			System.out.println(x1 + " " + y2 + " " + x2 + " " + y1);
			return;
		}
		else if(((y2 - y1) / ((x2 - x1) * 1.0)) == -1.0){
			System.out.println(x1 + " " + y2 + " " + x2 + " " + y1);
			return;
		}
		
		System.out.println(-1);
	}
}
