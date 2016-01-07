import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

class UFDSN {
	int[] representative;
	int[] rank;
	int[] longest;
	int max;

	public UFDSN(int n) {
		representative = new int[n];
		rank = new int[n];
		longest = new int[n];
		max = 1;

		for (int i = 0; i < representative.length; i++)
			representative[i] = i;

		Arrays.fill(rank, 1);
		Arrays.fill(longest, 1);
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
				longest[x1] = longest[y1] + longest[x1];
				if (longest[x1] > max)
					max = longest[x1];
			} else if (rank[x1] < rank[y1]) {
				representative[x1] = y1;
				longest[y1] = longest[y1] + longest[x1];
				if (longest[y1] > max)
					max = longest[y1];
			} else {
				representative[y1] = x1;
				rank[x1]++;
				longest[x1] = longest[y1] + longest[x1];
				if (longest[x1] > max)
					max = longest[x1];
			}
		}
	}
}

public class Nature_10685 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String read;
		while (!(read = br.readLine()).equals("0 0")) {
			StringTokenizer st = new StringTokenizer(read);
			int C = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			TreeMap<String, Integer> map = new TreeMap<>();

			int count = 0;

			for (int i = 0; i < C; i++) {
				String line = br.readLine();
				st = new StringTokenizer(line);
				if (!map.containsKey(st.nextToken()))
					map.put(line, count++);
			}

			UFDSN set = new UFDSN(C);

			for (int i = 0; i < R; i++) {
				String line = br.readLine();
				st = new StringTokenizer(line);
				int x = map.get(st.nextToken());
				int y = map.get(st.nextToken());
				set.union(x, y);
			}

			System.out.println(set.max);
			br.readLine();
		}
	}
}
