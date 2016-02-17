import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class ColorfulGraph {


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer s = new StringTokenizer(in.readLine());

		int n = Integer.parseInt(s.nextToken());
		int m = Integer.parseInt(s.nextToken());

		int res = 1000000;
		s = new StringTokenizer(in.readLine());
		int[] colors = new int[n];
		for (int i = 0; i < n; i++) {
			colors[i] = Integer.parseInt(s.nextToken());
			if(colors[i] < res)
				res = colors[i];
		}

		TreeSet<Integer>[] card = new TreeSet[100002];
		for (int i = 0; i < 100002; i++) {
			card[i] = new TreeSet<>();
		}

		for (int i = 0; i < m; i++) {
			s = new StringTokenizer(in.readLine());

			int src = Integer.parseInt(s.nextToken()) - 1;
			int dest = Integer.parseInt(s.nextToken()) - 1;

			if(colors[src] != colors[dest]){
				card[colors[src]].add(colors[dest]);
				card[colors[dest]].add(colors[src]);
			}
		}

		int max = 0;
		int i = 0;
		
		for (TreeSet<Integer> set : card) {
			int size = set.size();
			if(max < size){
				max = size;
				res = i;
			}
			i++;
		}

		System.out.println(res);
	}
}
