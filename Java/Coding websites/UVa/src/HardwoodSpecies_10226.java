import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class HardwoodSpecies_10226 {


	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = in.nextInt();
		in.nextLine();
		
		while(t-- > 0){
			
			TreeSet<String>	set = new TreeSet<>();
			TreeMap<String, Integer> map = new TreeMap<>();

			int c = 0;
			
			while(in.Ready()){
				String s = in.nextLine();
				
				if(s.isEmpty())
					break;
				
				Integer value = map.get(s);
				if(value == null)
					value = 0;
				
				map.put(s, value + 1);
				set.add(s);
				
				c++;
			}
			
			for (String name : set) {
				double res = (map.get(name) / (c * 1.0)) * 100;
				out.printf("%s %.4f\n", name, res);
			}
			
			if(t > 0)
				out.println();
		}
		
		out.flush();
		out.close();
	}


	private static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner(FileReader f) {
			br = new BufferedReader(f);
		}

		public Scanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}

		public String Next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(Next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(Next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(Next());
		}

		public boolean Ready() throws IOException {
			return br.ready();
		}

		public void waitForInput(long time) {
			long ct = System.currentTimeMillis();
			while(System.currentTimeMillis() - ct < time) {};
		}

	}

}
