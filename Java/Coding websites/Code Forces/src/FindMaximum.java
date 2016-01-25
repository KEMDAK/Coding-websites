import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindMaximum {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());

		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		a[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < n; i++)
			a[i] = a[i - 1] + Integer.parseInt(st.nextToken());

		String s = in.readLine();
		int prevSum = 0;
		int max = 0;
		
		for (int i = s.length() - 1; i >= 0; i--) {
			if(s.charAt(i) == '1'){
				int cur = prevSum + (i != 0 ? a[i - 1]: 0);

				max = Math.max(max, cur);
				
				prevSum += (i != 0 ? a[i] - a[i - 1]: a[0]);
			}
		}
		
		System.out.println(Math.max(max, prevSum));
	}
}
