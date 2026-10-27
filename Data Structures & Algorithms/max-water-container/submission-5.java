class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int size = 0;
        while (i < j) {
            int sum = (j - i) * Math.min(heights[i], heights[j]);

            size = Math.max(sum, size);

            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return size;
    }
}
