class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, target, 0);
        return res;
        
    }

    private void backtrack(int[] nums, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (target < 0) return;

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, target - nums[i], i);
            path.remove(path.size() - 1);
        }

    }

}



//                             2 5 6 9
//                             2   5   6   9
//                 22  25 26 29
// 222  225 226 229 ｜


