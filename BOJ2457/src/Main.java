import java.util.*;
import java.io.*;
public class Main {
	static int[] dayPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static int[] daySumPerMonth = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
	static final int sDate = 60, eDate = 334;	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		int[][] map = new int[n][2];
		for(int i = 0; i < n; i++) {
			String[] inputArr = br.readLine().split(" ");
			int sm = stoi(inputArr[0]);
			int sd = stoi(inputArr[1]);
			int em = stoi(inputArr[2]);
			int ed = stoi(inputArr[3]);
			map[i][0] = convertDate(sm, sd);
			map[i][1] = convertDate(em, ed)-1;
		}
		
		Arrays.sort(map, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o2[1] - o1[1];				
				return o1[0] - o2[0];
			}			
		});
		
		if(map[0][0] > sDate) {
			System.out.println(0);
			return;
		}else if(map[0][1] >= eDate) {
			System.out.println(1);
			return;
		}
		
		int flowerCnt = 1;
		int nowMax = 59;
		int tmpMax = 59;
		
		for(int i = 0; i < n; i++) {			
			if(map[i][0] <= nowMax + 1 && map[i][1] > tmpMax) {
				tmpMax = map[i][1];
			}else if(map[i][0] > nowMax && map[i][0] <= tmpMax + 1) {
				flowerCnt++;
				nowMax = tmpMax;
				tmpMax = Math.max(tmpMax, map[i][1]);
			}else if(map[i][0] > nowMax && map[i][0] > tmpMax) {
				System.out.println(0);
				return;
			}
			if(tmpMax >= eDate) break;
		}
		
		if(tmpMax >= eDate)
			System.out.println(flowerCnt);
		else
			System.out.println(0);
	}
	static int convertDate(int m, int d) {
		return daySumPerMonth[m] + d;
	}
	static int stoi(String str) {return Integer.parseInt(str);}
}