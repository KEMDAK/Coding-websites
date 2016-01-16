import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class ICanGuessTheDataStructure_11995 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(in.ready()){
			int n = Integer.parseInt(in.readLine());

			Stack<Integer> s = new Stack<>();
			Queue<Integer> q = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(n, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
				
			});

			boolean stack = true;
			boolean queue = true;
			boolean priorityQueue = true;

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());

				int o = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());

				if(o == 1){
					s.push(num);
					q.add(num);
					pq.add(num);
				}
				else{
					if(stack){
						if(s.isEmpty() || s.peek() != num){
							stack = false;
						}
						else
							s.pop();
					}
					
					if(queue){
						if(q.isEmpty() || q.peek() != num){
							queue = false;
						}
						else
							q.poll();
					}
					
					if(priorityQueue){
						if(pq.isEmpty() || pq.peek() != num){
							priorityQueue = false;
						}
						else
							pq.poll();
					}
				}
			}
			
			if(!(stack || queue || priorityQueue)){
				out.println("impossible");
				continue;
			}
//			out.println("s: " + stack + " q: " + queue + " pq: " + priorityQueue);
			if(!((stack ^ queue ^ priorityQueue) && (!(stack && queue && priorityQueue)))){
				out.println("not sure");
				continue;
			}
			
			if(stack)
				out.println("stack");
			else if(queue)
				out.println("queue");
			else
				out.println("priority queue");
		}
		
		out.flush();
		out.close();
	}
}
