import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class RoadConstruction {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer s = new StringTokenizer(in.readLine());

		int n = Integer.parseInt(s.nextToken());
		int m = Integer.parseInt(s.nextToken());

		boolean edge[][] = new boolean[n][n];
		TreeSet<Integer> set = new TreeSet<>();

		for (int i = 0; i < m; i++) {
			s = new StringTokenizer(in.readLine());

			int x = Integer.parseInt(s.nextToken()) - 1;
			int y = Integer.parseInt(s.nextToken()) - 1;

			edge[x][y] = true;
			edge[y][x] = true;

			set.add(x);
			set.add(y);
		}

		out.println(n - 1);
		
		for (int i = 0; i < n; i++) {
			if(!set.contains(i)){
				for (int j = 0; j < n; j++) {
					if(i != j)
					out.println((i + 1) + " " + (j + 1));
				}
				break;
			}
		}
		
		out.flush();
		out.close();
	}
}

























