import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // ������ ����
		
		// ������ Į�θ� ����Ʈ, �������� ������ ���� int[]�� �ƴ� ���� Ŭ������ Integer[]�� �����ߴ�.
		Integer[] topKCal = new Integer[n]; 
		
		int doughPrice = sc.nextInt(); // ������ ����
		int topPrice = sc.nextInt(); // ������ ����
		int doughKCal = sc.nextInt(); // ������ Į�θ�
		for(int i = 0; i < n; i++) 
			topKCal[i] = sc.nextInt();
		
		int ans = doughKCal / doughPrice; // ������ 0�� ���� ���, ������ Į�θ��� �����̴�.
		
		Arrays.sort(topKCal, Collections.reverseOrder());
		
		int tmpPrice = doughPrice;
		int tmpKCal = doughKCal;
		for(int i = 0; i < n; i++) {
			tmpPrice += topPrice;
			tmpKCal += topKCal[i];
			int tmpAns =  tmpKCal / tmpPrice;
			if(ans > tmpAns) {
				break;
			}else {
				ans = tmpAns;
			}
		}
		System.out.println(ans);
	}
}
