class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        backtrack(nums, 0);
        return res;

    }

    private void backtrack(int[] nums, int index) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

            visited[i] = true;
            path.add(nums[i]);

            backtrack(nums, i + 1);

            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
