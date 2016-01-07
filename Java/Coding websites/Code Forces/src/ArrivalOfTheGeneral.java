import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ArrivalOfTheGeneral {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		int[] soldiers = new int[n];
		
		int max = 0;
		int min = 101;
		int maxIndex = 0;
		int minIndex = 0;
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(s.nextToken());
			soldiers[i] = num;
			
			if(num > max){
				max = num;
				maxIndex = i;
			}
			
			if(num <= min){
				min = num;
				minIndex = i;
			}
		}
		
		System.out.println(maxIndex + (n - minIndex - 1) - ((maxIndex > minIndex) ? 1 : 0));
	}
}
