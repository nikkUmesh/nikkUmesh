package IntroductionProgram;

import java.util.Scanner;

public class FindASCIIVCalueCharacter {

	public static void main(String[] args) {

		System.out.println("Enter a character");
		Scanner sc = new Scanner(System.in);
		char chr = sc.next().charAt(0);
		int value = chr;
		System.out.println("ASCII value of " +chr+ " is:" +value);
	}

}
