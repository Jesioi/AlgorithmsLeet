class Solution {
    public int longestConsecutive(int[] nums) {
        //find the entry of a consecutive sequence
        //use set to store value
        //iterate num, check if num - 1 appear, when num - 1 not exist, that's the entry
        //keep checking until num invalid
        //update globla variable 
        if (nums.length == 0 || nums == null) return 0;

        int max = 0;
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        for (int i : nums) {
            if (!set.contains(i - 1)) {
                int cur = i;
                int len = 0;
                while (set.contains(cur)) {
                    len++;
                    cur++;
                }
                max = Math.max(len, max);
            }
        }
        return max;

    }
}
