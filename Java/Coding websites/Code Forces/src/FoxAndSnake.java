import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class FoxAndSnake {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(s.nextToken());
		int m = Integer.parseInt(s.nextToken());
		
		StringBuilder top = new StringBuilder();
		StringBuilder right = new StringBuilder("#");
		StringBuilder left = new StringBuilder("#");
		
		for (int i = 0; i < m - 1; i++) {
			right.insert(0, '.');
			left.append(".");
		}
		
		right.append("\n");
		left.append("\n");
		
		for (int i = 0; i < m; i++) {
			top.append("#");
			right.append("#");
			left.append("#");
		}
		
		System.out.println(top);
		
		int l0r1 = 1;
		for (int i = 0; i < n - 1; i = i + 2) {
			if(l0r1 == 1){
				System.out.println(right);
				l0r1 = 0;
			}
			else{
				System.out.println(left);
				l0r1 = 1;
			}
		}
	}
}
