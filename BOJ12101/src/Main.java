import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		//1. ArrayList<String> 배열을 만들자.
		ArrayList<String>[] arr = new ArrayList[n+3];
		
		//2. ArrayList<String> 배열을 초기화 해주자.
		for(int i = 0; i <= n+2; i++)
			arr[i] = new ArrayList<>();			
		
		//3. n=1, 2, 3일 때에 수식을 ArrayList에 넣어주자
		arr[1].add("1");
		arr[2].add("1+1");
		arr[2].add("2");
		arr[3].add("1+2");
		arr[3].add("1+1+1");
		arr[3].add("2+1");
		arr[3].add("3");
		
		//4. for i = 4 to n 까지 돌면서,
		for(int i = 4; i <= n; i++) {
			/* ArrayList[i-1]에 있는 수식에 +1을,
			   ArrayList[i-2]에 있는 수식에 +2을,
			   ArrayList[i-3]에 있는 수식에 +3을 붙여준다. */
			for(int j = 1; j <= 3; j++) {
				for(String op : arr[i-j]) {
					arr[i].add(op + "+" + j);
				}
			}
		}
		
		/*5. ArrayList[n]에 있는 list의 갯수가 k보다 작다면 -1을 출력,
   		   	  아니라면, ArrayList[n]을 정렬하고, k번째 item을 출력한다.*/
		if(arr[n].size() < k) {
			System.out.println(-1);
		}else {
			Collections.sort(arr[n]);
			System.out.println(arr[n].get(k-1));
		}
	}
}
