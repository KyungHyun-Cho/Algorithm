import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[][] arr = new String[n][2];
		for(int i = 0; i < n; i++) {
			arr[i][0] = sc.next();
			arr[i][1] = sc.next();			
		}
		Arrays.sort(arr, new Comparator<String[]>() {
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
		});
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}
}
