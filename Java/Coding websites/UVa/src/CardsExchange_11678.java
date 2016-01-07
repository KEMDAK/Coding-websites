import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CardsExchange_11678 {

	public static void main(String[] args) throws IOException { // the commented
																// part is the
																// implementation
																// with
																// ArrayList and
																// it is faster
																// than the
																// HashSet !!!

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String line;
		while (!(line = in.readLine()).equals("0 0")) {

			StringTokenizer s = new StringTokenizer(line);

			int sizeA = Integer.parseInt(s.nextToken());
			int sizeB = Integer.parseInt(s.nextToken());

			String A = in.readLine();
			String B = in.readLine();

			// ArrayList<Integer> As = new ArrayList<Integer>();
			// ArrayList<Integer> Bs = new ArrayList<Integer>();
			HashSet<Integer> As = new HashSet<>();
			HashSet<Integer> Bs = new HashSet<>();

			s = new StringTokenizer(A);
			for (int i = 0; i < sizeA; i++) {
				int num = Integer.parseInt(s.nextToken());
				// if (Collections.binarySearch(As, num) < 0)
				As.add(num);
			}

			s = new StringTokenizer(B);
			for (int i = 0; i < sizeB; i++) {
				int num = Integer.parseInt(s.nextToken());
				// if (Collections.binarySearch(Bs, num) < 0)
				Bs.add(num);
			}

			int diffA = 0;

			// for (int i = 0; i < As.size(); i++) {
			for (Object x : As.toArray()) {
				// int token = As.get(i);
				int token = (int) x;
				// if (Collections.binarySearch(Bs, token) < 0)
				if (!Bs.contains(token))
					diffA++;
			}

			int diffB = 0;

			// for (int i = 0; i < Bs.size(); i++){
			for (Object x : Bs.toArray()) {
				// int token = Bs.get(i);
				int token = (int) x;
				// if (Collections.binarySearch(As, token) < 0)
				if (!As.contains(token))
					diffB++;
			}

			System.out.println(Math.min(diffA, diffB));
		}

	}
}
