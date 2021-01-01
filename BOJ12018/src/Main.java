import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // ���� ��
		int m = sc.nextInt(); // �־��� ���ϸ���
		int[] minArr = new int[n]; //�� ���񺰷� ������û �ϱ����� �ʿ��� �ּ� ���ϸ��� ���
		
		for(int i = 0; i < n; i++) {
			int p = sc.nextInt(); // ���� ��û�� ��� ��
			int l = sc.nextInt(); // ����� �����ο�
			Integer[] mList = new Integer[p]; // �̹� ��û�� ������� ���ϸ���, �������� ���� Integer[]����
			for(int j = 0; j < p; j++) {
				mList[j] = sc.nextInt();
			}
			//1. ���� ������ ��û�� �ο��� < �����ο� Then, 1���� ����Ʈ�� ����
			if(p < l) {
				minArr[i] = 1;
				continue;
			}else {
				//2. ���񸶴� �������� ����
				Arrays.sort(mList, Collections.reverseOrder());
				//2-1. �����ο�(l)��° �����ŭ�� ���ϸ����� ������ ������û�� ��. �ش� ���ϸ��� ����Ʈ�� �ֱ�
				minArr[i] = mList[l-1];
			}
		}
		
		//3. ����Ʈ�� �������� ����, 0��°���� ���ϸ����� �� < �־��� ���ϸ���(m) ���� ���� ���
		Arrays.sort(minArr);
		int cnt = 0; // ������û ������ ����
		int mSum = 0; // 0��°���� ���ϸ����� ��
		for(int i = 0; i < n; i++) {
			mSum += minArr[i];
			if(mSum > m) {
				break;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
