import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class TwoChar {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());

		TreeMap<String, Integer> map = new TreeMap<>();

		ArrayList<char2> list = new ArrayList<>();


		int ind = 0;

		for (int i = 0; i < n; i++) {
			String s = in.readLine();

			int occ[] = new int[26];
			for (int j = 0; j < s.length(); j++){
				occ[s.charAt(j) - 'a']++;
			}

			char c1, c2;
			c1 = c2 = '*';

			boolean valid = true;

			int length = 0;

			for (int j = 0; j < occ.length; j++) {
				if(occ[j] != 0){
					if(c1 == '*'){
						c1 = (char) (j + 'a');
						length += occ[j];
					}
					else if(c2 == '*'){
						c2 = (char) (j + 'a');
						length += occ[j];
					}
					else{
						valid = false;
						break;
					}
				}
			}

			if(valid){
				Integer index = map.get("" + c1 + c2);

				if(index == null){
					list.add(new char2("" + c1 + c2, length));
					map.put("" + c1 + c2, ind++);
				}
				else{
					list.get(index).len += length; 
				}
			}
		}

		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).comb.charAt(1) == '*'){
				for (int j = 0; j < list.size(); j++) {
					if(list.get(j).comb.contains("" + list.get(i).comb.charAt(0)) && j != i){
						list.get(j).len += list.get(i).len;
					}
				}
			}
		}

		Collections.sort(list);

		System.out.println(list);
		System.out.println(list.get(0).comb);
		if(list.size() == 0){
			System.out.println(0);
			return;
		}
		
		if(list.get(0).comb.charAt(1) != '*'){
			System.out.println(list.get(0).len);
		}
		else{
			if(list.size() >= 2 && list.get(1).comb.charAt(1) == '*' )
				System.out.println(list.get(0).len + list.get(1).len);
			else
				System.out.println(list.get(0).len);
		}
	} 
}

class char2 implements Comparable<char2>{
	String comb;
	int len;

	public char2(String comb, int len) {
		this.comb = comb; 
		this.len = len;
	}

	@Override
	public int compareTo(char2 o) {
		return o.len - len;
	}

	@Override
	public String toString() {
		return comb + " " + len;
	}

}
