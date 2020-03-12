package com.epsilon.programs;

public class GetQuotient {

	public static void main(String[] args) {
		// System.out.println(Arrays.toString(args));
		try {
			String a1 = args[0]; // "567"
			String a2 = args[1]; // "0"
			int n = Integer.parseInt(a1);
			int d = Integer.parseInt(a2);
			int q = n / d;
			System.out.println("Quotient of " + n + " / " + d + " = " + q);
		} catch (NumberFormatException e) {
			System.err.println("Only integer values allowed!");
			// return
			// throw new RuntimeException("This is a dummy exception!");
			// System.exit(12);
		} catch (ArithmeticException e) {
			System.err.println("Cannot divide by zero!");
		} catch (Exception e) { // fallback/default; must always be the last one.
			System.err.println("Two inputs expected!");
		} finally {
			System.out.println("This works in most cases!");
		}

		System.out.println("End of main!");
	}

}
