import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class puzzles {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(s.nextToken());
		int m = Integer.parseInt(s.nextToken());
		
		int[] puzzles = new int[m];
		s = new StringTokenizer(in.readLine());
		for (int i = 0; i < m; i++) {
			puzzles[i] = Integer.parseInt(s.nextToken());
		}
		
		Arrays.sort(puzzles);
		
		int min = 2000;
		for (int i = 0; i < puzzles.length - n + 1; i++) {
			if(puzzles[i + n - 1] - puzzles[i] < min)
				min = puzzles[i + n - 1] - puzzles[i];
		}
		
		System.out.println(min);
	}
}
