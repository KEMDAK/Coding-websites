import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShtringTask {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		s = s.toLowerCase();
		String f = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!(c == 'a' || c == 'A' || c == 'o' || c == 'O' || c == 'y'
					|| c == 'Y' || c == 'e' || c == 'E' || c == 'u' || c == 'U'
					|| c == 'i' || c == 'I'))
				f += "" + '.' + c;
		}
		System.out.println(f);
	}
}
