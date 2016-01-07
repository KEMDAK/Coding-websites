import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheTextSplitting {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		if(p > q){
			int temp = p;
			p = q;
			q = temp;
		}
		
		String s = in.readLine();
		
		int partitions1 = 0;
		int partitions2 = 0;
		int par = 0;;
		
		if((n % p) == 0){
			partitions1 = n / p;
			par = p;
		}
		else if(n % q == 0){
			partitions1 = n / q;
			par = q;
		}
		else {
			par = p;
			while((n - (partitions1 * p)) % q != 0 && (n - (partitions1 * p)) > 0)
				partitions1++;
			
			if((n - (partitions1 * p)) % q == 0)
				partitions2 = (n - (partitions1 * p)) / q;
			else
				partitions1 = 0;
		}
		
		if(partitions1 == 0){
			System.out.println(-1);
		}
		else if(partitions2 == 0){
			System.out.println(partitions1);
			
			int i = 0;
			
			for (int j = 0; j < partitions1; j++) {
				for (int k = 0; k < par; k++) {
					System.out.print(s.charAt(i));
					i++;
				}
				System.out.println();
			}
		}
		else{
			System.out.println(partitions1 + partitions2);
			
			int i = 0;
			
			for (int j = 0; j < partitions1; j++) {
				for (int k = 0; k < par; k++) {
					System.out.print(s.charAt(i));
					i++;
				}
				System.out.println();
			}
			
			if(par == p)
				par = q;
			else
				par = p;
			
			for (int j = 0; j < partitions2; j++) {
				for (int k = 0; k < par; k++) {
					System.out.print(s.charAt(i));
					i++;
				}
				System.out.println();
			}
		}
	}
}