import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Division_725 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int c = 0;
		
		while(true){
			int N = Integer.parseInt(in.readLine());
			
			if(N == 0)
				break;
			
			if(c != 0)
				out.print("\n");
			c++;
			
			boolean valid = false;
			boolean done = false;
			
			for (int i = 0; i < 10 && !done; i++) {
				for (int j = 0; j < 10 && !done; j++) {
					if(j == i) continue;
					for (int j2 = 0; j2 < 10 && !done; j2++) {
						if(j2 == i || j2 == j) continue;
						for (int k = 0; k < 10 && !done; k++) {
							if(k == i || k == j || k == j2) continue;
							for (int k2 = 0; k2 < 10 && !done; k2++) {
								if(k2 == i || k2 == j || k2 == j2 || k2 == k) continue;
								
								int d = 0;
								d += i * Math.pow(10, 4);
								d += j * Math.pow(10, 3);
								d += j2 * Math.pow(10, 2);
								d += k * Math.pow(10, 1);
								d += k2 * Math.pow(10, 0);
								
								int u = d * N;
								
								if(u > 98765){
									done = true;
									continue;
								}
								
//								System.out.println("u: " + u + ", d: " + d + " " + isDiff(u, d));
								
								if(isDiff(u, d)){
									valid = true;
									if(u < 10000)
										out.print(0);
									out.print(u);
									out.print(" / ");
									if(d < 10000)
										out.print(0);
									out.print(d);
									out.print(" = ");
									out.print(N + "\n");
									
								}
							}
						}
					}
				}
			}
			
			if(!valid)
				out.printf("There are no solutions for %d.\n", N);
		}
		
		out.flush();
		out.close();
	}

	public static boolean isDiff(int u, int d) {
		int mask = 0;
		
		if(d < 10000)
			mask |= 1;	
		while(d != 0){
			mask |= (1 << (d % 10));
			d /= 10;
		}
		
		if(u < 10000 && (mask & 1) != 0)
			return false;
		
		while(u != 0){
			if((mask & (1 << (u % 10))) != 0)
				return false;
			
			mask |= (1 << (u % 10));
			u /= 10;
		}	
			
		return true;
	}
}
