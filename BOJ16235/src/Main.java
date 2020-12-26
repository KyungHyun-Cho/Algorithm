import java.util.*;
class Land{
	//int yb, 
}
public class Main {
	static int n,m,k;
	static ArrayList<Integer>[][] tree_map;
	static int[][] yb_map;
	static int[][] A;
	static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 땅의 크기 (n*n)
		m = sc.nextInt(); // 구매하여 땅에 심은 나무의 갯수
		k = sc.nextInt(); // k년이 지난 후 살아남은 나무의 수 구하기
		
		A = new int[n][n];
		yb_map = new int[n][n];
		tree_map = new ArrayList[n][n];
		
		//tree_map ArrayList 초기화
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				tree_map[i][j] = new ArrayList<>();
		
		//양분 맵 5로 초기화
		for(int i = 0; i < n; i++)
			Arrays.fill(yb_map[i], 5);
		
		//A배열 Input
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		//tree_map Input
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			tree_map[x][y].add(sc.nextInt());
		}
		
		for(int i = 0; i < k; i++) {
			SS();
			FW();
		}
		System.out.println(getCnt());
	}
	public static void SS() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				Collections.sort(tree_map[i][j], Collections.reverseOrder());
				boolean isPass = false;
				for(int k = tree_map[i][j].size()-1; k >= 0; k--) {
					if(isPass) {
						//이미 죽은경우 -> 전부다 양분으로 이동
						yb_map[i][j] += tree_map[i][j].get(k)/2;
						tree_map[i][j].remove(k);
					}else {
						//아직은 살아있는 경우 -> 체크가 필요함
						if(yb_map[i][j] >= tree_map[i][j].get(k)) {
							//양분을 먹일 수 있는 경우
							yb_map[i][j] -= tree_map[i][j].get(k); // 양분-
							tree_map[i][j].set(k, tree_map[i][j].get(k)+1); // 나이 +1
						}else {
							//양분을 못 먹는 경우
							isPass = true; // 바로 다음으로 넘어가게끔
							yb_map[i][j] += tree_map[i][j].get(k)/2;
							tree_map[i][j].remove(k);
						}
					}
				}
			}
		}
	}
	public static void FW() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				//S2D2의 양분 추가
				yb_map[i][j] += A[i][j];
				for(int k = 0; k < tree_map[i][j].size(); k++) {
					if(tree_map[i][j].get(k) % 5 == 0) {
						//5년으로 나누어 떨어진다면
						for(int l = 0; l < 8; l++) {
							//8방향 번식!
							int new_x = i + dir[l][0];
							int new_y = j + dir[l][1];
							if(new_x >= 0 && new_x < n && new_y >= 0 && new_y < n) {
								//번식하는 좌표가 땅 안에 있다면
								tree_map[new_x][new_y].add(1); // 1살인 나무 추가
							}							
						}
					}
				}
			}
		}
	}
	public static int getCnt() {
		int ret = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				ret += tree_map[i][j].size();
			}
		}
		return ret;
	}
}
