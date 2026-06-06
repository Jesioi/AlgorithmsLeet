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

            String k = sb.toString();

            res.putIfAbsent(k, new ArrayList<>());
            res.get(k).add(str);

        }
        return new ArrayList<>(res.values());
    }
}
