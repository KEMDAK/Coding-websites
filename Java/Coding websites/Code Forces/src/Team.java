import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Team {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(s.nextToken());
		int c = 0;
		for (int i = 0; i < n; i++) {
			s = new StringTokenizer(in.readLine());
			int sure = 0;
			for (int j = 0; j < 3; j++)
				sure += Integer.parseInt(s.nextToken());
			if (sure >= 2)
				c++;
		}
		System.out.println(c);
	}
}
