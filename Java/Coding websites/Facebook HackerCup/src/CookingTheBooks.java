import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CookingTheBooks {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		String result = "";
		for (int i = 1; i <= t; i++) {
			String num = in.readLine();
			int minI = 0;
			int maxI = 0;
			int maxN = num.charAt(0) - '0';
			int minN = num.charAt(0) - '0';
			int First = num.charAt(0) - '0';
			if (num.length() > 2) {
				for (int j = 1; j < num.length(); j++) {
					if ((num.charAt(j) - '0') > maxN) {
						maxN = num.charAt(j) - '0';
						maxI = j;
					}
					if ((num.charAt(j) - '0') < minN
							&& (num.charAt(j) - '0') > 0) {
						minN = num.charAt(j) - '0';
						minI = j;
					}
				}
				result += "Case #" + i + ": " + minN;
				if (minI != 0)
					result += num.substring(1, minI) + First;
				if (minI != num.length() - 1)
					result += num.substring(minI + 1);
				result += " " + maxN;
				if (maxI != 0)
					result += num.substring(1, maxI) + First;
				if (maxI != num.length() - 1)
					result += num.substring(maxI + 1);
				result += "\n";
			} else
				result += "Case #" + i + ": " + num + " " + num + "\n";
		}
		System.out.println(result);
	}
}
