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
			//2ĭ �̻� ���̳��� ��� ����
			if(Math.abs(arr[i+1] - arr[i]) > 1) return false;
			//�� ĭ�� ���̰� ������, ������
			if(arr[i+1] == arr[i]) continue;
			
			ArrayList<Integer> h = new ArrayList<>();
			if(arr[i+1] - arr[i] == -1) {
				//�������� ���
				for(int j = i+1; j < i+l+1; j++) {
					//������ �Ѿ�� false
					if(j >= n) return false;
					//�̹� ���θ� �������̶�� false
					if(visit[j]) return false;
					h.add(arr[j]);
					visit[j] = true;
				}
			}else if(arr[i+1] - arr[i] == 1) {
				//�ö󰡴� ���
				for(int j = i; j > i-l; j--) {
					//������ �Ѿ�� false
					if(j < 0) return false;
					//�̹� ���θ� �������̶�� false
					if(visit[j]) return false;
					//���θ� ���� �� �ִ� ���̰� �ȸ´ٸ� false
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
