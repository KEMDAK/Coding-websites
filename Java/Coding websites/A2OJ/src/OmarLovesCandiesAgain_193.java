import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class OmarLovesCandiesAgain_193 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());

		while (T-- > 0) {
			String line = in.readLine();

			int max = 1;
			char candy = line.charAt(0);

			for (int i = 0; i < line.length(); i++) {
				int count = 0;
				for (int j = 0; j < line.length(); j++) {
					if (line.charAt(i) == line.charAt(j))
						count++;
				}
				if (count > max || (count == max && line.charAt(i) < candy)) {
					max = count;
					candy = line.charAt(i);
				}
			}

			out.println(max + " " + candy);
		}

		out.flush();
		out.close();
	}
}
