class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int i : piles) {
            right = Math.max(right, i);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long hours = 0;
            for (int p : piles) {
                hours += (p + mid - 1) / mid; //round up
            }

            if (hours > h) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }

        }
        return left;
    }
}
