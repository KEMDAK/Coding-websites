import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class VasyaAndWrestling {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		long w1S = 0;
		long w2S = 0;
		
		ArrayList<Integer> w1 = new ArrayList<>();
		ArrayList<Integer> w2 = new ArrayList<>();
		
		int lastMove = 0;
		
		while(n-- > 0){
			int num = Integer.parseInt(in.readLine());
			
			if(num > 0){
				w1S += num;
				w1.add(num);
			}
			else{
				w2S += (num * -1);
				w2.add((num * -1));
			}
			
			lastMove = num;
		}
		
		if(w1S > w2S)
			System.out.println("first");
		else if(w2S > w1S)
			System.out.println("second");
		else{
			int size = Math.min(w1.size(), w2.size());
			
			for (int i = 0; i < size; i++) {
				if(w1.get(i) > w2.get(i)){
					System.out.println("first");
					return;
				}
				else if(w1.get(i) < w2.get(i)){
					System.out.println("second");
					return;
				}
			}
			
			if(w1.size() > w2.size())
				System.out.println("first");
			else if(w2.size() > w1.size())
				System.out.println("second");
			else if(lastMove > 0)
				System.out.println("first");
			else
				System.out.println("second");
		}
	}
}
