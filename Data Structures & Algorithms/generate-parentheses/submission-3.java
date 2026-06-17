class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0);
        return res;
        
    }

    private void backtrack(int n, int left, int right) {
       if (sb.length() == 2 * n) {
        res.add(sb.toString());
        return;
       }

       if (left < n) {
            sb.append('(');
            backtrack(n, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
       }

        if (right < left && sb.length() <= 2 * n) {
            sb.append(')');
            backtrack(n, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


}

