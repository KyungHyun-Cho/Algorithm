import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		int len = arr.length;
		int s = 0, e = len-1, answer = len;
		if(!isP(arr)) {
			System.out.println(len);			
		}else {
			boolean isSame = true;
			for(int i = 0; i < len-1; i++) {
				if(arr[i] != arr[i+1]) {
					isSame = false;
					break;
				}
			}
			if(isSame) System.out.println(-1);
			else System.out.println(len-1);
		}
		
		
	}
	public static boolean isP(char[] arr) {
		int s = 0, e = arr.length-1;		
		while(s <= e) {
			if(arr[s++] != arr[e--])
				return false;
		}
		return true;
			
	}
}
