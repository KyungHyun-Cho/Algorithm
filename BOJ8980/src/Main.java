import java.io.*;
import java.util.*;
class Info implements Comparable<Info>{
	int start, end, w;
	Info(int start, int end, int w){
		this.start = start;
		this.end = end;
		this.w = w;
	}
	public int compareTo(Info o) {
		if(o.end == this.end)
			return this.start - o.start;
		else
			return this.end - o.end;
	}
	
}
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = stoi(st.nextToken());
		int c = stoi(st.nextToken());
		int m = stoi(br.readLine());
		int sum = 0;
		PriorityQueue<Info> pq = new PriorityQueue<>();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int p = stoi(st.nextToken());
			int q = stoi(st.nextToken());
			int w = stoi(st.nextToken());			
			pq.add(new Info(p, q, w));
		}
		int[] available = new int[n];
		Arrays.fill(available, c);
		while(!pq.isEmpty()) {
			Info info = pq.poll();
			int start = info.start;
			int end = info.end;
			int w = info.w;
			int min = Integer.MAX_VALUE;
			for(int i = start; i < end; i++) {
				min = Math.min(min, available[i]);
			}
			if(min < w) {
				sum += min;
				for(int i = start; i < end; i++)
					available[i] -= min;
			}else {
				sum += w;
				for(int i = start; i < end; i++)
					available[i] -= w;
			}
		}
		System.out.println(sum);

	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
