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
		n = sc.nextInt(); // ���� ũ�� (n*n)
		m = sc.nextInt(); // �����Ͽ� ���� ���� ������ ����
		k = sc.nextInt(); // k���� ���� �� ��Ƴ��� ������ �� ���ϱ�
		
		A = new int[n][n];
		yb_map = new int[n][n];
		tree_map = new ArrayList[n][n];
		
		//tree_map ArrayList �ʱ�ȭ
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				tree_map[i][j] = new ArrayList<>();
		
		//��� �� 5�� �ʱ�ȭ
		for(int i = 0; i < n; i++)
			Arrays.fill(yb_map[i], 5);
		
		//A�迭 Input
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
						//�̹� ������� -> ���δ� ������� �̵�
						yb_map[i][j] += tree_map[i][j].get(k)/2;
						tree_map[i][j].remove(k);
					}else {
						//������ ����ִ� ��� -> üũ�� �ʿ���
						if(yb_map[i][j] >= tree_map[i][j].get(k)) {
							//����� ���� �� �ִ� ���
							yb_map[i][j] -= tree_map[i][j].get(k); // ���-
							tree_map[i][j].set(k, tree_map[i][j].get(k)+1); // ���� +1
						}else {
							//����� �� �Դ� ���
							isPass = true; // �ٷ� �������� �Ѿ�Բ�
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
				//S2D2�� ��� �߰�
				yb_map[i][j] += A[i][j];
				for(int k = 0; k < tree_map[i][j].size(); k++) {
					if(tree_map[i][j].get(k) % 5 == 0) {
						//5������ ������ �������ٸ�
						for(int l = 0; l < 8; l++) {
							//8���� ����!
							int new_x = i + dir[l][0];
							int new_y = j + dir[l][1];
							if(new_x >= 0 && new_x < n && new_y >= 0 && new_y < n) {
								//�����ϴ� ��ǥ�� �� �ȿ� �ִٸ�
								tree_map[new_x][new_y].add(1); // 1���� ���� �߰�
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
