package co.vinod.util;

import java.util.Scanner;

public final class KeyboardUtil {

	private KeyboardUtil() {
	}

	public static String getString(String message) {
		System.out.print(message);
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
}
