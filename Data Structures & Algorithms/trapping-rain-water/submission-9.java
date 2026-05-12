class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int left = 1;
        int right = height.length - 2;

        int leftBind = height[0];
        int rightBind = height[height.length - 1];

        int vol = 0;

        while (left <= right) {
            if (leftBind <= rightBind) {
                if (height[left] < leftBind) {
                    vol += leftBind - height[left];
                    left++;
                } else {
                    leftBind = height[left];
                    left++;
                }
            } else {
                if (height[right] < rightBind) {
                    vol += rightBind - height[right];
                    right--;
                } else {
                    rightBind = height[right];
                    right--;
                }
            }
        }
        return vol;

    }
}


