import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Genes_939 {

	static TreeMap<String, Integer> status;
	static TreeMap<String, ArrayList<String>> parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int N = Integer.parseInt(in.readLine());

		TreeMap<String, Integer> sMap = new TreeMap<>();
		TreeSet<String> set = new TreeSet<>();
		sMap.put("non-existent", 0);
		sMap.put("recessive", 1);
		sMap.put("dominant", 2);

		String[] type = {"non-existent", "recessive", "dominant"};

		status = new TreeMap<>();
		parent = new TreeMap<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer s = new StringTokenizer(in.readLine());
			String name = s.nextToken();
			String childOrGene = s.nextToken();

			set.add(name);

			if(childOrGene.equals("non-existent") || childOrGene.equals("recessive") || childOrGene.equals("dominant")){
				status.put(name, sMap.get(childOrGene));
			}
			else{
				set.add(childOrGene);
				ArrayList<String> parents = parent.get(childOrGene);

				if(parents == null)
					parents = new ArrayList<>();

				parents.add(name);
				parent.put(childOrGene, parents);
			}
		}

		for (String name : set) {
			out.printf("%s %s\n", name, type[getStatus(name)]);
		}

		out.flush();
		out.close();
	}

	public static int getStatus(String name) {
		Integer res = status.get(name);

		if(res == null){
			ArrayList<String> parents = parent.get(name);
			int p1 = getStatus(parents.get(0));
			int p2 = getStatus(parents.get(1));

			//			System.out.println(name + " " + parents + "(" + p1 + ", " + p2 + ")");
			res = type(p1, p2);

		}

		status.put(name, res);
		return res;
	}

	public static int type(int p1, int p2){
		int res = 0;
		if((p1 > 0 && p2 > 0) || p1 == 2 || p2 == 2)
			res = 1;
		if((p1 == 2 && p2 == 2) || (p1 == 2 && p2 == 1) || (p1 == 1 && p2 == 2))
			res = 2;

		return res;
	}
}
