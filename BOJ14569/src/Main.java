import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		long[] subject = new long[n];
		for(int i = 0; i < n; i++) {
			String[] inputArr = br.readLine().split(" ");
			for(int j = 1; j <= stoi(inputArr[0]); j++) {
				subject[i] |= (1l << (stoi(inputArr[j]) - 1));
			}
		}
		int studentCnt = stoi(br.readLine());
		long[] student = new long[studentCnt];
		for(int i = 0; i < studentCnt; i++) {
			String[] inputArr = br.readLine().split(" ");
			for(int j = 1; j <= stoi(inputArr[0]); j++) {
				student[i] |= (1l << (stoi(inputArr[j]) - 1));
			}
		}
		
		for(int i = 0; i < studentCnt; i++) {
			int answer = 0;
			for(int j = 0; j < n; j++) {
				if((subject[j] & student[i]) == subject[j])
					answer++;
			}
			System.out.println(answer);
		}
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
