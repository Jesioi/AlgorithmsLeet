class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String str : strs) {
            int[] match = new int[26];
            for (char c : str.toCharArray()) {
                match[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i : match) {
                sb.append(i).append('#');
            }

            String compare = sb.toString();

            res.putIfAbsent(compare, new ArrayList<>());
            res.get(compare).add(str);
        }
        return new ArrayList<>(res.values());

    }
}
