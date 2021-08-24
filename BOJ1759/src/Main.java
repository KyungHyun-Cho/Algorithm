import java.io.*;
import java.util.*;
public class Main {
	static int l, c;
	static char[] charArr;
	static StringBuilder answer = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr = br.readLine().split(" ");
		l = stoi(inputArr[0]);
		c = stoi(inputArr[1]);
		
		charArr = new char[c];
		String input = br.readLine();
		for(int i = 0; i < c; i++)
			charArr[i] = input.charAt(i*2);
		Arrays.sort(charArr);
		
		DFS(new StringBuilder(), 0, 0);
		System.out.println(answer);
	}
	public static void DFS(StringBuilder sb, int fillIdx, int arrIdx) {
		if(fillIdx == l) {
			boolean hasM = false;
			int jCnt = 0;
			for(int i = 0; i < l; i++) {
				char c = sb.toString().charAt(i);
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					hasM = true;
				}else
					jCnt++;
			}
			if(hasM && jCnt >= 2)
				answer.append(sb.toString()).append('\n');
		}else {
			for(int i = arrIdx; i < c; i++) {
				sb.append(charArr[i]);
				DFS(sb, fillIdx + 1, i+1);
				sb.deleteCharAt(sb.toString().length()-1);
			}
		}
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
