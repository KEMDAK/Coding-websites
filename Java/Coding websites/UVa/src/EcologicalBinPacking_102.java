import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EcologicalBinPacking_102 {

	static long B[], C[], G[];
	static long BTotal, CTotal, GTotal;
	static long min;
	static String minc;

	public static boolean nextPerm(char[] arr) {
		int length = arr.length;

		int i = length - 2;
		for (; i >= 0; i--) { // loop to find the first element that is smaller
								// than its next one
			if (arr[i] < arr[i + 1])
				break;
		}

		if (i == -1)
			return false;

		int j = length - 1;
		for (; j >= i; j--) { // >= (if there are repetitions // loop to find
								// the next greater element to arr[i] and swap
								// them
			if (arr[j] > arr[i]) {
				char temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				break;
			}
		}

		int s, e;
		s = i + 1;
		e = length - 1;
		while (s < e) {
			char temp = arr[s];
			arr[s] = arr[e];
			arr[e] = temp;
			s++;
			e--;
		}

		return true;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		// int[] arr = {1, 2, 3};
		//
		// do{
		// System.out.println(Arrays.toString(arr));
		// }while(nextPerm(arr));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while (in.ready()) {

			min = Long.MAX_VALUE;
			BTotal = 0;
			GTotal = 0;
			CTotal = 0;
			String line = in.readLine();
			String[] s = line.split(" ");
			B = new long[3];
			C = new long[3];
			G = new long[3];
			for (int i = 0, j = 0; i < s.length; i += 3, j++) {
				// BGC
				B[j] = Long.parseLong(s[i]);
				BTotal += B[j];
				G[j] = Long.parseLong(s[i + 1]);
				GTotal += G[j];
				C[j] = Long.parseLong(s[i + 2]);
				CTotal += C[j];
			}
			char[] arr = { 'B', 'C', 'G' };
			do {
				tryPerm("" + arr[0] + arr[1] + arr[2]);
			} while (nextPerm(arr));

			System.out.println(minc + " " + min);
		}
	}

	public static void tryPerm(String c) {
		int move = 0;
		for (int i = 0; i < c.length(); i++) {
			switch (c.charAt(i)) {
			case 'B':
				move += BTotal - B[i];
				break;
			case 'C':
				move += CTotal - C[i];
				break;
			case 'G':
				move += GTotal - G[i];
				break;
			}
		}
		if (move < min) {
			min = move;
			minc = c;
		} else if (move == min && c.compareTo(minc) < 0) {
			minc = c;
		}
	}
}
