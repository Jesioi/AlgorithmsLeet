public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }

        int r = 1;
        for (int i = nums.length - 1; i >=0; i--) {
            //r 是从后往前的乘积，r 是和nums 更新，ans[i] 是结果, ans[i] 不包括本身
            //ans[i] * r == 除了自己之外的乘积
            ans[i] = ans[i] * r;
            r *= nums[i];
        }

        return ans;


    }
}