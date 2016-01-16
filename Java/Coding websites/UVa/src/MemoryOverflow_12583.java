import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class MemoryOverflow_12583 {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int t = Integer.parseInt(in.readLine());

		for(int l = 1; l <= t; l++){
			StringTokenizer s = new StringTokenizer(in.readLine());

			int n = Integer.parseInt(s.nextToken());
			int k = Integer.parseInt(s.nextToken());

			String st = s.nextToken();

			TreeMap<Character, Integer> memory = new TreeMap<>();

			int c = 0;

			for (int i = 0; i < n; i++) {
				char cur = st.charAt(i);

				if(memory.containsKey(cur))
					c++;

				ArrayList<Character> toRemove = new ArrayList<>();
				for (Character ch : memory.keySet()) {
					int value = memory.get(ch);
					if(value == 1)
						toRemove.add(ch);
					else
						memory.put(ch, value - 1);
				}
				
				for (Character character : toRemove) {
					memory.remove(character);
				}

				memory.put(cur, k);
			}
			
			out.printf("Case %d: %d\n" , l, c);
		}
		
		out.flush();
		out.close();
	}
}
