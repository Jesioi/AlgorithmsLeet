class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int len = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(i));
            len = Math.max(len, set.size());
        }
        return len;

    }
}
//sliding window, check if duplicate within the window range
//use set to store string in each window
//global variable to update and record the longest len

//O(n)
//
