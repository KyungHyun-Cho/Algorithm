import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0; // 정답, 동준이가 점수를 내린 횟수
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt(); // 입력을 받음
		for(int i = n-2; i >= 0; i--) {
			// n = 4일 경우, 배열의 index는 0, 1, 2, 3이 존재함.
			// 2번과 3번, 1번과 2번, 0번과 1번을 비교하고자 n-2부터 시작하여 0번까지 반복
			if(arr[i] >= arr[i+1]) { // 낮은 레벨의 점수가 높은 레벨보다 크거나 같은 경우
				int diff = arr[i] - arr[i+1] + 1; //n번째 수가 n+1보다 1만큼 작게 하기 위한 차이
				ans += diff;
				arr[i] -= diff;
			}
		}
		System.out.println(ans);
	}
}
