import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Parking_11364 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int t = Integer.parseInt(in.readLine());
		
		while(t-- > 0){
			int n = Integer.parseInt(in.readLine());
			
			StringTokenizer s = new StringTokenizer(in.readLine());
			
			int[] arr = new int[n];
			
			for (int i = 0; i < arr.length; i++)
				arr[i] = Integer.parseInt(s.nextToken());
			
			Arrays.sort(arr);
			
			int res = 0;
			
			for (int i = 1; i < arr.length; i++) {
				res += arr[i] - arr[i - 1];
			}
			
			out.println(res * 2);
		}
		
		out.flush();
		out.close();
	}
}
