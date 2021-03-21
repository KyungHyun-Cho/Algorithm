import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		//1. ArrayList<String> �迭�� ������.
		ArrayList<String>[] arr = new ArrayList[n+3];
		
		//2. ArrayList<String> �迭�� �ʱ�ȭ ������.
		for(int i = 0; i <= n+2; i++)
			arr[i] = new ArrayList<>();			
		
		//3. n=1, 2, 3�� ���� ������ ArrayList�� �־�����
		arr[1].add("1");
		arr[2].add("1+1");
		arr[2].add("2");
		arr[3].add("1+2");
		arr[3].add("1+1+1");
		arr[3].add("2+1");
		arr[3].add("3");
		
		//4. for i = 4 to n ���� ���鼭,
		for(int i = 4; i <= n; i++) {
			/* ArrayList[i-1]�� �ִ� ���Ŀ� +1��,
			   ArrayList[i-2]�� �ִ� ���Ŀ� +2��,
			   ArrayList[i-3]�� �ִ� ���Ŀ� +3�� �ٿ��ش�. */
			for(int j = 1; j <= 3; j++) {
				for(String op : arr[i-j]) {
					arr[i].add(op + "+" + j);
				}
			}
		}
		
		/*5. ArrayList[n]�� �ִ� list�� ������ k���� �۴ٸ� -1�� ���,
   		   	  �ƴ϶��, ArrayList[n]�� �����ϰ�, k��° item�� ����Ѵ�.*/
		if(arr[n].size() < k) {
			System.out.println(-1);
		}else {
			Collections.sort(arr[n]);
			System.out.println(arr[n].get(k-1));
		}
	}
}
