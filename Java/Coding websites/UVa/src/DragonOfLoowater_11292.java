import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class DragonOfLoowater_11292 {

	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(true){
			StringTokenizer s = new StringTokenizer(in.readLine());
			
			int n = Integer.parseInt(s.nextToken());
			int m = Integer.parseInt(s.nextToken());
			
			if(n == 0 && m == 0)
				break;
			
			int[] heads = new int[n];
			int[] knights = new int[m];
			
			for (int i = 0; i < n; i++)
				heads[i] = Integer.parseInt(in.readLine());
			
			for (int i = 0; i < m; i++)
				knights[i] = Integer.parseInt(in.readLine());
			
			if(n > m){
				out.println("Loowater is doomed!");
				continue;
			}
			
			Arrays.sort(knights);
			
			TreeSet<Integer> used = new TreeSet<>();
			
			boolean valid = true;
			int minCost = 0;
			
			for (int i = 0; i < heads.length; i++) {
				int key = heads[i];
				
				int low = 0;
				int high = m - 1;
				
				int ans = -1;
				
				while(low <= high){
					int mid = ((high - low) / 2) + low;
					
					if(knights[mid] == key && !used.contains(mid)){
						ans = mid;
						high = mid - 1;
					}
					else if(knights[mid] == key && used.contains(mid)){
						ans = mid;
						low = mid + 1;
					}
					else if(knights[mid] > key)
						high = mid - 1;
					else
						low = mid + 1;
				}
				
				if(ans == -1)
					ans = high + 1;
				
				if(ans >= m){
					valid = false;
					break;
				}
				
				if(used.contains(ans)){
					boolean found = false;
//					System.out.println("here");
					for (int j = ans + 1; j < m; j++) {
						if(!used.contains(j)){
							used.add(j);
							minCost += knights[j];
							found = true;
							break;
						}
					}
					
					if(!found){
						valid = false;
						break;
					}
				}
				else{
					used.add(ans);
					minCost += knights[ans];
				}
			}
			
			if(valid)
				out.println(minCost);
			else
				out.println("Loowater is doomed!");
		}
		
		out.flush();
		out.close();
	}
}
