import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


class UFDCS {
	int representative[];
	int rank[];

	public UFDCS(int n) {
		representative = new int[n];
		rank = new int[n];
		for (int i = 0; i < representative.length; i++)
			representative[i] = i;
		Arrays.fill(rank, 1);
	}

	int findSet(int x) {
		if (x == representative[x])
			return x;
		return representative[x] = findSet(representative[x]);
	}

	void union(int x, int y) {
		int x1 = findSet(x);
		int y1 = findSet(y);
		if (x1 != y1)
			if (rank[x1] > rank[y1]) {
				representative[y1] = x1;
			} else if (rank[x1] < rank[y1]) {
				representative[x1] = y1;
			} else {
				representative[x1] = y1;
				rank[y1]++;
			}
	}

}

class Triple implements Comparable<Triple>{
	int w, s, d;
	
	public Triple(int w, int s, int d) {
		this.w = w;
		this.d = d;
		this.s = s;
	}

	@Override
	public int compareTo(Triple t) {
		return w - t.w;
	}
}

public class CobbledStreets_CSTREET {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int t, p, n, m;

		t = Integer.parseInt(in.readLine());

		while(t-- > 0){
			p = Integer.parseInt(in.readLine());
			n = Integer.parseInt(in.readLine());
			m = Integer.parseInt(in.readLine());

			Triple[] edgeList = new Triple[m];
			
			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				int w, s, d;
				
				s = Integer.parseInt(st.nextToken())-1;
				d = Integer.parseInt(st.nextToken())-1;
				w = Integer.parseInt(st.nextToken());
				
				edgeList[i] = new Triple(w, s, d);
			}
			
			Arrays.sort(edgeList);
			
			int minCost = 0;
			
			UFDCS set = new UFDCS(n);
			
			for (int i = 0; i < m; i++) {
				if(set.findSet(edgeList[i].s) != set.findSet(edgeList[i].d)){
					set.union(edgeList[i].s, edgeList[i].d);
					minCost += (edgeList[i].w * p);
				}
			}
			
			out.println(minCost);
		}
		
		out.flush();
		out.close();
	}

}





























