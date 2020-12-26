import java.util.*;
import java.lang.*;
class Point{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int n, m, min = Integer.MAX_VALUE;
	static ArrayList<Point> chicken = new ArrayList<>();
	static ArrayList<Point> houses = new ArrayList<>();
	static Stack<Point> st = new Stack<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int tmp = sc.nextInt();
				if(tmp == 1) houses.add(new Point(i, j));
				else if(tmp == 2) chicken.add(new Point(i, j));				
			}
		}
		
		for(int i = m; i >= 1; i--) {
			comb(0,0,i);
		}
		System.out.println(min);
	}
	public static void comb(int start, int depth, int target) {
		if(depth == target) {
			min = Math.min(min, getMin());
			return;
		}
		
		for(int i = start; i < chicken.size(); i++) {
			st.push(chicken.get(i));
			comb(i+1, depth + 1, target);
			st.pop();
		}
	}
	
	public static int getMin() {
		int sum = 0;
		for(Point house : houses) {
			int temp = Integer.MAX_VALUE;
			for(int i = 0; i < st.size(); i++) {
				temp = Math.min(temp, getDist(house, st.get(i)));
			}
			sum += temp;
		}
		return sum;
	}
	
	public static int getDist(Point a, Point b) {
		return Math.abs(a.x-b.x) + Math.abs(a.y - b.y);
	}
}
