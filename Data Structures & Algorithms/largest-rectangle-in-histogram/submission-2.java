class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<int[]> stack = new ArrayDeque<>();
        //stack: [index, height]

        for (int i = 0; i < heights.length; i++) {
            int start = i;
            //当遇到constrain: 更矮的
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                //记录update 当前最大面积
                maxArea = Math.max(maxArea, height * (i - index));
                //更新start指针到上一个的边界
                //start 只能继承被当前高度“吞掉”的更高柱子的左边界；
                //遇到更矮柱子时 while 停止，不能跨过去。
                start = index;
            }

            //出while loop 的时候，上一个边界，和当前height会被记入，当前的height就成了限制
            stack.push(new int[]{start, heights[i]});
        }

        //剩下的都是单调递增，一个个算最大面积对比update就好
        for (int[] pair : stack) {
            int index = pair[0];
            int height = pair[1];
            //用height length是因为上一个forloop已经走完了，现在有边界不是i了变成length了
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }
        return maxArea;
    }
}
