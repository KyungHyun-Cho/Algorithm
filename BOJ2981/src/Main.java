import java.util.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		TreeSet<Integer> ansList = new TreeSet<Integer>();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for(int i = 1; i < n; i++)
				dq.addLast(arr[i]-arr[i-1]);
		int gcd = arr[1]-arr[0];
		for(int i = 2; i < n; i++)
			gcd = GCD2(gcd, arr[i]-arr[i-1]);
		//int gcd = GCD(dq, 0);
		//gcd = 1000000000;
		for(int i = 2; i*i <= gcd; i++) {
			if(gcd % i == 0) {
				//나누어 떨어지면
				ansList.add(i);
			}
			if(gcd % (gcd / i) == 0) {
				ansList.add(gcd / i);
			}
		}
		ansList.add(gcd);
		ArrayList<Integer> tmp = new ArrayList<Integer>(ansList);
		for(int i = 0; i < tmp.size(); i++)
			System.out.print(tmp.get(i) + " ");
	}
	public static int GCD2(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
	public static int GCD(ArrayDeque<Integer> dq, int offset) {
		if(dq.size() == 0) return -1;
		int a = dq.pollFirst();
		a = a-offset;
		int b;
		if(dq.size() == 1) {
			b = dq.pollFirst();
			b = b-offset;
		}else {
			b = GCD(dq, offset);
		}
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
		//여기에는 진행 하고 리턴시키기
	}
}
