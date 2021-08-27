
public class Solution {

	public static void main(String[] args) {
		for(int n = 1; n <= 13; n++)
		System.out.println(solution(n));
	}
	public static String solution(int n) {
		StringBuilder sb = new StringBuilder();
		while(n > 3) {
			int temp = n % 3;
	        if (temp == 0)
	        {
	            //3으로 나누어 떨어지는 숫자 -> 몫을 -1해서 다시 나눔
	            sb.append(4);
	            n = n / 3 - 1;
	        }
	        else
	        {
	            sb.append(n % 3);
	            n /= 3;
	        }
		}
		sb.append(n == 3 ? 4 : n);
		return sb.reverse().toString();
	}

}
