import java.io.*;
import java.util.*;

class Point{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = stoi(br.readLine());
		HashMap<Character, String> hashSet = new HashMap<>();
		hashSet.put(' ', "00000");
		hashSet.put('A', "00001");
		hashSet.put('B', "00010");
		hashSet.put('C', "00011");
		hashSet.put('D', "00100");
		hashSet.put('E', "00101");
		hashSet.put('F', "00110");
		hashSet.put('G', "00111");
		hashSet.put('H', "01000");
		hashSet.put('I', "01001");
		hashSet.put('J', "01010");
		hashSet.put('K', "01011");
		hashSet.put('L', "01100");
		hashSet.put('M', "01101");
		hashSet.put('N', "01110");
		hashSet.put('O', "01111");
		hashSet.put('P', "10000");
		hashSet.put('Q', "10001");
		hashSet.put('R', "10010");
		hashSet.put('S', "10011");
		hashSet.put('T', "10100");
		hashSet.put('U', "10101");
		hashSet.put('V', "10110");
		hashSet.put('W', "10111");
		hashSet.put('X', "11000");
		hashSet.put('Y', "11001");
		hashSet.put('Z', "11010");
		
		StringBuilder sb = new StringBuilder();
		while(tc-- > 0) {
			String inputStr = br.readLine();
			String[] inputArr = inputStr.split(" ");
			int R = stoi(inputArr[0]);
			int C = stoi(inputArr[1]);
			String str = inputStr.substring(Integer.toString(R).length() + Integer.toString(C).length() + 2);
			
			int[][] arr = new int[R][C];
			int posX = 0, posY = -1;
			int nowDir = 0;
			for(int i = 0; i < str.length(); i++) {
				for(int j = 0; j < 5; j++) {
					nowDir %= 4;
					int newX = posX + dir[nowDir][0];
					int newY = posY + dir[nowDir][1];
					if((newX >= R || newY >= C || newX < 0 || newY < 0) || arr[newX][newY] != 0) {
						nowDir = (nowDir + 1) % 4;
						newX = posX + dir[nowDir][0];
						newY = posY + dir[nowDir][1];
					}
					arr[newX][newY] = hashSet.get(str.charAt(i)).charAt(j) - '0';
					if(arr[newX][newY] == 0) arr[newX][newY] = -1;
					posX = newX; posY = newY;
				}
			}
			
			for(int i = 0; i < R; i++)
				for(int j = 0; j < C; j++)
					sb.append(arr[i][j] == -1 ? 0 : arr[i][j]);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
