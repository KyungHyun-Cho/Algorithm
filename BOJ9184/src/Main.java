import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("success_output.txt")));
		
		StringBuilder sb = new StringBuilder();
		//1. 3차원 배열을 선언한다.
		//2. 각 인덱스는 a,b,c의 값이다.
		//3. 인덱스는 음수를 취할 수 없으므로, 입력값과 수식에 각각 50씩 더해줌으로써 양수로 만든다.
		int[][][] map = new int[21][21][21];
		
		for(int i = 0; i <= 20; i++) 
			for(int j = 0; j <= 20; j++)
				for(int k = 0; k <= 20; k++) {
					if(i == 0 || j == 0 || k == 0) {
						map[i][j][k] = 1;
					}else if(i < j && j < k) {
						map[i][j][k] = map[i][j][k-1] + map[i][j-1][k-1] - map[i][j-1][k];
					}else {
						map[i][j][k] = map[i-1][j][k] + map[i-1][j-1][k] + map[i-1][j][k-1] - map[i-1][j-1][k-1];		
					}				
				}
		for(int i = 0; i <= 20; i++) 
			for(int j = 0; j <= 20; j++)
				for(int k = 0; k <= 20; k++) {
					if(i == 20 && j == 20 && k == 20) {
						bw.write(sb.toString());
						bw.flush();
						bw.close();
						return;
					}else if(i <= 0 || j <= 0 || k <= 0) {
						sb.append(String.format("w(%d, %d, %d) = 1\n", i, j, k));
					}else {
						sb.append(String.format("w(%d, %d, %d) = %d\n", i, j, k, map[i][j][k]));
					}
		}
		
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
