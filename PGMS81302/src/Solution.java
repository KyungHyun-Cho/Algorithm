
public class Solution {
	static int answer = 0;
	static int[][] dist1Dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int[][] dist2Dir = {{-2, 0}, {0, 2}, {2, 0}, {0, -2}, {-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
	static int[][][] checkDist2Dir = {{{-1, 0}}, {{0, 1}}, {{1, 0}}, {{0, -1}}, {{-1, 0}, {0, 1}}, {{1, 0}, {0, 1}}, {{1, 0}, {0, -1}}, {{-1, 0}, {0, -1}}};
	
	public static void main(String[] args) {
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
							 {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
							 {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
							 {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
							 {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		for(int i : solution(places))
			System.out.println(i);
	}
	static int[] solution(String[][] places) {
        int[] answer = new int[5];
        int idx = 0;
        for(String[] place : places) {
        	char[][] map = new char[5][5];
        	for(int i = 0; i < 5; i++) {
        		String placeStr = place[i];
        		for(int j = 0; j < 5; j++) {
        			map[i][j] = placeStr.charAt(j);
        		}
        	}
        	
        	boolean isBreak = false;
        	for(int i = 0; i < 5; i++) {
        		for(int j = 0; j < 5; j++) {
        			if(map[i][j] == 'P' && !check(map, i, j)) {
        				isBreak = true;
        				break;
        			}        			
        		}
        		if(isBreak) break;
        	}
        	
        	if(isBreak)
        		answer[idx++] = 0;
        	else
        		answer[idx++] = 1;
        }
        return answer;
    }
	static boolean check(char[][] map, int x, int y) {
		for(int i = 0; i < 8; i++) {
			int new_x = x + dist2Dir[i][0];
			int new_y = y + dist2Dir[i][1];
			if(new_x < 0 || new_y < 0 || new_x >= 5 || new_y >= 5) continue;
			if(map[new_x][new_y] == 'P') {
				for(int[] checkDir : checkDist2Dir[i]) {
					int check_x = x + checkDir[0];
					int check_y = y + checkDir[1];
					if(map[check_x][check_y] == 'O')
						return false;
				}
			}
		}
		for(int i = 0; i < 4; i++) {
			int new_x = x + dist1Dir[i][0];
			int new_y = y + dist1Dir[i][1];
			if(new_x < 0 || new_y < 0 || new_x >= 5 || new_y >= 5) continue;
			if(map[new_x][new_y] == 'P')
				return false;
		}
		return true;
	}
}
