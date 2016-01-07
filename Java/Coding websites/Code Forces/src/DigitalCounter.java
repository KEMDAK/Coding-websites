import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class DigitalCounter {

	static int zero = 2;
	static int one = 7;
	static int two = 2;
	static int three = 3;
	static int four = 3;
	static int five = 4;
	static int six = 2;
	static int seven = 5;
	static int eight = 1;
	static int nine = 2;

	public static int posobilities(String s) {
		int x = s.charAt(0) - '0';
		int y = s.charAt(1) - '0';
		switch (x) {
		case 0:
			x = zero;
			break;
		case 1:
			x = one;
			break;
		case 2:
			x = two;
			break;
		case 3:
			x = three;
			break;
		case 4:
			x = four;
			break;
		case 5:
			x = five;
			break;
		case 6:
			x = six;
			break;
		case 7:
			x = seven;
			break;
		case 8:
			x = eight;
			break;
		case 9:
			x = nine;
			break;
		}
		switch (y) {
		case 0:
			y = zero;
			break;
		case 1:
			y = one;
			break;
		case 2:
			y = two;
			break;
		case 3:
			y = three;
			break;
		case 4:
			y = four;
			break;
		case 5:
			y = five;
			break;
		case 6:
			y = six;
			break;
		case 7:
			y = seven;
			break;
		case 8:
			y = eight;
			break;
		case 9:
			y = nine;
			break;
		}
		return x * y;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		System.out.println(posobilities(s.nextToken()));
	}
}
