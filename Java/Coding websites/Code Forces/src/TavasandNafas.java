import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TavasandNafas {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String num = in.readLine();

		String f = "";

		if (num.length() == 1) {
			switch (num.charAt(0)) {
			case '0':
				f += "zero";
				break;

			case '1':
				f += "one";
				break;

			case '2':
				f += "two";
				break;

			case '3':
				f += "three";
				break;

			case '4':
				f += "four";
				break;

			case '5':
				f += "five";
				break;

			case '6':
				f += "six";
				break;

			case '7':
				f += "seven";
				break;

			case '8':
				f += "eight";
				break;

			case '9':
				f += "nine";
				break;
			}
		} else {

			if (num.equals("10"))
				f += "ten";
			else if (num.equals("11"))
				f += "eleven";
			else if (num.equals("12"))
				f += "twelve";
			else {
				if (Integer.parseInt(num) >= 20) {
					switch (num.charAt(0)) {
					case '2':
						f += "twent";
						break;

					case '3':
						f += "thirt";
						break;

					case '4':
						f += "fourt";
						break;

					case '5':
						f += "fift";
						break;

					case '6':
						f += "sixt";
						break;

					case '7':
						f += "sevent";
						break;

					case '8':
						f += "eight";
						break;

					case '9':
						f += "ninet";
						break;
					}
				} else {
					switch (num.charAt(1)) {
					case '2':
						f += "twent";
						break;

					case '3':
						f += "thirt";
						break;

					case '4':
						f += "fourt";
						break;

					case '5':
						f += "fift";
						break;

					case '6':
						f += "sixt";
						break;

					case '7':
						f += "sevent";
						break;

					case '8':
						f += "eight";
						break;

					case '9':
						f += "ninet";
						break;
					}
				}

				if (Integer.parseInt(num) > 12 && Integer.parseInt(num) < 20)
					f += "een";
				else
					f += "y";

				if (Integer.parseInt(num) >= 40 && Integer.parseInt(num) < 50)
					f = "forty";

				if (Integer.parseInt(num) >= 20
						&& !(Integer.parseInt(num) % 10 == 0))
					f += "-";
				if (Integer.parseInt(num) > 20) {
					switch (num.charAt(1)) {
					case '1':
						f += "one";
						break;

					case '2':
						f += "two";
						break;

					case '3':
						f += "three";
						break;

					case '4':
						f += "four";
						break;

					case '5':
						f += "five";
						break;

					case '6':
						f += "six";
						break;

					case '7':
						f += "seven";
						break;

					case '8':
						f += "eight";
						break;

					case '9':
						f += "nine";
						break;
					}
				}
			}
		}

		System.out.println(f);
	}

}
