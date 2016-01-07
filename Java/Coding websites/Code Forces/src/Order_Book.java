import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Order_Book {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		ArrayList<Order> mapS = new ArrayList<>();
		ArrayList<Order> mapB = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());

			if(st.nextToken().charAt(0) == 'B'){
				int d = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				Integer mapP = mapB.indexOf(new Order(d, p));
				if(mapP == -1)
					mapB.add(new Order(d, p));
				else
					mapB.get(mapP).q += p;
			}
			else{
				int d = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				Integer mapP = mapS.indexOf(new Order(d, p));
				if(mapP == -1)
					mapS.add(new Order(d, p));
				else
					mapS.get(mapP).q += p;
			}
		}

		Collections.sort(mapB);
		Collections.sort(mapS);

		if(mapS.size() >= s){
			for (int i = s - 1; i >= 0; i--) {
				out.println('S' + " " + mapS.get(i));
			}
		}
		else{
			for (int i = mapS.size() - 1; i >= 0; i--) {
				out.println('S' + " " + mapS.get(i));
			}
		}

		if(mapB.size() >= s){
			for (int i = mapB.size() - 1; i > mapB.size() - s - 1; i--) {
				out.println('B' + " " + mapB.get(i));
			}
		}
		else{
			for (int i = mapB.size() - 1; i >= 0; i--) {
				out.println('B' + " " + mapB.get(i));
			}
		}

		out.flush();
		out.close();
	}
}

class Order implements Comparable<Order>{
	int p, q;

	public Order(int d, int p){
		this.p = d;
		this.q = p;
	}

	@Override
	public int compareTo(Order o) {
		return this.p - o.p;
	}

	@Override
	public boolean equals(Object obj) {
		Order o = (Order) obj;
		return (this.p == o.p);
	}

	@Override
	public String toString() {
		return p + " " + q;
	}

}





