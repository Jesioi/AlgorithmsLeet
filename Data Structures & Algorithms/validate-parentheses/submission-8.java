class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
		//use map to store parentheses to o(1) check if its valid
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		
		//iterate through string, and check every char
		//push to stack if its left parentheses
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				//check stack top
                if (stack.isEmpty() || map.get(c) != stack.pollLast()) return false;
			} else {
				stack.offerLast(c);
			}
		}
		if (stack.size() > 0) return false;
		return true;
    }
}
