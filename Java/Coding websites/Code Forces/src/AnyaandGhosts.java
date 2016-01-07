import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class AnyaandGhosts {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		int m = Integer.parseInt(s.nextToken());
		int t = Integer.parseInt(s.nextToken());
		int r = Integer.parseInt(s.nextToken());
		LinkedList<Integer> can = new LinkedList<>();
		s = new StringTokenizer(in.readLine());
		int n = 0;
		for (int i = 0; i < m; i++) {
			int time = Integer.parseInt(s.nextToken());
			for (int j : can) {
				if (j + t > time)

					can.remove(j);
			}

		}

	}
}
