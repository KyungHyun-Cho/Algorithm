import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		int[][] map = new int[n][2];
		for(int i = 0; i < n; i++) {
			String[] inputArr = br.readLine().split(" ");
			map[i][0] = stoi(inputArr[1]);
			map[i][1] = stoi(inputArr[2]);		
		}
		Arrays.sort(map, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o2[0] == o1[0]) return o1[1] - o2[1]; 
				return o1[0] - o2[0];
			}			
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(map[0][1]);
		for(int i = 1; i < n; i++) {
			if(pq.peek() <= map[i][0])
				pq.poll();
			pq.add(map[i][1]);

		}
		System.out.println(pq.size());
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
