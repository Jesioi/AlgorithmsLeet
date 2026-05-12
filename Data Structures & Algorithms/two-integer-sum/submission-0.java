class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                res[0] = Math.min(i, map.get(target - nums[i]));
                res[1] = Math.max(i, map.get(target - nums[i]));
            }
        }
        return res;
    }
}

//brute force
//for loop + for loop

//O(n ^ 2)
//O(1)

//Approch 2
//Hashmap: key: number value: index