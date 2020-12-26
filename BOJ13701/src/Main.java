import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		LinkedHashSet<Integer> hs = new LinkedHashSet<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			hs.add(Integer.parseInt(st.nextToken()));
		}
		Iterator it = hs.iterator();
		while(it.hasNext())
			bw.write(it.next() + " ");
		/*ArrayList<Integer> al = new ArrayList<>(hs);
		for(int i = 0; i < al.size(); i++)
			bw.write(al.get(i) + " ");
		*/
		bw.flush();
		bw.close();
		br.close();
	}
}
