
public class Solution {
	static int answer = 0;
	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}
	static int solution(int[] numbers, int target) {
        DFS(numbers, target, 0, 0);
        return answer;
    }
	static void DFS(int[] number, int target, int sum, int idx) {
		if(idx == number.length) {
			if(sum == target) answer++;
		}else {
			DFS(number, target, sum + number[idx], idx+1);
			DFS(number, target, sum + (number[idx] * -1), idx+1);			
		}
	}

}
