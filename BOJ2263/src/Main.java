import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	static int[] postree, intree;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        postree = new int[n];
        intree = new int[n + 1];
        
        for (int i = 0; i < n; i++)
            intree[sc.nextInt()] = i;        
        
        for (int i = 0; i < n; i++)
            postree[i] = sc.nextInt();
        
        order(0, n-1, 0, n-1);     
	}
	public static void order(int is, int ie, int ps, int pe) {
		if(is > ie || ps > pe) return;
		int root = postree[pe];
		System.out.print(root + " ");
		int mid = intree[root];
		int left = mid-is;
		order(is, mid-1, ps, ps+left-1);
		order(mid+1, ie, ps+left, pe-1);
		
	}
}
