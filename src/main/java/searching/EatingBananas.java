package searching;

// https://leetcode.com/problems/koko-eating-bananas/description/
public class EatingBananas {

	public static void main(String[] args) {
		int eatingSpeed = minEatingSpeed(new int[] {30,11,23,4,20}, 5);
		System.out.println(eatingSpeed);
	}
	
    public static int minEatingSpeed(int[] piles, int h) {
        // Initalize the left and right boundaries 
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            // Get the middle index between left and right boundary indexes.
            // hourSpent stands for the total hour Koko spends.
            int middle = (left + right) / 2;
            int hourSpent = 0;

            // Iterate over the piles and calculate hourSpent.
            // We increase the hourSpent by ceil(pile / middle)
            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / middle);
            }

            // Check if middle is a workable speed, and cut the search space by half.
            if (hourSpent <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        // Once the left and right boundaries coincide, we find the target value,
        // that is, the minimum workable eating speed.
        return right;
    }
	
	public int minEatingSpeedBruteForce(int[] piles, int h) {
        // Start at an eating speed of 1.
        int speed = 1;

        while (true) {
            // hourSpent stands for the total hour Koko spends with 
            // the given eating speed.
            int hourSpent = 0;

            // Iterate over the piles and calculate hourSpent.
            // We increase the hourSpent by ceil(pile / speed)
            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / speed);
                if (hourSpent > h) {
                    break;
                }
            }

            // Check if Koko can finish all the piles within h hours,
            // If so, return speed. Otherwise, let speed increment by
            // 1 and repeat the previous iteration.
            if (hourSpent <= h) {
                return speed;
            } else {
                speed += 1;
            }            
        }
    }

}
