package challange;

class PalindromeGenerator {
	
	public static void main(String[] args) {
		int n = 1000000;
		generateDecimalPaldindromes(n);
	}

	static void generateDecimalPaldindromes(int n) {
		int number;
		long sum = 0;
		for (int j = 0; j < 2; j++) {
			int i = 1;
			while ((number = generatePalindrome(i, 10, j % 2)) < n) {
				if (isBinaryPalindrome(number)) {
					sum += number;
				}
				i++;
			}
		}
		System.out.println("Sum of all palindromic numbers: " + sum);
	}
	
	static int generatePalindrome(int input, int b, int isOdd) {
		int n = input;
		int palin = input;

		if (isOdd == 1)
			n /= b;

		while (n > 0) {
			palin = palin * b + (n % b);
			n /= b;
		}
		return palin;
	}

	static boolean isBinaryPalindrome(long n) {
		long rev = reverseBits(n);
		return (n == rev);
	}
	
	static long reverseBits(long n) {
		long rev = 0;

		// traversing bits of 'n'
		// from the right
		while (n > 0) {
			// bitwise left shift 'rev' by 1
			rev <<= 1;

			// if current bit is '1'
			if ((n & 1) == 1)
				rev ^= 1;

			// bitwise right shift 'n' by 1
			n >>= 1;
		}
		// required number
		return rev;
	}
}
