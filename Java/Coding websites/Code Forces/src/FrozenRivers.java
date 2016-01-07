import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FrozenRivers {

	static ArrayList<Node> adj[];
	static ArrayList<Long> leaf;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int t = Integer.parseInt(in.readLine());

		while(t-- > 0){
			int n = Integer.parseInt(in.readLine());

			adj = new ArrayList[n];

			for (int i = 0; i < adj.length; i++)
				adj[i] = new ArrayList<>();

			for (int i = 1; i < n ; i++) {
				StringTokenizer s = new StringTokenizer(in.readLine());

				int p = Integer.parseInt(s.nextToken()) - 1;
				int c = Integer.parseInt(s.nextToken());

				adj[p].add(new Node(i, c));
			}
			//the above code is correct
			
			leaf = new ArrayList<>();

			Queue<Node> q = new LinkedList<>();
			q.add(new Node(0, 0));

			while(!q.isEmpty()){
				Node parent = q.poll();

				Node min = null;

				for (int i = 0; i < adj[parent.name].size(); i++)
					if(min == null || adj[parent.name].get(i).time < min.time)
						min = adj[parent.name].get(i);

				if(min == null)
					leaf.add(parent.time);
				else{
					for (int i = 0; i < adj[parent.name].size(); i++) {
						Node child = adj[parent.name].get(i);

						q.add(new Node(child.name, parent.time + min.time + (child.time - min.time) * 2));
					}	
				}
			}

			//the rest of the code is correct
			Collections.sort(leaf);

			int queries = Integer.parseInt(in.readLine());

			for (int i = 0; i < queries; i++) {
				long key = Long.parseLong(in.readLine());
				out.println(binarySearch(key));
			}
		}

		out.flush();
		out.close();
	}

	public static int binarySearch(long key){
		int low = 0;
		int high = leaf.size() - 1;

		int res = -1;

		while(low <= high){
			int mid = low + (high-low) / 2;

			if(leaf.get(mid) == key){
				res = mid;
				low = mid + 1;
			}
			else if(key > leaf.get(mid))
				low = mid + 1;
			else
				high = mid - 1;
		}

		if(res != -1)
			return res + 1;
		else
			return high + 1;
	}
}

class Node{
	int name;
	long time;

	public Node(int name, long time) {
		this.name = name;
		this.time = time;
	}
}