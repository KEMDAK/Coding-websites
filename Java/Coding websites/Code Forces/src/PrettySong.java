import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrettySong {

	static int[] comulative;
	static int length;

	public static double simplePrettiness(int i, int j) {
		if(i != 0)
			return ((comulative[j] - comulative[i - 1]) * 1.0) / ((j - i + 1) * 1.0);
		else
			return (comulative[j] * 1.0) / ((j - i + 1) * 1.0);
	}

	public static double prettiness() {
		double total = 0.0;
		for (int i = 0; i < length; i++) {
			for (int j = i; j < length; j++) {
				total += simplePrettiness(i, j);
			}
		}
		return total;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		{
			String str = in.readLine();
			comulative = new int[str.length()];
			length = comulative.length;

			int acc = 0;
			for (int i = 0; i < comulative.length; i++) {
				if(str.charAt(i) == 'I' || str.charAt(i) == 'E' || str.charAt(i) == 'A'
						|| str.charAt(i) == 'O' || str.charAt(i) == 'U'
						|| str.charAt(i) == 'Y')
					acc++;
				comulative[i] = acc;
			}
		}

		double d = prettiness();
		System.out.printf("%.7f", d);
	}

}
