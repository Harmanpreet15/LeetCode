public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        // Find maximum pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            int hours = 0;

            // Calculate total hours at speed mid
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }

            // Speed is enough, try smaller
            if (hours <= h) {
                right = mid;
            }

            // Speed is too slow, go faster
            else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        int[] piles = {3, 6, 7, 11};
        int h = 8;

        System.out.println(minEatingSpeed(piles, h));
    }
} 
