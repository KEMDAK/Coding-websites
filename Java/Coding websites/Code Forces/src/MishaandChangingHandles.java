import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MishaandChangingHandles {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int q = Integer.parseInt(in.readLine());

		ArrayList<String> n = new ArrayList<String>();
		ArrayList<String> o = new ArrayList<String>();

		while (q-- > 0) {
			StringTokenizer s = new StringTokenizer(in.readLine());
			String oh = s.nextToken();
			String nh = s.nextToken();

			int index;

			if ((index = n.indexOf(oh)) != -1) {
				n.set(index, nh);
			} else {
				n.add(nh);
				o.add(oh);
			}
		}

		System.out.println(n.size());
		for (int i = 0; i < o.size(); i++) {
			System.out.println(o.get(i) + " " + n.get(i));
		}
	}

}
