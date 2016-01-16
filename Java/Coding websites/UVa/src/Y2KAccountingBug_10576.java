import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Y2KAccountingBug_10576 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(in.ready()){
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			long maxSurplus = -1;
			for (int mask = 0; mask < (1 << 12); mask++) {
				
				boolean valid = true;
				for (int i = 0; i <= 7; i++) {
					long sum = 0;
					for (int j = i; j < i + 5; j++) {
						if(((mask & (1 << 11 - j)) == 0)){
							sum -= d;
						}
						else{
							sum += s;
						}
					}
					
					if(sum > 0){
						valid = false;
						break;
					}
				}
				
				if(valid){
					long totalSum = 0;
					for (int i = 0; i < 12; i++) {
						if(((mask & (1 << 11 - i)) == 0)){
							totalSum -= d;
						}
						else{
							totalSum += s;
						}
					}
					
					if(totalSum > maxSurplus)
						maxSurplus = totalSum;
				}
			}
			
			if(maxSurplus >= 0)
				out.println(maxSurplus);
			else
				out.println("Deficit");
		}
		
		out.flush();
		out.close();
	}
}
