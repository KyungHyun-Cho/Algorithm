import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> answer = new ArrayList<>();
		int n = stoi(br.readLine());
		
			
		String[] arr = new String[n];
		for(int i = 0; i < n; i++)
			arr[i] = br.readLine();
		
		Arrays.sort(arr);
		for(int i = n-1; i >= 0; i--) {
			if(!CheckPrefix(answer, arr[i]))
				answer.add(arr[i]);
		}
		System.out.println(answer.size());
	}
	public static boolean CheckPrefix(ArrayList<String> arr, String str)
	{
		for(String arrStr : arr) {
			if(arrStr.startsWith(str))
				return true;
		}
		return false;
	}
	
	public static int stoi(String str) {return Integer.parseInt(str);}
}
