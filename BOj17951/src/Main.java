import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArr = br.readLine().split(" ");
		int n = stoi(inputArr[0]);
		int k = stoi(inputArr[1]);
		int[] arr = new int[n];
		int[] group = new int[k];
		int[] group2 = new int[k];
		
		int sum = 0, avg = 0;
		inputArr = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			arr[i] = stoi(inputArr[i]);
			sum += arr[i];			
		}
		avg = sum / k;
		
		int groupIdx = 0, groupIdx2 = 0;
		
		for(int i = 0; i < n; i++) {
			if(group[groupIdx] == 0)
				group[groupIdx] += arr[i];
			else
			{
				if(group[groupIdx] + arr[i] > avg) {
					if(groupIdx + 1 >= k) {
						group[groupIdx] += arr[i];
					}else {
						group[++groupIdx] += arr[i];
					}
				}else{
					group[groupIdx] += arr[i];
				}
			}				
		}
		
		for(int i = 0; i < n; i++) {
			if(group2[groupIdx2] == 0)
				group2[groupIdx2] += arr[i];
			else
			{
				if(group2[groupIdx2] + arr[i] > avg) {
					if(groupIdx2 + 1 >= k) {
						group2[groupIdx2] += arr[i];
					}else {
						group2[groupIdx2++] += arr[i];
					}
				}else if(group2[groupIdx2] + arr[i] == avg) {
					group2[groupIdx2++] += arr[i];
				}
				else{
					group2[groupIdx2] += arr[i];
				}
			}				
		}
		
		int min = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		for(int i = 0; i < k; i++) {
			min = Math.min(min, group[i]);
			min2 = Math.min(min2,  group2[i]);
		}
		
		System.out.println(Math.max(min, min2));
		
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}
