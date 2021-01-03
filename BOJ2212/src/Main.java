import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1. �Է��� �޴´�.
		int n = sc.nextInt(); // ������ ����
		int k = sc.nextInt(); // ���߱��� ����
		//2. ���� ���߱� ����(k) >= ���� ����(n)�̸�, 0�� ����ϰ� �����Ѵ�.
		if(k >= n) {
			System.out.println(0);
			return;
		}
		int sum = 0;
		
		//1. �Է��� �޴´�
		int[] sensorArr = new int[n];
		for(int i = 0; i < n; i++)
			sensorArr[i] = sc.nextInt();
		
		//3. ������ �Ÿ��� ������������ �����Ѵ�. (������� ��ġ)
		Arrays.sort(sensorArr);
		
		//4. �� ���� �Ÿ��� ���̸� ���� �迭�� �����.
		Integer[] diffArr = new Integer[n-1];
		for(int i = 0; i < n-1; i++)
			diffArr[i] = sensorArr[i+1] - sensorArr[i];
		
		//5. ���� �迭�� ������������ �����Ѵ�.
		Arrays.sort(diffArr, Collections.reverseOrder());
		
		//6. ���� �迭�� k-1 ~ ������ ������ ���� ����Ѵ�.
		for(int i = k-1; i < n-1; i++) {
			sum += diffArr[i];
		}
		System.out.println(sum);
	}
}
