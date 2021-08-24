import java.io.*;
import java.util.*;
class Info implements Comparable<Info>{
	Info(int x, int y, double cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	int x, y;
	double cost;
	@Override
	public int compareTo(Info o) {
		return Double.compare(this.cost, o.cost);
	}
}
public class Main {
	static HashMap<Integer, HashSet<Integer>> map;
	static HashMap<Integer, HashMap<Integer, Double>> cost;
	static HashMap<Integer, HashMap<Integer, Boolean>> visit;
	static int n, f;
	static double answer = 987654321.0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr = br.readLine().split(" ");
		final double INF = 987654321.0;
		n = stoi(inputArr[0]);
		f = stoi(inputArr[1]);
		map = new HashMap<>();
		cost = new HashMap<>();
		visit = new HashMap<>();
		
		map.put(0, new HashSet<Integer>());
		cost.put(0, new HashMap<Integer, Double>());
		cost.get(0).put(0, 0.0);
		visit.put(0, new HashMap<Integer, Boolean>());
		visit.get(0).put(0, true);
		
		for(int i = 0; i < n; i++) {
			inputArr = br.readLine().split(" ");
			int a = stoi(inputArr[0]);
			int b = stoi(inputArr[1]);
			if(!map.containsKey(a)) map.put(a, new HashSet<Integer>());
			if(!cost.containsKey(a)) cost.put(a, new HashMap<Integer, Double>());
			if(!cost.get(a).containsKey(b)) cost.get(a).put(b, INF);
			if(!visit.containsKey(a)) visit.put(a, new HashMap<Integer, Boolean>());
			if(!visit.get(a).containsKey(b)) visit.get(a).put(b, false);
			map.get(a).add(b);
		}
		BFS();
		if(answer == INF)
			System.out.println(-1);
		else
			System.out.println(Math.round(answer));
	}
	
	public static void BFS() {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(0, 0, 0.0));
		while(!pq.isEmpty()) {
			Info info = pq.poll();
			int x = info.x;
			int y = info.y;
			visit.get(x).put(y, true);
			for(int i = -2; i <= 2; i++) {
				int new_x = x + i;
				if(!map.containsKey(new_x)) continue;
				for(int j = -2; j <= 2; j++) {
					int new_y = y + j;
					if(i == 0 && j == 0) continue;
					if(!map.get(new_x).contains(new_y)) continue;
					if(visit.get(new_x).get(new_y)) continue;
					if(cost.get(new_x).get(new_y) > info.cost + GetDist(x, y, new_x, new_y)) {
						cost.get(new_x).put(new_y, info.cost + GetDist(x, y, new_x, new_y));
						pq.add(new Info(new_x, new_y, cost.get(new_x).get(new_y)));
						if(new_y == f)
							answer = Math.min(answer,  cost.get(new_x).get(new_y));
					}
				}
			}
		}
	}
	public static double GetDist(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); 
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
