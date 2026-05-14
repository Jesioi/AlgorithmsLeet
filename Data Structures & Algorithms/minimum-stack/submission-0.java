public class MinStack {
    //stack 不存真实值，而存「当前值和当前最小值的差值」；
    //负数代表这里产生了新的 min，因此可以在 pop 时恢复旧 min。
    long min;
    Stack<Long> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        //时刻记录差值，
        //0 1，7, 5
        // 1  6 (5 - 6) = -1 ---> stack
        // min  = 5
        if (stack.isEmpty()) {
            stack.push(0L);
            min = val;
        } else {
            stack.push(val - min);
            if (val < min) min = val;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long pop = stack.pop();

        if (pop < 0) min = min - pop;
    }

    public int top() {
        long top = stack.peek();
        if (top > 0) {
            return (int) (top + min);
        } else {
            return (int) min;
        }
    }

    public int getMin() {
        return (int) min;
    }
}
