import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class FileFragmentation_10132 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int T = Integer.parseInt(in.readLine());
		in.readLine();
		
		while(T-- > 0){
			ArrayList<String> fragments = new ArrayList<>();
			int N = 0;
			int B = 0;
			
			while(in.ready()){
				String line = in.readLine();
				
				if(line.isEmpty())
					break;

				B += line.length();
				N++;
				
				fragments.add(line);
			}
			
			TreeMap<String, Integer> map = new TreeMap<>();
			
			for (int i = 0; i < fragments.size(); i++) {
				for (int j = 0; j < fragments.size(); j++) {
					if(i == j)
						continue;
					
					if(fragments.get(i).length() + fragments.get(j).length() == (B / (N / 2))){
						String newLine = fragments.get(i) + fragments.get(j);

						Integer value = map.get(newLine);
						
						if(value == null){
							map.put(newLine, 0);
						}
						else{
							map.put(newLine, value + 1);
						}
					}
				}
			}
			
			String max = "";
			int maxF = 0;
			
			for (Entry<String, Integer> entry : map.entrySet()) {
				if(entry.getValue() > maxF){
					maxF = entry.getValue();
					max = entry.getKey();
				}
			}
			
			out.println(max);
			
			if(T > 0)
				out.println();
		}
		
		out.flush();
		out.close();
	}
}
