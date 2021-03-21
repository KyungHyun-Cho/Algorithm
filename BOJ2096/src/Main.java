import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[3];
		int[][] maxDP = new int[2][3];
		int[][] minDP = new int[2][3];
		int n = stoi(br.readLine());
		String str = br.readLine();
		input(arr, str);
		input(maxDP[0], str);
		input(minDP[0], str);
		if(n == 1) {
			System.out.println(Math.max(Math.max(maxDP[0][0], maxDP[0][1]), maxDP[0][2]) + " " + Math.min(Math.min(minDP[0][0], minDP[0][1]), minDP[0][2]));
			return;
		}
		for(int i = 1; i < n; i++) {
			input(arr, br.readLine());
			maxDP[1][0] = Math.max(maxDP[0][0], maxDP[0][1]) + arr[0];
			maxDP[1][1] = Math.max(Math.max(maxDP[0][0], maxDP[0][1]), maxDP[0][2]) + arr[1];
			maxDP[1][2] = Math.max(maxDP[0][1], maxDP[0][2]) + arr[2];
			move(maxDP);
			minDP[1][0] = Math.min(minDP[0][0], minDP[0][1]) + arr[0];
			minDP[1][1] = Math.min(Math.min(minDP[0][0], minDP[0][1]), minDP[0][2]) + arr[1];
			minDP[1][2] = Math.min(minDP[0][1], minDP[0][2]) + arr[2];
			move(minDP);
			
		}
		System.out.print(Math.max(Math.max(maxDP[1][0], maxDP[1][1]), maxDP[1][2]));
		System.out.print(" ");
		System.out.print(Math.min(Math.min(minDP[1][0], minDP[1][1]), minDP[1][2]));
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
	public static void input(int[] arr, String arg) {
		String[] input = arg.split(" ");
		arr[0] = stoi(input[0]);
		arr[1] = stoi(input[1]);
		arr[2] = stoi(input[2]);
	}
	public static void move(int[][] arr) {
		arr[0][0] = arr[1][0];
		arr[0][1] = arr[1][1];
		arr[0][2] = arr[1][2];		
	}
}
