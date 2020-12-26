import java.lang.Math;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double n = sc.nextDouble();
		System.out.printf("%.6f\n",n*n*Math.PI);
		System.out.printf("%.6f",n*n*2);
		sc.close();
	}

}
