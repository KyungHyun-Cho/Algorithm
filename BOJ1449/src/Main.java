import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int cnt = 0;
			int[][] arr = new int[m][2];
			boolean[] isGiven = new boolean[n+1];
			
			for(int i = 0; i < m; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();				
			}
			Arrays.sort(arr, new Comparator<int[]>() {
	            @Override
	            public int compare(int[] o1, int[] o2) {
	            	if(o1[1] == o2[1]) {
	            		return (o1[0] - o2[0]);
	            	}else {
	            		return (o1[1] - o2[1]);
	            	}
	            }
	        });
			for(int i = 0; i < arr.length; i++) {

				for(int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println("");
			}
			for(int i = 0; i < m; i++) {
				for(int j = arr[i][0]; j <= arr[i][1]; j++) {
					if(!isGiven[j]) {
						isGiven[j] = true;
						System.out.println(j);
						cnt++;
						break;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
