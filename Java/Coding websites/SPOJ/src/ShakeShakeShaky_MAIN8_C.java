import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ShakeShakeShaky_MAIN8_C {

	static int[] boxes;
	static long students;
	
	public static boolean canBeDivided(int candiesPerStudent){
		long s = students;
		for (int i = 0; i < boxes.length; i++) 
			s -= boxes[i] / candiesPerStudent;
		
		if(s > 0)
			return false;
		else
			return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int T = Integer.parseInt(in.readLine());
		
		while (T-- > 0){
			StringTokenizer s = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(s.nextToken());
			students = Long.parseLong(s.nextToken());
			
			boxes = new int[N];
			
			s = new StringTokenizer(in.readLine());
			for (int i = 0; i < boxes.length; i++)
				boxes[i] = Integer.parseInt(s.nextToken());
			
			int low = 1;
			int high = 1000000000;
			int res = 0;
			
			while(low <= high){
				int mid = low + (high - low) / 2;
				
				if(canBeDivided(mid)){
					res = mid;
					low = mid + 1;
				}
				else{
					high = mid - 1;
				}
			}
			
			out.println(res);
		}
		
		out.flush();
		out.close();
	}
}
