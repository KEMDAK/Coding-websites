import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TwoButtons {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(s.nextToken());
		int m = Integer.parseInt(s.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		int[] dest  = new int[100000];
		Arrays.fill(dest, -1);
		
		dest[n] = 0;
		q.add(n);
		while(!q.isEmpty()){
			int u = q.poll();
			
			if(u >= 20000)continue;

			if(u == m){
				break;
			}
			
			if(dest[u * 2] == -1){
				dest[u * 2] = dest[u] + 1;
				q.add(u * 2);
			}
			
			if(u - 1 >= 0 && dest[u - 1] == -1){
				dest[u - 1] = dest[u] + 1;
				q.add(u - 1);
			}
		}
		
		System.out.println(dest[m]);
	}
}
