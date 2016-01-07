import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class RareOrder_200 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while (in.ready()) {

			ArrayList<Character> set = new ArrayList<Character>();

			ArrayList<String> input = new ArrayList<>();

			int maxL = 0;

			while (true) {
				String line = in.readLine();

				if (line.charAt(0) == '#')
					break;

				if (line.length() > maxL)
					maxL = line.length();

				input.add(line);
			}

			for (int i = 0; i < maxL; i++) {
				for (int j = 0; j < input.size(); j++) {
					if (i < input.get(j).length())
						if (!set.contains((input).get(j).charAt(i))) {
							set.add(input.get(j).charAt(i));
						}

				}
			}

			for (Character character : set) {
				out.print(character);
			}
			out.println();
		}

		out.flush();
		out.close();
	}
}
