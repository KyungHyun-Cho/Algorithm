import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = stoi(br.readLine());
		while(tc-->0) {
			int n = stoi(br.readLine());
			boolean r = false;
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			Deque<Integer> dq = new LinkedList<>();
			String arr = br.readLine();
			for(String input : arr.split(" "))
				pq.add(stoi(input));
			for(int i = 0; i < n; i++) {
				if(r) dq.addLast(pq.poll());
				else dq.addFirst(pq.poll());
				r = !r;
			}
			int diff = Math.abs(dq.peekFirst() - dq.peekLast());
			int tmp = dq.pollFirst();
			while(!dq.isEmpty()) {
				diff = Math.max(diff, Math.abs(tmp- dq.peekFirst()));
				tmp = dq.pollFirst();
			}
			System.out.println(diff);
		}
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
