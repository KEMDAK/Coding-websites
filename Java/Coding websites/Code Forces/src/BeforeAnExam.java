import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeforeAnExam {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer s = new StringTokenizer(in.readLine());

		int d = Integer.parseInt(s.nextToken());
		int sumTime = Integer.parseInt(s.nextToken());

		int[] toll = new int[d];
		int[] res = new int[d];

		int total = 0;
		for (int i = 0; i < d; i++) {
			s = new StringTokenizer(in.readLine());

			int min = Integer.parseInt(s.nextToken());
			int max = Integer.parseInt(s.nextToken());

			toll[i] = max - min;
			res[i] = min;
			total += min;
		}
		
		if(total > sumTime){
			System.out.println("NO");
			return;
		}
		
		for (int i = 0; i < res.length; i++) {
			if(total == sumTime)
				break;
			
			if(total + toll[i] <= sumTime){
				total += toll[i];
				res[i] += toll[i];
			}
			else{
				res[i] += sumTime - total;
				total += sumTime - total;
			}
		}
		
		if(total == sumTime){
			System.out.println("YES");
			for (int i = 0; i < d; i++) {
				System.out.print(res[i] + " ");
			}
		}
		else
			System.out.println("NO");
			
	}
}
