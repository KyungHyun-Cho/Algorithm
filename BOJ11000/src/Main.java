import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		int[][] arr = new int[n][2];
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");	
			arr[i][0] = stoi(input[0]);
			arr[i][1] = stoi(input[1]);
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(arr[0][1]);
		
		for(int i = 1; i < n; i++) {
			if(pq.peek() <= arr[i][0]) pq.poll();
			pq.add(arr[i][1]);
		}
		
		System.out.println(pq.size());
		br.close();
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}