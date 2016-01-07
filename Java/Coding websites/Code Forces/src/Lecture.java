import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lecture {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(s.nextToken());
		int m = Integer.parseInt(s.nextToken());
		String[] one = new String[m];
		String[] two = new String[m];
		for (int i = 0; i < m; i++) {
			s = new StringTokenizer(in.readLine());
			one[i] = s.nextToken();
			two[i] = s.nextToken();
		}
		s = new StringTokenizer(in.readLine());
		String f = "";
		for (int i = 0; i < n; i++) {
			String temp = s.nextToken();
			int j;
			for (j = 0; j < one.length; j++) {
				if (one[j].equals(temp))
					break;
			}
			f += (temp.length() <= two[j].length()) ? (temp + " ")
					: (two[j] + " ");
		}
		System.out.println(f);
	}
}
