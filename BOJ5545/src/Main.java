import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 토핑의 갯수
		
		// 토핑의 칼로리 리스트, 내림차순 정렬을 위해 int[]가 아닌 래퍼 클래스인 Integer[]로 선언했다.
		Integer[] topKCal = new Integer[n]; 
		
		int doughPrice = sc.nextInt(); // 도우의 가격
		int topPrice = sc.nextInt(); // 토핑의 가격
		int doughKCal = sc.nextInt(); // 도우의 칼로리
		for(int i = 0; i < n; i++) 
			topKCal[i] = sc.nextInt();
		
		int ans = doughKCal / doughPrice; // 토핑을 0개 넣은 경우, 도우의 칼로리당 가격이다.
		
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
