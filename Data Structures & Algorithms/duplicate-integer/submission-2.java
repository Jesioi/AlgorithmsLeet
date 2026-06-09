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
//Approach 1:
//use set store
//iterate, if not exist add to set, return false whenever set contains
//return true

//O(n)
//O(n)

//Approach 2:
//Arrays.sort O(n log n)
// iterate(if i = i - 1) return true, else false

//O(n log n)
//O(n)