import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class AddAll_10954 {

	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(true){
			int n = Integer.parseInt(in.readLine());
			
			if(n == 0)
				break;
			
			PriorityQueue<Integer> pq = new PriorityQueue<>(n);
			
			StringTokenizer s = new StringTokenizer(in.readLine());
			
			for (int i = 0; i < n; i++) 
				pq.add(Integer.parseInt(s.nextToken()));
			
			long res = 0;
			while(true){
				int num1 = pq.poll();
				int num2 = pq.poll();
				
				int cur = num1 + num2;
				res += cur;
				
				if(pq.isEmpty())
					break;
				
				pq.add(cur);
			}
			
			out.println(res);
		}
		
		out.flush();
		out.close();
	}
}
