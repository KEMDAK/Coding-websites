import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MoviePolice_12515 {

	public static int hammingDistance(String a, String b) {
		int min = 101;
		for (int i = 0; i <= a.length() - b.length(); i++) {
			String temp = a.substring(i, i + b.length());
			int hamm = 0;
			for (int j = 0; j < temp.length(); j++) {
				if (temp.charAt(j) != b.charAt(j))
					hamm++;
			}
			if (hamm < min)
				min = hamm;
		}
		return min;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(s.nextToken());
		int Q = Integer.parseInt(s.nextToken());
		String[] db = new String[M];

		for (int i = 0; i < db.length; i++) {
			db[i] = in.readLine();
		}

		while (Q-- > 0) {
			int minh = 101;
			int mini = 1;
			String b = in.readLine();
			for (int i = 0; i < db.length; i++) {
				int temp = 101;
				if (b.length() < db[i].length())
					temp = hammingDistance(db[i], b);
				if (temp < minh) {
					minh = temp;
					mini = i + 1;
				}
			}
			System.out.println(mini);
		}
	}
}