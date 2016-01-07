import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class VanyaandExams {

	int a;
	int b;

	public VanyaandExams(int x, int y) {
		a = x;
		b = y;
	}

	public static void sort(VanyaandExams[] x) {
		for (int i = 0; i < x.length - 1; i++) {
			VanyaandExams min = x[i];
			int mini = i;
			for (int j = i + 1; j < x.length; j++) {
				if (x[j].b < min.b) {
					mini = j;
					min = x[j];
				}
			}
			x[mini] = x[i];
			x[i] = min;
		}
	}

	public String toString() {
		return a + ":" + b;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(s.nextToken());
		int r = Integer.parseInt(s.nextToken());
		int avg = Integer.parseInt(s.nextToken());
		VanyaandExams[] x = new VanyaandExams[n];
		long needed = 0;
		for (int i = 0; i < n; i++) {
			s = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(s.nextToken());
			int b = Integer.parseInt(s.nextToken());
			x[i] = new VanyaandExams(a, b);
			needed += a;
		}

		needed = avg * n - (needed);
		long essays = 0;
		if (needed > 0) {
			sort(x);
			System.out.println(Arrays.toString(x));
			int i = 0;
			while (needed > essays) {
				for (int j = x[i].a; j < r; j++) {
					if (needed < essays)
						break;
					essays += x[i].b;
				}
				i++;
			}
		}
		System.out.println(essays);
	}

}
