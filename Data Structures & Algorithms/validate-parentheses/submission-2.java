class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();

        //iterate char in string
        for (char c : s.toCharArray()){
            //if map not contains c, add to stack(left bracket)
            if (!map.containsKey(c)) {
                stack.offerLast(c);
            } else {
                //if map contains, stack pop,
                if (stack.isEmpty()) return false;
                
                char cur = stack.pollLast();
                if (cur != map.get(c)) {
                    return false;
                }
            }   
        }

        if (!stack.isEmpty()) return false;
        return true;
    }
}
//'(', ')', '{', '}', '[' and ']'.
// hashmap store, O(1) get operation
// stack to store left bracket,