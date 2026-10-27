class Solution {
    public int trap(int[] height) {
        int size = 0;
        int i = 0;
        int j = height.length - 1;
        
        int leftbind = height[0];
        int rightbind = height[height.length - 1];
        

        while (i <= j) {
            if (leftbind <= rightbind) {
                if (height[i] < leftbind) {
                    size += leftbind - height[i];
                    i++;
                }else {
                    leftbind = height[i];
                    i++;
                }
            }else {
                if (height[j] < rightbind) {
                    size += rightbind - height[j];
                    j--;
                }else {
                    rightbind = height[j];
                    j--;
                }
            }
        }
        return size;

    }
}
