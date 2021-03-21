import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		int strSize = str.length();
		int bombSize = bomb.length();
		
		char[] chrArr = new char[strSize];
		int chrArrIdx = 0;
		for(int i = 0; i < strSize; i++) {
			char c = str.charAt(i);
			chrArr[chrArrIdx++] = c;

			if(chrArrIdx >= bombSize && c == bomb.charAt(bombSize-1) && chrArr[chrArrIdx-bombSize] == bomb.charAt(0) && isBomb(chrArr, bomb, chrArrIdx))
				chrArrIdx -= bombSize;
		}
		if(chrArrIdx == 0) {
			System.out.println("FRULA");
		}else {
			for(int i = 0; i < chrArrIdx; i++)
				sb.append(chrArr[i]);
			System.out.println(sb);
		}
		
	}
	public static boolean isBomb(char[] chrArr, String bomb, int chrArrIdx) {
		int size = bomb.length();
		for(int i = 0; i < size; i++) 
			if(chrArr[chrArrIdx-i-1] != bomb.charAt(size-i-1)) return false;		
		return true;
	}
}
