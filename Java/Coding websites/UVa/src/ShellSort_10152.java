import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ShellSort_10152 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
//		StringTokenizer s = new StringTokenizer(in.readLine());
		int t = in.nextInt();//Integer.parseInt(s.nextToken());
		
		while(t-- > 0){
//			s = new StringTokenizer(in.readLine());
			int n = in.nextInt();//Integer.parseInt(s.nextToken());
			in.nextLine();
			
			TreeMap<String, Integer> map = new TreeMap<>();
			Stack<Integer> temp = new Stack<>();
			String[] reverseMap = new String[n];
			for (int i = 0; i < n; i++) {
				temp.push(i);
				StringTokenizer s = new StringTokenizer(in.nextLine());//in.readLine());
				StringBuilder shell = new StringBuilder();
				while(s.hasMoreTokens())
					shell.append(s.nextToken() + " ");
				String name = (shell).toString();
//				System.out.println(name);
				map.put(name, i);
				reverseMap[i] = name;
			}
			Stack<Integer> given = new Stack<>();
			while(!temp.isEmpty())
				given.push(temp.pop());
			
			for (int i = 0; i < n; i++) {
				StringTokenizer s = new StringTokenizer(in.nextLine());//in.readLine());
				StringBuilder shell = new StringBuilder();
				while(s.hasMoreTokens())
					shell.append(s.nextToken() + " ");
				String name = (shell).toString();
//				System.out.println(name);
				int count = map.get(name);
				temp.push(count);
			}
			Stack<Integer> ordered = new Stack<>();
			while(!temp.isEmpty())
				ordered.push(temp.pop());
			
//			System.out.println(given);
//			System.out.println(ordered);
			
			Stack<Integer> tempG = clone(given);
			int count = 1;
			ArrayList<Integer> result = new ArrayList<>();
			while(!equal(tempG, ordered)){
				Stack<Integer> tempO = new Stack<>();
				tempG = clone(given);
				result = new ArrayList<>();
				
				for (int i = 0; i < count; i++) {
					result.add(ordered.peek());
					tempO.add(ordered.pop());
				}
				
				while(!tempO.isEmpty()){
					tempG = rotate(tempG, tempO.peek());
					ordered.push(tempO.pop());
				}
				
				count++;
			}
			
			for (int i = result.size() - 1; i >= 0; i--) {
				out.println(reverseMap[result.get(i)]);
			}
			out.println();
		}
		
		out.flush();
		out.close();
	}
	
	public static Stack<Integer> rotate(Stack<Integer> x, int i) {
		Stack<Integer> temp = new Stack<>();
		
		while(!x.isEmpty()){
			int poped = x.pop();
			if(poped == i)
				break;
			temp.push(poped);
		}
		
		while(!temp.isEmpty())
			x.push(temp.pop());
		
		x.push(i);
		
		return x;
	}

	public static boolean equal(Stack<Integer> x, Stack<Integer> y){
		Stack<Integer> temp= new Stack<>();
		
		boolean equal = true;
		while(!x.isEmpty()){
			if(x.peek() != y.peek()){
				equal = false;
				break;
			}
			
			temp.add(x.pop());
			y.pop();
		}
		
		while(!temp.isEmpty()){
			x.push(temp.peek());
			y.push(temp.pop());
		}
		
		return equal;
	}
	
	public static Stack<Integer> clone(Stack<Integer> x){
		Stack<Integer> temp = new Stack<>();
		Stack<Integer> res = new Stack<>();
		
		while(!x.isEmpty())
			temp.push(x.pop());
		
		while(!temp.isEmpty()){
			x.push(temp.peek());
			res.push(temp.pop());
		}
		
		return res;
	}
}
