class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int res = nums[0];
        while (left <= right) {
            if (nums[left] < nums[right]) {
                res = Math.min(res, nums[left]);
            }

            int mid = left + (right - left) / 2;
            res = Math.min(res, nums[mid]);

            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
//binary searxh
// mid - 1 > mid return mid
//left < mid -> left = mid + 1; 在右边
//left > mid -> right = mid - 1; 在左边
