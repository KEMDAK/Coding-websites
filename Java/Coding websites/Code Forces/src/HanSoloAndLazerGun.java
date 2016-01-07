import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HanSoloAndLazerGun {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(s.nextToken());
		int x1 = Integer.parseInt(s.nextToken());
		int y1 = Integer.parseInt(s.nextToken());
		
		ArrayList<Point> arr = new ArrayList<>();
		int shots = 0;
		
		for (int i = 0; i < n; i++) {
			s = new StringTokenizer(in.readLine());
			
			int x2 = Integer.parseInt(s.nextToken());
			int y2 = Integer.parseInt(s.nextToken());
			
			boolean flag = false;
			
			for (Point point : arr) {
				int x3 = point.x;
				int y3 = point.y;
				
				int z = ((x2 - x1)*(y3 - y1));
				int w = ((x3 - x1)*(y2 - y1));
				
				if(z == w){
					flag = true;
					break;
				}
			}

			if(!flag){
				arr.add(new Point(x2, y2));
				shots++;
			}
		}

		System.out.println(shots);
	}
}
