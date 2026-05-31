class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return res;
    }

    private void backtrack(String s,int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (!isPalindrome(s, start, end)) continue;

            path.add(s.substring(start, end + 1));
            backtrack(s, end + 1);
            path.remove(path.size() - 1);
        }
         
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
