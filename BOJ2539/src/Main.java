import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr = br.readLine().split(" ");
		int min = 0;
		int max = stoi(inputArr[0]);
		int len = stoi(inputArr[1]);
		
		int usable = stoi(br.readLine());
		int wrong = stoi(br.readLine());
		boolean[] map = new boolean[len+1];
		
		for(int i = 0; i < wrong; i++) {
			inputArr = br.readLine().split(" ");
			min = Math.max(min, stoi(inputArr[0]));
			map[stoi(inputArr[1])] = true; 
		}
		
		while(min < max) {
			int mid = (min+max) / 2;
			if(isPossible(map, usable, len, mid))
				max = mid;
			else
				min = mid+1;
		}
		System.out.println(min);
	}
	
	static boolean isPossible(boolean[] map, int usable, int len, int find) {
		int using = 0;
		for(int i = 1; i <= len;) {			
			if(map[i]) {
				i += find;
				if(++using > usable) return false;
			}else
				i++;
		}
		return true;
	}
	static int stoi(String str) {return Integer.parseInt(str.trim());}
}
