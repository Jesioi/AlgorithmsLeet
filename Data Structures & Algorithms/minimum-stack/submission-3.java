class MinStack {
    Deque<int[]> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        int currentMin;

        if (stack.isEmpty()) {
            currentMin = val;
        } else {
            currentMin = Math.min(val, stack.peekLast()[1]);
        }

        stack.offerLast(new int[]{val, currentMin});
    }
    
    public void pop() {
        stack.pollLast();
    }
    
    public int top() {
        return stack.peekLast()[0];
    }
    
    public int getMin() {
        return stack.peekLast()[1];
    }
}
//push 的时候维护min，get min直接拿min就好
// 2, 3 1
