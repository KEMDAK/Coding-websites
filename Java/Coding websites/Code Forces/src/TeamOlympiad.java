import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TeamOlympiad {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(s.nextToken());
		String[] x = (in.readLine()).split(" ");
		boolean one = false, two = false, three = false;
		String f = "";
		int o = 0, t = 0, th = 0;
		int c = 0;
		for (int j = n / 3; j > 0; j--) {
			for (int i = 0; i < x.length; i++) {
				if (x[i].equals("1") && !one) {
					one = true;
					x[i] = "";
					o = i + 1;
				}
				if (x[i].equals("2") && !two) {
					two = true;
					x[i] = "";
					t = i + 1;
				}
				if (x[i].equals("3") && !three) {
					three = true;
					x[i] = "";
					th = i + 1;
				}
			}
			if (one && two && three) {
				one = false;
				two = false;
				three = false;
				f += o + " " + t + " " + th;
				f += "\n";
				c++;
			} else
				break;
		}
		System.out.println(c + "\n" + f);

	}
}
