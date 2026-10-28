class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            len = Math.max(len, set.size());
        }
        return len;
    }
}
