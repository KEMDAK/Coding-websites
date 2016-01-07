import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindingTeamMember {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
	
		int[] team = new int[n * 2];
		
		int[] strength = new int[n * 2];
		
		for (int i = 2; i - 2 < n * 2 - 1; i++) {
			StringTokenizer s = new StringTokenizer(in.readLine());
			
			for (int j = 1; s.hasMoreTokens(); j++) {
				int st = Integer.parseInt(s.nextToken());
				if(strength[i - 1] < st && strength[j - 1] < st){
					if(team[j - 1] != 0)
						strength[team[j - 1] - 1] = 0;
					if(team[i - 1] != 0)
						strength[team[i - 1] - 1] = 0;
					team[i - 1] = j;
					team[j - 1] = i;
					strength[i - 1] = st;
					strength[j - 1] = st;
				}
			}
		}
		
		for (int i = 0; i < team.length; i++) {
			System.out.print(team[i] + " ");
		}
		
	}
}

