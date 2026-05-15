class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int res = Integer.MAX_VALUE;
        while (left <= right) {
            int k = left + (right - left) / 2;

            long hours = 0;

            //calculate total time need at rate k
            for (int pile : piles) {
                hours += (pile + k - 1) / k;
            }

            //if time <= h, record res
            if (hours <= h) {
                res = Math.min(res, k);
                right = k - 1;
            } else {
                left = k + 1;
            }
        }

        return res;

    }
}
//哈双滑，栈队堆；
// 树图递，排贪二；
// 前缀并，位回溯。

// 0 1 2 3

// 4 3 2 1
// 2 2 1 1 -> 6
// 2 1 1 1 -> 5
// 4 3 2 1 -> 10

// 9 - 3 = 6 - (piles[i] / k) -> if % k > 0 -> result + 1

//find left boundary
//h need must < h;

//sort
//拿中间的数值和index，看吃不吃的完，吃不完就left = mid + 1
//一但吃的完就直接return

// 4 10 23 25
//  2   3   3 
//       3  2 
//          1

//brute
//min
// min = Integer.MAX_VALUE;
// for (int i : piles) {
//     int time = 1;
//     for (int j = i; j < len; j++) {
//         int need = nums[j] / nums[i];
//         time += need;
//     }
//     if (time < h) {
//         min = Math.min(time, min);
//     }

// }
// return min == Integer.MAX_VALUE ? -1 : min;





