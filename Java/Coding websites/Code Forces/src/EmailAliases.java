import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class EmailAliases {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int n = Integer.parseInt(in.readLine());

		ArrayList<ArrayList<String>> res = new ArrayList<>();
		TreeMap<String, Integer> map = new TreeMap<>();
		int index = 0;

		while(n-- > 0){
			String mail = in.readLine();
			StringTokenizer s = new StringTokenizer(mail, "@");

			String login = s.nextToken();
			String domain = s.nextToken();

			StringBuilder nLogin = new StringBuilder();;

			if(!domain.equalsIgnoreCase("bmail.com")){
				nLogin.append(login);
			}
			else{
				for (int i = 0; i < login.length(); i++) {
					char c = login.charAt(i);
					if(c != '.'){
						if(c == '+')
							break;

						nLogin.append(Character.toLowerCase(c));
					}
				}
			}

			Integer r = map.get(nLogin.toString().toLowerCase() + "@" + domain.toLowerCase());

			if(r == null){
				ArrayList<String> temp = new ArrayList<>();
				temp.add(mail);
				res.add(temp);
				map.put(nLogin.toString().toLowerCase() + "@" + domain.toLowerCase(), index++);
			}
			else {
				res.get(r).add(mail);
			}
		}

		out.println(res.size());

		for (int i = 0; i < res.size(); i++) {
			ArrayList<String> arr = res.get(i);
			out.print(arr.size());

			for (String st : arr) 
				out.print(" " + st);

			out.println();
		}

		out.flush();
		out.close();
	}
}
