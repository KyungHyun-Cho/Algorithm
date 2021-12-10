import java.util.*;
import java.io.*;
class Point{
	int x, y, cnt;
	Point(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// Input
		String[] inputArr = br.readLine().split(" ");
		int n = stoi(inputArr[0]);
		int t = stoi(inputArr[1]);
		HashSet<Integer>[] map = new HashSet[t+1];
		
		// Init
		int maxY = 0;
		for(int i = 0; i < n; i++) {
			inputArr = br.readLine().split(" ");
			int x = stoi(inputArr[0]);
			int y = stoi(inputArr[1]);
			maxY = Math.max(maxY, y);
			
			if(map[y] == null) map[y] = new HashSet<>();			
			map[y].add(x);
		}
		
		// Impossible Condition
		if(maxY != t) {
			System.out.println(-1);
			return;
		}

		// BFS
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(0, 0, 0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.y == t) {
				System.out.println(p.cnt);
				return;
			}else {
				for(int newY = p.y - 2; newY <= p.y+2; newY++) {
					if(newY < 0 || newY > t || map[newY] == null) continue;
					for(int newX = p.x - 2; newX <= p.x+2; newX++) {
						if(newX < 0 || newX > 1_000_000) continue;
						// 존재하면서, 방문을 안했다면
						if(map[newY].contains(newX)) {
							map[newY].remove(newX); // 방문처리
							q.add(new Point(newX, newY, p.cnt + 1));
						}
					}
				}
			}
		}
		System.out.println(-1);
	}
	static int stoi(String str) {return Integer.parseInt(str);}
}
