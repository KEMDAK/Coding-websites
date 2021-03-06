import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ColorTheFence {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int v = Integer.parseInt(in.readLine());

		Digit[] arr = new Digit[9];

		StringTokenizer s = new StringTokenizer(in.readLine());

		for (int i = 0; i < 9; i++)
			arr[i] = new Digit(i + 1, Integer.parseInt(s.nextToken()));

		Arrays.sort(arr);

		int maxNum = v / arr[0].paint;

		if(v >= arr[0].paint){		

			v = v % arr[0].paint;

			int maxDigit = arr[0].value;

			int paid = arr[0].paint;

			for (int i = 0; i < maxNum; i++) {
				maxDigit = arr[0].value;

				paid = arr[0].paint;
				v += arr[0].paint;

				if(maxDigit != 9){
					for (int j = 0; j < 9; j++) {
						if(v >= arr[j].paint && arr[j].value > maxDigit){
							maxDigit = arr[j].value;
							paid = arr[j].paint;
						}
					}
				}

				out.print(maxDigit);
				v -= paid;
			}
		}
		else
			out.print("-1");

		out.flush();
		out.close();
	}

	static class Digit implements Comparable<Digit>{
		int value;
		int paint;

		public Digit(int value, int paint) {
			this.value = value;
			this.paint = paint;
		}

		@Override
		public int compareTo(Digit o) {
			if(this.paint == o.paint)
				return o.value - this.value;

			return this.paint - o.paint;
		}
	}
}
