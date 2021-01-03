import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1. 입력을 받는다.
		int n = sc.nextInt(); // 센서의 갯수
		int k = sc.nextInt(); // 집중국의 갯수
		//2. 만약 집중국 갯수(k) >= 센서 갯수(n)이면, 0을 출력하고 종료한다.
		if(k >= n) {
			System.out.println(0);
			return;
		}
		int sum = 0;
		
		//1. 입력을 받는다
		int[] sensorArr = new int[n];
		for(int i = 0; i < n; i++)
			sensorArr[i] = sc.nextInt();
		
		//3. 센서의 거리를 오름차순으로 정렬한다. (순서대로 배치)
		Arrays.sort(sensorArr);
		
		//4. 각 센서 거리의 차이를 담은 배열을 만든다.
		Integer[] diffArr = new Integer[n-1];
		for(int i = 0; i < n-1; i++)
			diffArr[i] = sensorArr[i+1] - sensorArr[i];
		
		//5. 차이 배열을 내림차순으로 정렬한다.
		Arrays.sort(diffArr, Collections.reverseOrder());
		
		//6. 차이 배열의 k-1 ~ 마지막 까지의 합을 출력한다.
		for(int i = k-1; i < n-1; i++) {
			sum += diffArr[i];
		}
		System.out.println(sum);
	}
}
