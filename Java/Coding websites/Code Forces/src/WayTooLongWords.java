import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WayTooLongWords {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String f = "";
		for (int i = 0; i < n; i++) {
			String s = in.readLine();
			if (s.length() > 10)
				f += "" + s.charAt(0) + (s.length() - 2)
						+ s.charAt(s.length() - 1);
			else
				f += s;
			f += "\n";
		}
		System.out.println(f);
	}
}
