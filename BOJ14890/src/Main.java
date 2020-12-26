import java.util.*;
public class Main {
	static int n, l;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		l = sc.nextInt();
		map = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				map[i][j] = sc.nextInt();
		
		int ans = 0;
		for(int i = 0; i < n; i++) {
			int[] tmp_arr = new int[n];
			for(int j = 0; j < n; j++)
				tmp_arr[j] = map[i][j];
			if(isPossible(tmp_arr)) ans++;
			
			for(int j = 0; j < n; j++)
				tmp_arr[j] = map[j][i];
			if(isPossible(tmp_arr)) ans++;			
		}
		System.out.println(ans);
	}
	public static boolean isPossible(int[] arr) {
		boolean[] visit = new boolean[n];
		for(int i = 0; i < n-1; i++) {
			//2칸 이상 차이나는 경우 못감
			if(Math.abs(arr[i+1] - arr[i]) > 1) return false;
			//두 칸이 높이가 같으면, 지나감
			if(arr[i+1] == arr[i]) continue;
			
			ArrayList<Integer> h = new ArrayList<>();
			if(arr[i+1] - arr[i] == -1) {
				//내려가는 경우
				for(int j = i+1; j < i+l+1; j++) {
					//범위를 넘어가면 false
					if(j >= n) return false;
					//이미 경사로를 놓은곳이라면 false
					if(visit[j]) return false;
					h.add(arr[j]);
					visit[j] = true;
				}
			}else if(arr[i+1] - arr[i] == 1) {
				//올라가는 경우
				for(int j = i; j > i-l; j--) {
					//범위를 넘어가면 false
					if(j < 0) return false;
					//이미 경사로를 놓은곳이라면 false
					if(visit[j]) return false;
					//경사로를 놓을 수 있는 높이가 안맞다면 false
					h.add(arr[j]);
					visit[j] = true;
				}
			}
			int tmp = h.get(0);
			for(int j = 1; j < h.size(); j++)
				if(h.get(j) != tmp) return false;
		}
		return true;
	}

}
