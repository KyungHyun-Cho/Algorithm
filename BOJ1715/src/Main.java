import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		long ans = 0;
		int n = stoi(br.readLine());
		while(n--> 0) {
			pq.add(stoi(br.readLine()));
		}
		
		while(pq.size() > 1) {
			int tmp = (pq.poll() + pq.poll());
			ans += tmp;
			pq.add(tmp);
		}
		System.out.println(ans);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
