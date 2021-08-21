import java.util.*;
class Point{
	int x, y, cnt;
	Point(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
class Solution {
	public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int solution(int[][] maps) {
    	boolean[][] visit = new boolean[maps.length][maps.length];
    	Queue<Point> q = new LinkedList<>();
    	visit[0][0] = true;
    	q.add(new Point(0, 0, 1));
    	while(!q.isEmpty()) {
    		Point p = q.poll();
    		int now_x = p.x;
    		int now_y = p.y;
    		if(now_x == maps.length-1 && now_y == maps.length-1)
    			return p.cnt;
    		for(int i = 0; i < 4; i++) {
    			int new_x = now_x + dir[i][0];
    			int new_y = now_y + dir[i][1];
    			if(new_x < 0 || new_y < 0 || new_x >= maps.length || new_y >= maps.length) continue;
    			if(maps[new_x][new_y] == 0) continue;
    			if(!visit[new_x][new_y]) {
    				visit[new_x][new_y] = true;
    				q.add(new Point(new_x, new_y, p.cnt+1));
    			}    			
    		}
    	}
        return -1;
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
    	System.out.println(solution.solution(maps));
    }
}