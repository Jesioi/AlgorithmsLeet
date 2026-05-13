class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int curMax = nums[i];
            for (int j = i; j < i + k; j++) {
                curMax = Math.max(curMax, nums[j]);
            }
            res[i] = curMax;
        }
        return res;
    }
}

