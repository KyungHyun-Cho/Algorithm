import java.util.*;
import java.io.*;

class Person implements Comparable<Person>{
	int no, mul, sum;
	Person(int no, int s1, int s2, int s3){
		this.no = no;
		mul = s1*s2*s3;
		sum = s1+s2+s3;
	}
	public int compareTo(Person o) {
		if(this.mul == o.mul && this.sum == o.sum) return this.no-o.no;
		else if(this.mul == o.mul) return this.sum - o.sum;
		return this.mul - o.mul;
	}	
}
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Person> pq = new PriorityQueue<>();
		int n = stoi(br.readLine());
		while(n-- > 0) {
			String[] inputArr = br.readLine().split(" ");
			int no = stoi(inputArr[0]);
			pq.add(new Person(no, stoi(inputArr[1]), stoi(inputArr[2]), stoi(inputArr[3])));
		}
		
		StringBuilder answer = new StringBuilder();
		for(int i = 0; i < 3; i++) {
			answer.append(pq.poll().no).append(" ");
		}
		
		System.out.println(answer);
		
	}
	static int stoi(String str) {return Integer.parseInt(str);}
}
