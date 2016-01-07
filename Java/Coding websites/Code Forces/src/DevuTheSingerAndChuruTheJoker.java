import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class DevuTheSingerAndChuruTheJoker {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(s.nextToken());
		int d = Integer.parseInt(s.nextToken());
		
		s = new StringTokenizer(in.readLine());
		
		int jokes = 0;
		
		for (int i = 0; i < n - 1; i++) {
			d -= Integer.parseInt(s.nextToken()) + 10;
			
			if(d < 0){
				System.out.println(-1);
				return;
			}
			
			jokes += 2;
		}
		
		int lastSong = Integer.parseInt(s.nextToken());
		
		if(lastSong <= d){
			d -= lastSong;
			jokes += d / 5;
			System.out.println(jokes);
		}
		else {
			System.out.println(-1);
		}
	}
}
