import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Arrays {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer s = new StringTokenizer(in.readLine());

		int NA = Integer.parseInt(s.nextToken());
		int NB = Integer.parseInt(s.nextToken());

		s = new StringTokenizer(in.readLine());

		int K = Integer.parseInt(s.nextToken());
		int M = Integer.parseInt(s.nextToken());

		s = new StringTokenizer(in.readLine());

		int first = 0;

		for (int i = 0; i < NA; i++) {
			if(i + 1 == K){
				first = Integer.parseInt(s.nextToken());
				break;
			}else
				s.nextToken();
		}

		s = new StringTokenizer(in.readLine());

		int second = 0;

		for (int i = 0; i < NB; i++) {
			if(NB - M == i){
				second = Integer.parseInt(s.nextToken());
				break;
			}else
				s.nextToken();
		}
		
//		System.out.println(first + " : " + second);

		if(second > first)
			out.print("YES");
		else
			out.print("NO");

		out.flush();
		out.close();
	}
}
