package ua.rozhkov;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.print("Input n: ");
		String input = new Scanner(System.in).nextLine();
		FibonachiSeq fibonachiSeq=new FibonachiSeq();
		System.out.println(fibonachiSeq.formSeq(input));
	}
}
