import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point { // point class to simulate the stopping points
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Point p) {
		return this.x == p.x && this.y == p.y;
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}

public class ChasingAfterDonGiovanni_10961 {

	public static void main(String[] args) throws IOException,
			NumberFormatException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer s = new StringTokenizer(in.readLine());
		int t = Integer.parseInt(s.nextToken());

		while (t-- > 0) {
			in.readLine();

			StringTokenizer st = new StringTokenizer(in.readLine());
			Point villagersInit = new Point(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())); // initial point of the
														// villagers

			st = new StringTokenizer(in.readLine());
			Point leporelloInit = new Point(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())); // initial point of the
														// leporello

			st = new StringTokenizer(in.readLine());
			int leporelloStops = Integer.parseInt(st.nextToken()); // leporello
																	// stops

			ArrayList<Point> leporelloPath = new ArrayList<>();
			for (int i = 0; i < leporelloStops; i++) { // reading the stops of
														// leporello one by one
				st = new StringTokenizer(in.readLine());
				Point leporelloCurrent = new Point(Integer.parseInt(st
						.nextToken()), Integer.parseInt(st.nextToken()));
				leporelloPath.addAll(travelRoute(leporelloInit,
						leporelloCurrent)); // resolving each stop into the
											// moves that lead to it ex. from
											// (2, 2) to (2, 4) will be resolved
											// to {(2, 2), (2, 3), (2, 4)}
											// then adding them to leporelloPath
				if (i != leporelloStops - 1) {
					leporelloPath.remove(leporelloPath.size() - 1);
				}

				leporelloInit = leporelloCurrent;
			}

			st = new StringTokenizer(in.readLine());
			int villagersStops = Integer.parseInt(st.nextToken());

			ArrayList<Point> villagersPath = new ArrayList<>();
			for (int i = 0; i < villagersStops; i++) { // reading the stops of
														// villagers one by one
				st = new StringTokenizer(in.readLine());
				Point villagersCurrent = new Point(Integer.parseInt(st
						.nextToken()), Integer.parseInt(st.nextToken()));
				villagersPath.addAll(travelRoute(villagersInit,
						villagersCurrent)); // resolving each stop into the
											// moves that lead to it ex. from
											// (2, 2) to (2, 4) will be resolved
											// to {(2, 2), (2, 3), (2, 4)}
											// then adding them to villagersPath
				if (i != villagersStops - 1) {
					villagersPath.remove(villagersPath.size() - 1);
				}

				villagersInit = villagersCurrent;
			}

			// System.out.println(leporelloPath);
			// System.out.println(villagersPath);

			if (isSafe(leporelloPath, villagersPath)) // if the road is safe i
														// print "Yes" otherwise
														// "No"
				System.out.println("Yes");
			else
				System.out.println("No");
			if (t > 0)
				System.out.println();
		}
	}

	public static boolean isSafe(ArrayList<Point> leporelloPath,
			ArrayList<Point> villagersPath) { // method that compares the two
												// paths 1:1 and returns false
												// if they meet at any point
		if (leporelloPath.size() <= villagersPath.size()) {
			for (int i = 0; i < leporelloPath.size() - 1; i++) { // in case the
																	// villagers
																	// meet
																	// leporello
																	// anywhere
																	// else
																	// before
																	// accomplishing
																	// his
																	// mission
				if (leporelloPath.get(i).equals(villagersPath.get(i)))
					return false;
			}
			return true;
		}
		if (villagersPath.size() < leporelloPath.size()) { // in case the
															// villagers stopped
															// and leporello
															// came to them (idk
															// if it is
															// required)
			int i;
			for (i = 0; i < villagersPath.size(); i++) {
				if (villagersPath.get(i).equals(leporelloPath.get(i)))
					return false;
			}
			return pathContinue(villagersPath.get(i - 1), i, leporelloPath);
		}

		return false; // unreachable statement
	}

	public static boolean pathContinue(Point point, int i, ArrayList<Point> path) { // method
																					// to
																					// see
																					// if
																					// leporello
																					// will
																					// meet
																					// the
																					// villagers
																					// after
																					// they
																					// stop
																					// (again
																					// idk
																					// if
																					// it
																					// is
																					// required
																					// :D)

		for (; i < path.size() - 1; i++) {
			if (path.get(i).equals(point))
				return false;
		}
		return true;
	}

	public static ArrayList<Point> travelRoute(Point init, Point dist) { // method
																			// to
																			// resolve
																			// the
																			// way
																			// between
																			// two
																			// points

		ArrayList<Point> res = new ArrayList<>();
		if (init.x == dist.x) { // horizontal : init.x == dist.x
			if (init.y > dist.y) { // left
				for (int i = init.y; i >= dist.y; i--)
					res.add(new Point(init.x, i));
			} else { // right
				for (int i = init.y; i <= dist.y; i++)
					res.add(new Point(init.x, i));
			}
		} else { // vertical : init.y == dist.y
			if (init.x > dist.x) { // up
				for (int i = init.x; i >= dist.x; i--)
					res.add(new Point(i, init.y));
			} else { // down
				for (int i = init.x; i <= dist.x; i++)
					res.add(new Point(i, init.y));
			}
		}

		return res;
	}
}
