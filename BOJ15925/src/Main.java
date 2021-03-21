import java.io.*;
import java.util.*;
class Info{
	int line, num; // 0: 가로, 1: 세로
	Info(int line, int num){
		this.line = line;
		this.num = num;
	}
}
public class Main {
	public static Stack<Info> possibleMap = new Stack<>();
	public static int[][] map;
	public static boolean[][] stateMap;
	public static int obj = 0, n = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		obj = stoi(st.nextToken());
		map = new int[n][n];
		stateMap = new boolean[2][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				map[i][j] = stoi(st.nextToken());
		}
		while(getPossibleMap()) {
			while(!possibleMap.isEmpty()) {
				Info info = possibleMap.pop();
				setMap(info);
			}
		}
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < n; j++) {
				if(!stateMap[i][j]) {
					System.out.println("0");
					return;
				}
			}
		}
		System.out.println("1");
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
	public static void setMap(Info info) {
		for(int i = 0; i < n; i++) {
			if(info.line == 0) {
				map[info.num][i] = obj;
			}else {
				map[i][info.num] = obj;
			}
		}
	}
	public static boolean isPossibleLine(int line, int l) {
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			if(line == 0) {
				if(map[l][i] == obj) cnt++;
			}else {
				if(map[i][l] == obj) cnt++;				
			}
			if(cnt > n/2) return true;
		}
		return false;
	}
	public static boolean getPossibleMap() {
		for(int i = 0; i < n; i++) {
			if(!stateMap[0][i] && isPossibleLine(0, i)) {
				stateMap[0][i] = true;
				possibleMap.add(new Info(0, i));
			}
			if(!stateMap[1][i] && isPossibleLine(1, i)) {
				stateMap[1][i] = true;
				possibleMap.add(new Info(1, i));			
			}
		}
		if(possibleMap.isEmpty()) return false;
		else return true;
	}
	
}
