package dynamicprog;

class MinCoins
{
	// Function to find the minimum number of coins required
	// to get total of N from set S
	public static int findMinCoins(int[] S, int N) {
		// if total is 0, no coins are needed
		if (N == 0) {
			return 0;
		}

		// return INFINITY if total become negative
		if (N < 0) {
			return Integer.MAX_VALUE;
		}

		// initialize minimum number of coins needed to infinity
		int coins = Integer.MAX_VALUE;

		// do for each coin
		for (int i = 0; i < S.length; i++) {
			// recur to see if total can be reached by including
			// current coin S[i]
			int res = findMinCoins(S, N - S[i]);

			// update minimum number of coins needed if choosing current
			// coin resulted in solution
			if (res != Integer.MAX_VALUE) {
				coins = Integer.min(coins, res + 1);
			}
		}

		// return minimum number of coins needed
		return coins;
	}
	
	// using Memoization but no recursion overhead
	public static int findMinCoins2(int[] S, int N) {
		// T[i] stores minimum number of coins needed to get total of i
		int[] T = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			// initialize minimum number of coins needed to infinity
			T[i] = Integer.MAX_VALUE;
			int res = Integer.MAX_VALUE;

			// do for each coin
			for (int c = 0; c < S.length; c++) {
				// check if index doesn't become negative by including
				// current coin c
				if (i - S[c] >= 0) {
					res = T[i - S[c]];
				}

				// if total can be reached by including current coin c,
				// update minimum number of coins needed T[i]
				if (res != Integer.MAX_VALUE) {
					T[i] = Integer.min(T[i], res + 1);
				}
			}
		}

		// T[N] stores the minimum number of coins needed to get total of N
		return T[N];
	}

	public static void main(String[] args) {
		// n coins of given denominations
		int[] S = { 1, 3, 5, 7 };

		// Total Change required
		int N = 18;

		System.out.println("Minimum number of coins required to get " +
							"desired change is " + findMinCoins2(S, N));
	}
}
