import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str_arr;
		str_arr = br.readLine().split(" ");
		int n = stoi(str_arr[0]);
		int m = stoi(str_arr[1]);
		int[] train = new int[n+1];
		for(int t = 0; t < m; t++) {
			/*  1 i x : i번째 기차에(1 ≤ i ≤ N) x번째 좌석에(1 ≤ x ≤ 20) 사람을 태워라. 이미 사람이 타있다면 , 아무런 행동을 하지 않는다.
			 *	2 i x : i번째 기차에 x번째 좌석에 앉은 사람은 하차한다. 만약 아무도 그자리에 앉아있지 않았다면, 아무런 행동을 하지 않는다.
			 *	3 i : i번째 기차에 앉아있는 승객들이 모두 한칸씩 뒤로간다. k번째 앉은 사람은 k+1번째로 이동하여 앉는다. 만약 20번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.
			 *	4 i : i번째 기차에 앉아있는 승객들이 모두 한칸씩 앞으로간다. k번째 앉은 사람은 k-1 번째 자리로 이동하여 앉는다. 만약 1번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.*/
			str_arr = br.readLine().split(" ");
			int op, i, x = 0;
			op = stoi(str_arr[0]);
			i = stoi(str_arr[1]);
			if(op <= 2) x = stoi(str_arr[2])-1;
			
			if(op == 1) {
				train[i] |= (1 << x);
			}else if(op == 2) {
				train[i] &= ~(1 << x);				
			}else if(op == 3) {
				train[i] <<= 1;
				train[i] &= ~(1 << 20);
			}else if(op == 4) {
				train[i] >>= 1;
			}  
		}
		ArrayList<Integer> status = new ArrayList<Integer>();
		status.add(train[1]);
		for(int i = 2; i <= n; i++) {
			boolean isBreak = false;
			for(int j = 0; j < status.size(); j++) {
				if(status.get(j) == train[i]) {
					//모두 같은경우, 즉 안되는 경우임
					isBreak = true;
					break;
				}
			}
			if(!isBreak) status.add(train[i]);
		}
		System.out.println(status.size());
		br.close();
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
