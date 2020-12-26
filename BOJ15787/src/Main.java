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
			/*  1 i x : i��° ������(1 �� i �� N) x��° �¼���(1 �� x �� 20) ����� �¿���. �̹� ����� Ÿ�ִٸ� , �ƹ��� �ൿ�� ���� �ʴ´�.
			 *	2 i x : i��° ������ x��° �¼��� ���� ����� �����Ѵ�. ���� �ƹ��� ���ڸ��� �ɾ����� �ʾҴٸ�, �ƹ��� �ൿ�� ���� �ʴ´�.
			 *	3 i : i��° ������ �ɾ��ִ� �°����� ��� ��ĭ�� �ڷΰ���. k��° ���� ����� k+1��°�� �̵��Ͽ� �ɴ´�. ���� 20��° �ڸ��� ����� �ɾ��־��ٸ� �� ����� �� ��� �Ŀ� �����Ѵ�.
			 *	4 i : i��° ������ �ɾ��ִ� �°����� ��� ��ĭ�� �����ΰ���. k��° ���� ����� k-1 ��° �ڸ��� �̵��Ͽ� �ɴ´�. ���� 1��° �ڸ��� ����� �ɾ��־��ٸ� �� ����� �� ��� �Ŀ� �����Ѵ�.*/
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
					//��� �������, �� �ȵǴ� �����
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
