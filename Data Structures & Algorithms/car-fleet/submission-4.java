class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        //pair: [position, speed]
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        //按position 从大到小排
        Arrays.sort(pair, (a, b) -> b[0] - a[0]);

        Deque<Double> stack = new ArrayDeque<>();
        for (int[] p : pair) {
            double time = (double) (target - p[0]) / p[1];

            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }
        return stack.size();

    }
}
//按离终点从近到远看；如果后车到达时间 <= 前面车队时间，就会追上并合并；只有 time 更大，才形成新车队。
//10 -> time 1
// 8  -> time 1
// 5  -> time 7
// 3  -> time 3
// 0  -> time 12
// 如果后车 time <= 前面 fleet 的 time, 说明后车能追上前车，合并成同一个 fleet
