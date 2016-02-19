import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Polyline {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer s = new StringTokenizer(in.readLine());
		Point p1 = new Point(Integer.parseInt(s.nextToken()), Integer.parseInt(s.nextToken()));
		s = new StringTokenizer(in.readLine());
		Point p2 = new Point(Integer.parseInt(s.nextToken()), Integer.parseInt(s.nextToken()));
		s = new StringTokenizer(in.readLine());
		Point p3 = new Point(Integer.parseInt(s.nextToken()), Integer.parseInt(s.nextToken()));

		TreeSet<Integer> x = new TreeSet<>();
		TreeSet<Integer> y = new TreeSet<>();

		boolean bp12 = false;
		boolean bp23 = false;
		boolean bp13 = false;

		if((p1.x == p2.x && p2.x == p3.x) || (p1.y == p2.y && p2.y == p3.y))
			

		out.flush();
		out.close();
	}
}
