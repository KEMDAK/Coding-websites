import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Argus_1203 {


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		PriorityQueue<Instruction> pq = new PriorityQueue<>();
		
		while(true){
			String s = in.readLine();
			
			StringTokenizer st = new StringTokenizer(s);
			
			if(st.nextToken().equals("#"))
				break;
			
			int num = Integer.parseInt(st.nextToken());
			int period = Integer.parseInt(st.nextToken());
			
			pq.add(new Instruction(num, period, period));
		}
		
		int k = Integer.parseInt(in.readLine());
		
		while(k-- > 0 && !pq.isEmpty()){
			Instruction i = pq.poll();
			out.println(i.num);
			i.time = i.time + i.period;
			pq.add(i);
		}
		
		out.flush();
		out.close();
	}

	private static class Instruction implements Comparable<Instruction>{
		int num, period, time;

		public Instruction(int num, int period, int time) {
			this.num = num;
			this.period = period;
			this.time = time;
		}

		@Override
		public int compareTo(Instruction o) {
			if(this.time != o.time)
				return this.time - o.time;
			return this.num - o.num;
		}
		
		@Override
		public String toString() {
			return "(" + num + ", " + period + ", " + time + ")";
		}
	}
}
