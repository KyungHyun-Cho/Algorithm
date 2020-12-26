import java.io.*;
public class Main {
	public static int[] arr;
	public static int[] tmp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		tmp = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		merge_sort(0, n-1);
		for(int i = 0; i < n; i++)
			bw.write(arr[i] + "\n");
		br.close();
		bw.flush();
		bw.close();
	}
	public static void merge_sort(int l, int r) {
		if(l < r) {
			int mid = (l+r)/2;
			merge_sort(l, mid);
			merge_sort(mid+1, r);
			merge(l, mid, r);
		}
	}
	public static void merge(int l, int m, int r) {
		int p = l;
		int q = m+1;
		int idx = p;
		
		while(p <= m || q <= r) {
			if(q > r || (p <= m && arr[p] < arr[q])) {
				tmp[idx++] = arr[p++];
			}else
				tmp[idx++] = arr[q++];
		}
		
		for(int i = l; i < idx; i++)
			arr[i] = tmp[i];
	}
}
