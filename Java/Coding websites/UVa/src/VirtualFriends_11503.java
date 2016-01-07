import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

class UFDSVF {
	int[] representative;
	int[] rank;
	int[] total;

	public UFDSVF(int n) {
		representative = new int[n];
		rank = new int[n];
		total = new int[n];

		for (int i = 0; i < representative.length; i++)
			representative[i] = i;

		Arrays.fill(rank, 1);
		Arrays.fill(total, 1);
	}

	public int find(int x) {
		if (x == representative[x])
			return x;

		return representative[x] = find(representative[x]);
	}

	public void union(int x, int y) {
		int x1 = find(x);
		int y1 = find(y);

		if (x1 != y1) {
			if (rank[x1] > rank[y1]) {
				representative[y1] = x1;
				total[x1] = total[y1] + total[x1];
				System.out.println(total[x1]);
			} else if (rank[x1] < rank[y1]) {
				representative[x1] = y1;
				total[y1] = total[y1] + total[x1];
				System.out.println(total[y1]);
			} else {
				representative[y1] = x1;
				rank[x1]++;
				total[x1] = total[y1] + total[x1];
				System.out.println(total[x1]);
			}
		} else {
			System.out.println(total[x1]);
		}
	}
}

public class VirtualFriends_11503 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());

		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int F = Integer.parseInt(st.nextToken());

			String input[] = new String[F];

			TreeMap<String, Integer> map = new TreeMap<>();

			int count = 0;

			for (int i = 0; i < F; i++) {
				String line = br.readLine();
				input[i] = line;
				st = new StringTokenizer(line);
				String first = st.nextToken();
				String second = st.nextToken();
				if (!map.containsKey(first)) {
					map.put(first, count++);
				}
				if (!map.containsKey(second)) {
					map.put(second, count++);
				}
			}

			UFDSVF set = new UFDSVF(count);

			for (int i = 0; i < input.length; i++) {
				st = new StringTokenizer(input[i]);
				int x = map.get(st.nextToken());
				int y = map.get(st.nextToken());
				set.union(x, y);
			}

		}
	}
}
