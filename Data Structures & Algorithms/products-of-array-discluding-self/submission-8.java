class Solution {
    public int[] productExceptSelf(int[] nums) {
        //左边所有数字 * 右边所有数字
        int[] res = new int[nums.length];

        //每位数字的左边
        int pre = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = pre;
            pre *= nums[i];
        }
 

        int suf = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            res[j] = suf * res[j];
            suf *= nums[j];
        }
        return res;

    }
}  


