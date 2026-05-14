class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        if (len == 1) return new int[]{0};

        int[] res = new int[len];
        Deque<int[]> stack = new ArrayDeque<>();

        //iterature temperature
        
        for (int i = 0; i < len; i++) {
            //push temperature into the stack while stack is not empty
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
                //check if current temp > last temp in stack, record result
                res[stack.peek()[1]] = i - stack.peek()[1];
                stack.poll();
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return res;
    }
}
//stack
// int[] pair:[temperature, index]