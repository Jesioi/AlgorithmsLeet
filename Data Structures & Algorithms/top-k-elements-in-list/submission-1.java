class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
//prioritu queue, 根据map排序，
//Map<nums, feq>
//return top priority queue
//O(n log n): pq
//O(n)


//Map<nums, freq>
//new int[k]
// update int[k] by iterate map
// O(n)
// O(n)
