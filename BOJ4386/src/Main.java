import java.util.*;
import java.io.*;
class Point implements Comparable<Point>{
	int s, e;
	double cost;
	Point(int s, int e, double cost){
		this.s = s;
		this.e = e;
		this.cost = cost;
	}
	public int compareTo(Point o) {
		return Double.compare(this.cost, o.cost);
	}
}
class Pair{
	double x, y;
	Pair(double x, double y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		HashMap<Integer, Pair> pairPerNode = new HashMap<Integer, Pair>();
		int n = stoi(br.readLine());
		boolean[] visit = new boolean[n];
		for(int i = 0; i < n; i++) {
			String[] inputArr = br.readLine().split(" ");
			pairPerNode.put(i, new Pair(stod(inputArr[0]), stod(inputArr[1])));
		}
		
		double answer = 0;
		pq.add(new Point(0, 0, 0));
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			if(visit[p.e]) continue;
			visit[p.e] = true;			
			answer += p.cost;
			for(int i = 0; i < n; i++) {
				if(!visit[i] && p.e != i)
					pq.add(new Point(p.e, i, GetDistance(pairPerNode.get(p.e).x, pairPerNode.get(p.e).y, pairPerNode.get(i).x, pairPerNode.get(i).y)));
			}
		}
		System.out.println(String.format("%.2f", answer));
		
	}
	static double GetDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
	}
	static int stoi(String str) {return Integer.parseInt(str);}
	static double stod(String str) {return Double.parseDouble(str);}
	
}
