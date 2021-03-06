import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ThePriceIsCorrect {

	static long[] boxes;
	static int N, P;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new FileReader("the_price_is_correct.txt"));
		PrintWriter out = new PrintWriter(new File("the_price_is_correct_out.txt"));
		
		int T = Integer.parseInt(in.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer s = new StringTokenizer(in.readLine());
			
			N = Integer.parseInt(s.nextToken());
			P = Integer.parseInt(s.nextToken());
			
			boxes = new long[N];
			
			s = new StringTokenizer(in.readLine());
			boxes[0] = Long.parseLong(s.nextToken());
			for (int i = 1; i < N; i++)
				boxes[i] = boxes[i - 1] + Long.parseLong(s.nextToken());
			
			long total = 0;
			
			for (int i = 0; i < N; i++) {
				
				int low = i;
				int high = N - 1;
				int j = -1;
				while(low <= high){
					int mid = low + (high - low) / 2;
					if(can(i, mid)){
						j = mid;
						low = mid + 1;
					}
					else
						high = mid - 1;
				}
				
				if(j != -1)
					total += (j - i + 1);
			}
			
			out.printf("Case #%d: %d\n", t, total);
		}
		
		out.flush();
		out.close();
	}

	public static boolean can(int i, int j) {
		return (boxes[j] - (i == 0 ? 0 : boxes[i - 1]) <= P);
	}
}
