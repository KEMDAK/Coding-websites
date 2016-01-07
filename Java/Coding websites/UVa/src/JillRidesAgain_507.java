import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JillRidesAgain_507 {

	public static void main(String[] args) throws NumberFormatException,
	IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();

		int r = Integer.parseInt(in.readLine());

		for (int i = 1; i <= r; i++) {
			int s = Integer.parseInt(in.readLine());

			int max = 0;
			int sum = 0;
			int maxI = 1;
			int maxJ = 1;
			int tempI = 1;
			for (int j = 1; j < s; j++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				sum += Integer.parseInt(st.nextToken());
				if (sum < 0){
					sum = 0;
					tempI = j + 1;
				}
				
				if (sum != 0 && (sum > max || (sum == max && ((j + 1) - tempI > maxJ - maxI)))) {
					max = sum;
					maxI = tempI;
					maxJ = (j + 1);
				}
			}

			if (max != 0)
				out.append("The nicest part of route " + i
						+ " is between stops " + maxI + " and " + maxJ);
			else
				out.append("Route " + i + " has no nice parts");
			out.append("\n");
		}

		System.out.print(out);
	}
}
