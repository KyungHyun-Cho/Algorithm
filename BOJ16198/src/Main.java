import java.io.*;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		String[] inputArr = br.readLine().split(" ");
		int answer = 0;
		
		for(int i = 0; i < n; i++)
			arr.add(stoi(inputArr[i]));
		
		for(int i = 1; i < arr.size()-1; i++)
			answer = Math.max(answer, DFS(arr, i));
		
		System.out.println(answer);
	}
	public static int DFS(ArrayList<Integer> arr, int idx) {
		
		if(arr.size() == 3) {
			return arr.get(idx-1) * arr.get(idx+1);
		}
		else
		{
			int ret = arr.get(idx-1) * arr.get(idx+1);
			int max = 0;
			int tmp = arr.get(idx);
			arr.remove(idx);
			for(int i = 1; i < arr.size() - 1; i++) {
				max = Math.max(max, DFS(arr, i));
			}
			arr.add(idx, tmp);
			return ret + max;
		}
	}
	public static int stoi(String str) {return Integer.parseInt(str);}

}
