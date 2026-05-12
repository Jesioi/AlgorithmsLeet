class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums.length == 0 || nums == null) return false;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }
}

//use set store
//iterate, if not exist add to set, return false whenever set contains
//return true