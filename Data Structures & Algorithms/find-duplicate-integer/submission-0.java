class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }

        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2) {
                return slow;
            }
        }
    }
}
//一个移两部，一个移一步
//相遇后，将其中一个挪回head，两个都移一步开始解，最终再相遇就是entrance的位置


