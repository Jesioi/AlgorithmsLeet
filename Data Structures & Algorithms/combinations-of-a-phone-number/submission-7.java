class Solution {
    List<String> res = new ArrayList<>();

    StringBuilder sb = new StringBuilder();
    String[] phone = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        backtrack(digits, 0);
        return res;
    }

    private void backtrack(String str, int index) {
        if(index == str.length()) {
            res.add(sb.toString());
            return;
        }

        String letters = phone[str.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            backtrack(str, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
