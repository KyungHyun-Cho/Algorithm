import java.util.Scanner;
import java.lang.Math;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(Math.max(str.split("10",-1).length-1,str.split("01",-1).length-1));
	}
}

//import java.util.*;import java.lang.*;class Main{public static void main(String[]b){Scanner s=new Scanner(System.in);String a=s.next();	System.out.print(Math.max(a.split("10",-1).length-1,a.split("01",-1).length-1));}}