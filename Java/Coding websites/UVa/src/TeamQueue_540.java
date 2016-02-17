import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TeamQueue_540 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int test = 1;
		
		while(true){
			int t = Integer.parseInt(in.readLine());
			
			if(t == 0)
				break;
			
			TeamQueue tq = new TeamQueue(t);
			
			for (int i = 0; i < t; i++) {
				StringTokenizer s = new StringTokenizer(in.readLine());
				
				int n = Integer.parseInt(s.nextToken());
				
				for (int j = 0; j < n; j++) {
					tq.assignTeam(Integer.parseInt(s.nextToken()), i);
				}
			}
			
			out.println("Scenario #" + test++);
			
			while(true){
				StringTokenizer s = new StringTokenizer(in.readLine());
				
				String operation = s.nextToken();
				if(operation.charAt(0) == 'E'){
					tq.enqueue(Integer.parseInt(s.nextToken()));
				}
				else if(operation.charAt(0) == 'D'){
					int element = tq.dequeue();
					if(element != -1)
						out.println(element);
				}
				else
					break;
			}
			out.println();
		}
		
		out.flush();
		out.close();
	}
	
	private static class TeamQueue{
		TreeMap<Integer, Integer> teams;
		ArrayList<Integer>[] teamMembers;
		ArrayList<Integer> order;
		
		public TeamQueue(int t) {
			teams = new TreeMap<>();
			teamMembers = new ArrayList[t];
			for (int i = 0; i < t; i++)
				teamMembers[i] = new ArrayList<>();
			order = new ArrayList<>();
		}
		
		public void assignTeam(int member, int teamNumber){
			teams.put(member, teamNumber);
		}
		
		public void enqueue(int x){
			int teamNumber = teams.get(x);
			if(teamMembers[teamNumber].isEmpty())
				order.add(teamNumber);
			
			teamMembers[teamNumber].add(x);
		}
		
		public int dequeue(){
			if(order.isEmpty())
				return -1;
			
			int teamNumber = order.get(0);

			int teamMember = teamMembers[teamNumber].remove(0);
			
			if(teamMembers[teamNumber].isEmpty())
				order.remove(0);
			
			return teamMember;
		}
	}
}
