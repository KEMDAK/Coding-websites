
public class Test {

	
	public static void main(String[] args) {
		int x = 888;
		int y = 9;
		
		x ^= y;
		y ^= x;
		x ^= y;
		
		System.out.println("x = " + x + " y = " + y);
	}
}
