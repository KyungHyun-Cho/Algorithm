import java.util.*;
class Point{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int map_sum = 0;
	static int v1 = 0, v2 = 0;
	static int[][] map = new int[10][10];
	static int[] remain = {5, 5, 5, 5, 5};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++) {
				map[i][j] = sc.nextInt();
				map_sum += map[i][j];
			}
		Stack<Integer> st = new Stack<>();
		DFS(st, 0, 0, 0);
		System.out.println(v1 + ", " + v2);
	}
	public static void DFS(Stack<Integer> st, int cnt, int sum, int depth) {
		if(depth == 5) {
			v2++;
			if(sum == map_sum) {
				if(process(map, st))
					System.out.println("OK!");
				v1++;

				for(int tmp : st) {
					System.out.print(tmp + " ");
				}
				
				System.out.println("(" + cnt + ")");
			}
			
		}else {
			for(int i = 0; i <= 5; i++){
				st.add(i);
				sum += (depth+1) * (depth+1) * i;
				cnt += i;
				DFS(st, cnt, sum, depth + 1);
				st.pop();
				cnt -= i;
				sum -= (depth+1) * (depth+1) * i;
			}
		}
	}
	public static boolean process(int[][] map, Stack<Integer> st) {
		int[][] tmp_map = new int[10][10];
		
		for(int i = st.size()-1; i >= 0; i--) {
			if(st.get(i) == 0) continue;
			ArrayList<Point> arrList = new ArrayList<>();
			getList(arrList, map, i+1);
			if(st.get(i) <= arrList.size()) {
				Stack<Integer> tmp_st = new Stack<>();
				int tmp = st.pop();
				for(int t : st)
					tmp_st.push(t);
				tmp_st.push(tmp-1);
				st.push(tmp);
				for(Point p : arrList) {
					copyMap(map, tmp_map);
					for(int j = 0; j < i+1; j++) {
						for(int k = 0; k < i+1; k++) {
							tmp_map[p.x+j][p.y+k] = 0;
						}	
					}
					if(process(tmp_map, tmp_st)) return true;
				}
			}else {
				//ºÒ°¡´É
				return false;
			}
		}
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++)
				if(map[i][j] != 0) return false;
		return true;
	}
	public static void copyMap(int[][] src, int[][] dest) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				dest[i][j] = src[i][j];
			}
		}
	}
	public static void getList(ArrayList<Point> arrList,int[][] map,  int n) {
		for(int i = 0; i < 11-n; i++) {
			for(int j = 0; j < 11-n; j++) {
				boolean ret = true;
				for(int k = i; k < i+n; k++) {
					for(int l = j; l < j+n; l++) {
						if(map[k][l] == 0) {
							ret = false;
							break;
						}
					}
					if(!ret) break;
				}
				if(ret)
					arrList.add(new Point(i, j));
			}
		}
	}
	public static boolean isPossible(int[][] map, int n) {
		for(int i = 0; i < 11-n; i++) {
			for(int j = 0; j < 11-n; i++) {
				boolean ret = true;
				for(int k = i; k < n; k++) {
					for(int l = j; l < n; l++) {
						if(map[k][l] == 0) {
							ret = false;
							break;
						}
					}
					if(!ret) break;
				}
				if(ret) return true;
			}
		}
		return false;
	}
}
