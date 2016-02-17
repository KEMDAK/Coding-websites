import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Multitasking_11926 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while(true){
			StringTokenizer s = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(s.nextToken());
			int m = Integer.parseInt(s.nextToken());

			if (n == 0 && m == 0)
				break;

			boolean valid = true;
			boolean[] time = new boolean[2000000];

			for (int i = 0; i < n; i++) {
				s = new StringTokenizer(in.readLine());

				if(!valid) continue;

				int start = Integer.parseInt(s.nextToken());
				int end = Integer.parseInt(s.nextToken());
				
				for (int j = start; j < Math.min(end, 1000000) && valid; j++) {
					if(time[j])
						valid = false;
					time[j] = true;
				}
			}
			
			for (int i = 0; i < m; i++) {
				s = new StringTokenizer(in.readLine());

				if(!valid) continue;

				int start = Integer.parseInt(s.nextToken());
				int end = Integer.parseInt(s.nextToken());
				int repeat = Integer.parseInt(s.nextToken());

				for (int j = start, k = end; j <= 1000000 && valid; j+= repeat, k+= repeat) {
					
					for (int l = j; l < Math.min(k, 1000000) && valid; l++) {
						if(time[l])
							valid = false;
						time[l] = true;
					}
				}
			}

			if(!valid)
				out.println("CONFLICT");
			else
				out.println("NO CONFLICT");
		}

		out.flush();
		out.close();
	}
}
