import java.util.*;
public class Main {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[5];
		for(int i = 0; i < 5; i++)
			arr[i] = sc.nextInt();
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 4; j++) {
				if(arr[j+1] < arr[j]) swap(j, j+1);
			}
		}
	}
	public static void swap(int i1, int i2) {
		int tmp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = tmp;
		System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + arr[4]);
	}
}
