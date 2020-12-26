import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] require_set = new int[n];
		if(k < 5) {System.out.println(0);sc.close();return;}
		if(k == 26) {System.out.println(n);sc.close();return;}
		k -= 5;
		for(int i = 0; i < n; i++) {
			String tmp = sc.next().replace("a", "").replace("n","").replace("t","").replace("i","").replace("c","");
			for(int j = 0; j < tmp.length(); j++) {
				int char_num = tmp.charAt(j)-'a';
				require_set[i] |= (1 << char_num);
			}
		}
		
		int max = 0;
		for(int i = 0; i < (1 << 26);i++) {
			if(Integer.bitCount(i) != k) continue;
			int tmp=0;
			for(int j = 0; j < n; j++) {
				//if(require_set[j] == 0) {available_cnt++; continue;}
				if(Integer.bitCount(require_set[j]) > k) continue;
				if((i & require_set[j]) == require_set[j])
					tmp++;
				if(tmp > max) {
					max = tmp;
				}
			}
		}
		System.out.println(max);
		sc.close();
	}
}
