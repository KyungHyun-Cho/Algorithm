import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0; // ����, �����̰� ������ ���� Ƚ��
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt(); // �Է��� ����
		for(int i = n-2; i >= 0; i--) {
			// n = 4�� ���, �迭�� index�� 0, 1, 2, 3�� ������.
			// 2���� 3��, 1���� 2��, 0���� 1���� ���ϰ��� n-2���� �����Ͽ� 0������ �ݺ�
			if(arr[i] >= arr[i+1]) { // ���� ������ ������ ���� �������� ũ�ų� ���� ���
				int diff = arr[i] - arr[i+1] + 1; //n��° ���� n+1���� 1��ŭ �۰� �ϱ� ���� ����
				ans += diff;
				arr[i] -= diff;
			}
		}
		System.out.println(ans);
	}
}
