class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int len = numbers.length;

        for (int i = 0; i < len; i++) {
            int need = target - numbers[i];
            int left = i + 1;
            int right = len - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (numbers[mid] < need) {
                    left = mid + 1;
                } else if (numbers[mid] > need) {
                    right = mid - 1;
                } else {
                    res[0] = i + 1;
                    res[1] = mid + 1;
                    return res;
                }
            }
        }
        return res;
    }
}
// binary search
// left, right, mid
// use advantage of  don-decreasing order 