import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Containers_1062 {


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int T = 1;

		while(true){
			String s = in.readLine();

			if(s.equals("end"))
				break;

			ArrayList<Integer> stacks = new ArrayList<Integer>();
			boolean[] hasStack = new boolean[26];

			for(int i = 0; i < s.length(); i++)
			{
				int c = s.charAt(i) - 'A';
				if(!hasStack[c])
				{
					hasStack[c] = true;
					int min = 100, idx = -1;
					for(int j = 0; j < stacks.size(); j++)
					{
						int b = stacks.get(j);
						if(c <= b && b - c < min)
						{
							min = c -b;
							idx = j;
						}
					}
					if(idx==-1)
						stacks.add(c);
					else
					{
						hasStack[stacks.get(idx)]  =false;
						stacks.set(idx, c);
					}
				}
			}
			

			out.printf("Case %d: %d\n", T++, stacks.size());
		}

		out.flush();
		out.close();
	}
}
