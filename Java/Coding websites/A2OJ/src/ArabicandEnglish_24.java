import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ArabicandEnglish_24 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());

		while (T-- > 0) {
			in.readLine();
			String line = in.readLine();

			StringTokenizer s = new StringTokenizer(line);

			String before = "";
			String mid = "";
			String after = "";

			for (int i = 0; s.hasMoreTokens(); i++) {
				String token = s.nextToken();

				if (Character.isLetter(token.charAt(0))) {
					if (s.hasMoreTokens())
						if (i == 0)
							mid += " " + token;
						else
							mid += " " + token + " ";
					else
						mid += token + " ";
				} else if (mid.isEmpty())
					before += token + " ";
				else
					after += token + " ";
			}

			if (!before.isEmpty())
				before = before.substring(0, before.length() - 1);
			if (!after.isEmpty())
				after = after.substring(0, after.length() - 1);

			out.println(after + mid + before);
		}

		out.flush();
		out.close();
	}
}
