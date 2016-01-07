import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class UFDSMM {
	int[] representative;
	int[] rank;
	int[] money;

	public UFDSMM(int n, int[] money) {
		representative = new int[n];
		rank = new int[n];
		this.money = money;

		for (int i = 0; i < representative.length; i++)
			representative[i] = i;

		Arrays.fill(rank, 1);
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
				money[x1] = money[x1] + money[y1];
				money[y1] = 0;
			} else if (rank[x1] < rank[y1]) {
				representative[x1] = y1;
				money[y1] = money[x1] + money[y1];
				money[x1] = 0;
			} else {
				representative[y1] = x1;
				money[x1] = money[x1] + money[y1];
				money[y1] = 0;
				rank[x1]++;
			}
		}
	}
}

public class MoneyMatters_11690 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[] money = new int[n];

			for (int i = 0; i < n; i++) {
				money[i] = Integer.parseInt(br.readLine());
			}

			UFDSMM set = new UFDSMM(n, money);

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				set.union(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}

			boolean possible = true;

			for (int i = 0; i < money.length; i++) {
				if (money[i] != 0) {
					possible = false;
					break;
				}
			}

			if (possible)
				System.out.println("POSSIBLE");
			else
				System.out.println("IMPOSSIBLE");
		}
	}
}
