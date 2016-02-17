import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class HeadJudgeHeadache_790 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = Integer.parseInt(in.readLine());
		in.readLine();
		while(T-- > 0){

			TreeMap<Integer, Team> map = new TreeMap<>();
			ArrayList<Team> teams = new ArrayList<>();
			ArrayList<Submission> submissions = new ArrayList<>();
			int numberOfTeams = 0;
			while(in.ready()){
				String submission = in.readLine();

				if(submission.isEmpty())
					break;

				StringTokenizer s = new StringTokenizer(submission);

				int number = Integer.parseInt(s.nextToken());
				int problem = s.nextToken().charAt(0) - 'A';
				String time = s.nextToken();
				char verdict = s.nextToken().charAt(0);

				submissions.add(new Submission(number, problem, time, verdict));
				numberOfTeams = Math.max(numberOfTeams, number);
			}

			for (int i = 1; i <= numberOfTeams; i++) {
				Team team = new Team(i);
				map.put(i, team);
				teams.add(team);
			}

			Collections.sort(submissions);
			for (int i = 0; i < submissions.size(); i++) {
				Submission submission = submissions.get(i);
				int number = submission.TeamNumber;
				int problem = submission.problem;
				String time = submission.time;
				char verdict = submission.verdict;

				Team team = map.get(number);

				if (verdict == 'N') {
					team.addPenelty(problem);
				} else {
					team.addTime(time, problem);
				} 
			}

			Collections.sort(teams);

			out.println("RANK TEAM PRO/SOLVED TIME");
			int rank = 1;
			int count = 0;
			if(numberOfTeams >= 1){
				int prevS = teams.get(0).solved;
				int prevT = teams.get(0).totalTime;
				for (Team team : teams) {
					if(team.solved != prevS || team.totalTime != prevT){
						rank += count;
						count = 1;
					}
					else
						count++;

					out.print(allign(rank) + " ");
					out.print(allign(team.number));

					if(team.solved != 0){
						out.print(" ");
						out.print(allign(team.solved) + "       ");
						out.print(allign(team.totalTime));
					}

					out.println();

					prevS = team.solved;
					prevT = team.totalTime;
				}
			}

			if(T > 0)
				out.println();
		}

		out.flush();
		out.close();
	}

	public static String allign(int num) {
		String res = num + "";
		while(res.length() < 4){
			res = " " + res;
		}

		return res;
	}

	private static class Submission implements Comparable<Submission>{
		int TeamNumber, problem;
		String time;
		char verdict;

		public Submission(int TeamNumber, int problem, String time, char verdict) {
			this.TeamNumber = TeamNumber;
			this.problem = problem;
			this.time = time;
			this.verdict = verdict;
		}

		@Override
		public int compareTo(Submission o) {
			StringTokenizer s = new StringTokenizer(time, ":");

			int thisTime = Integer.parseInt(s.nextToken()) * 60;
			thisTime += Integer.parseInt(s.nextToken());

			s = new StringTokenizer(o.time, ":");

			int oTime = Integer.parseInt(s.nextToken()) * 60;
			oTime += Integer.parseInt(s.nextToken());

			return thisTime - oTime;
		}
	}

	private static class Team implements Comparable<Team>{
		int number, solved, totalTime;
		boolean[] verdict;
		int[] penelty;

		public Team(int number) {
			this.number = number;
			this.solved = 0;
			this.totalTime = 0;
			this.verdict = new boolean[7];
			this.penelty = new int[7];
		}

		public void addTime(String time, int problem){
			if(!verdict[problem]){
				StringTokenizer s = new StringTokenizer(time, ":");

				int res = Integer.parseInt(s.nextToken()) * 60;
				res += Integer.parseInt(s.nextToken());
				res += penelty[problem];

				totalTime += res;
				solved++;
				verdict[problem] = true;
			}
		}

		public void addPenelty(int problem){
			if(!verdict[problem])
				penelty[problem] += 20;
		}

		@Override
		public int compareTo(Team o) {
			if(this.solved != o.solved)
				return o.solved - this.solved;
			if(this.totalTime != o.totalTime)
				return this.totalTime - o.totalTime;
			return this.number - o.number;
		}
	}
}
