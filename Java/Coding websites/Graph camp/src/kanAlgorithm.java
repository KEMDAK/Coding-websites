import java.io.BufferedReader;
import java.io.InputStreamReader;

public class kanAlgorithm {

	static int[] parents;
	
	public static void main(String[] args) {
		
		//calculate the number of parents for each node by looping over the edges
		
		//initialize a queue and enqueue all nodes with zero parents
		//then start dequeuing them one by one print it then decrease all its children in the parent by one if it is zero then enqueue it
		//loop until the queue is empty
		//to get the least lexicographical order just change the queue to P queue;
		//after finishing if all of the parent array are zeros then this sorting is valid otherwise thereis no topological sorting
	}
}
