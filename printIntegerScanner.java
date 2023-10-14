package IntroductionProgram;
import java.util.Scanner;

public class printIntegerScanner {
	private static Scanner sc;

	public static void main(String[] args) {

		int number;
		sc=new Scanner(System.in);
		System.out.println("Please Enter the integer value = ");
		number = sc.nextInt();
		System.out.println("The Integer value you have entered="+number);
	}

}
