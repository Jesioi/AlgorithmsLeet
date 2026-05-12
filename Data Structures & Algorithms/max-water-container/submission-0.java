class Solution {
    public int maxArea(int[] heights) {
        int len = heights.length;

        int left = 0;
        int right = len - 1;

        int max = 0;

        while (left < right) {
            if (heights[left] < heights[right]) {
                int vol = heights[left] * (right - left);
                max = Math.max(vol, max);
                left++;
            } else {
                int vol = heights[right] * (right - left);
                max = Math.max(vol, max);
                right--;
            }
        }
        return max;
        
    }
}
