import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];
		String now_str = "";
		for(int i = 0; i < n; i++)
			arr[i] = sc.next();
		Arrays.sort(arr);
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
			
		});
		for(int i = 0; i < n; i++) {
			if(!now_str.equals(arr[i])) {
				System.out.println(arr[i]);
				now_str = arr[i];
			}
		}
		sc.close();
	}
}