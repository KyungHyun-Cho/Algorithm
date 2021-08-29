import java.util.*;
import java.io.*;
class Info implements Comparable<Info>{
	int origin, current, addCnt;
	Info(int origin){
		this.origin = origin;
		current = origin;
		addCnt = 0;
	}
	public Info add() {
		addCnt++;
		current = (int)Math.ceil(origin / (double)(addCnt + 1));
		return this;
	}
	@Override
	public int compareTo(Info o) {
		return o.current - this.current;
	}
}
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr = br.readLine().split(" ");
		int n = stoi(inputArr[0]);
		int m = stoi(inputArr[1]);
		int l = stoi(inputArr[2]);
		/*if(n == 0) {
			System.out.println((int)Math.ceil(l / m));
			return;
		}*/
		inputArr = br.readLine().split(" ");
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = stoi(inputArr[i]);
		Arrays.sort(arr);
		PriorityQueue<Info> pq = new PriorityQueue<>();
		for(int i = 0; i < n-1; i++) {
			pq.add(new Info(arr[i+1] - arr[i]));
		}
		if(arr[0] != 0) pq.add(new Info(arr[0]));
		if(n > 0 && arr[n-1] != l) pq.add(new Info(l-arr[n-1]));
		while(m-->0) {
			pq.add(pq.poll().add());
		}
		int answer = 0;
		while(!pq.isEmpty()) {
			Info info = pq.poll();
			answer = Math.max(answer, info.current);
		}
		System.out.println(answer);
	}
	static int stoi(String str) {return Integer.parseInt(str);}
}
