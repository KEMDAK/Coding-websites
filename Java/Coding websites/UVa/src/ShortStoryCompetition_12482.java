import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ShortStoryCompetition_12482 {


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while(in.ready()){
			StringTokenizer s = new StringTokenizer(in.readLine());

			int N = Integer.parseInt(s.nextToken());
			int L = Integer.parseInt(s.nextToken());
			int C = Integer.parseInt(s.nextToken());

			int pages = 1;
			int lines = 1;
			int ch = 0;

			s = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				int word = s.nextToken().length() + (i == 0 ? 0 : 1);

				ch += word;
				
				if(ch > C){
					lines++;
					ch = word - 1;
				}
				
				if(lines > L){
					pages++;
					lines = 1;
				}
			}

			out.println(pages);
		}

		out.flush();
		out.close();
	}
}
