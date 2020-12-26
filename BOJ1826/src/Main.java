import java.util.*;
import java.lang.*;
import java.io.*;
class Point_dist implements Comparable<Point_dist>{
	int dist, fuel;
	Point_dist(int dist, int fuel){
		this.dist = dist;
		this.fuel = fuel;
	}
	public int compareTo(Point_dist o) {
		return dist - o.dist;
	}
}
class Point_fuel implements Comparable<Point_fuel>{
	int dist, fuel;
	Point_fuel(int dist, int fuel){
		this.dist = dist;
		this.fuel = fuel;
	}
	public int compareTo(Point_fuel o) {
		return o.fuel - fuel;
	}
}
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Point_dist> q_dist = new PriorityQueue<>();
		PriorityQueue<Point_fuel> q_fuel = new PriorityQueue<>();
		
		String[] str_arr;
		int n = stoi(br.readLine());
		
		for(int i = 0; i < n; i++) {
			str_arr = br.readLine().split(" ");
			int dist = stoi(str_arr[0]);
			int fuel = stoi(str_arr[1]);
			q_dist.add(new Point_dist(dist, fuel));
		}
		str_arr = br.readLine().split(" ");
		int remain_dist = stoi(str_arr[0]);
		int remain_fuel = stoi(str_arr[1]);
		int cnt = 0;
		while(remain_fuel < remain_dist) {
			while(!q_dist.isEmpty() && q_dist.peek().dist <= remain_fuel) {
				Point_dist tmp = q_dist.poll();
				q_fuel.add(new Point_fuel(tmp.dist, tmp.fuel));
			}
			if(q_fuel.isEmpty()) {
				System.out.println(-1);
				return;
			}
			Point_fuel tmp = q_fuel.poll();
			remain_fuel += tmp.fuel;
			//System.out.println(tmp.dist + "," + tmp.fuel);
			cnt++;
		}
		System.out.println(cnt);
		
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
