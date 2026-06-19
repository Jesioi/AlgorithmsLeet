class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
        
    }

    private void backtrack(int[] nums, int index) {
        res.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.remove(path.size() - 1);

        }
    }
}

