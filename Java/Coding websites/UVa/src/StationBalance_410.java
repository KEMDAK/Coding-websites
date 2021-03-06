import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class StationBalance_410 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

//				long curt = System.currentTimeMillis();//////////////////////////////////
//				while(System.currentTimeMillis() - curt < 3000){///////////////////////////
//					
//				}////////////////////////////
//				System.out.println("done");

		int set = 1;

		while(in.ready()){
			StringTokenizer st = new StringTokenizer(in.readLine());

			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(in.readLine());

			ArrayList<Integer> specimen = new ArrayList<>();

			int sum = 0;
			for (int i = 0; i < s; i++) {
				int cur = Integer.parseInt(st.nextToken()); 
				specimen.add(cur);
				sum += cur;
			}

			if(set != 1)
				out.println();

			double avg = sum / (c * 1.0);

			ArrayList<Integer> specimenout = new ArrayList<>(specimen);

			int news = s;
			
			while(news++ < 2 * c)
				specimenout.add(0);
			
			news--;
			
			Collections.sort(specimenout);
			
//			System.out.println(news);
//			System.out.println(specimenout);

			double IM = 0;
			
			out.printf("Set #%d\n", set++);

			int count = 0;
			
			for (int i = 0; i < s; i++) {
				if(specimen.get(i) == -1) continue;
				out.printf(" %d:", count++);
				
				int key = specimen.get(i);
				int index = 0;
				for (int j = 0; j < specimenout.size(); j++) {
					if(specimenout.get(j) == key){
						index = j;
						break;
					}
				}
				
				int index2 = news - index - 1;
				
				int reset = 0;
				key = specimenout.get(index2);
				for (int j = i + 1; j < specimen.size(); j++) {
					if(specimen.get(j) == key){
						reset = j;
						break;
					}
				}
				
				if(specimenout.get(index) != 0)
					out.print(" " + specimenout.get(index));
				if(specimenout.get(index2) != 0)
					out.print(" " + specimenout.get(index2));

				out.print("\n");
				
				IM += Math.abs(avg - (specimenout.get(index) + specimenout.get(index2)));
				
				specimenout.set(index, -1);
				specimenout.set(index2, -1);
				specimen.set(reset, -1);
				specimen.set(i, -1);
			}

			while(count != c){
				out.printf(" %d:\n", count++);
				
				IM += avg;
			}
			
			out.printf("IMBALANCE = %.5f\n", IM);
		}

		out.println();
		out.flush();
		out.close();
	}
}


