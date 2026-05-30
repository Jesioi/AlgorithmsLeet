class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();

        if (!set.contains(endWord)) return 0;

        Deque<String> queue = new ArrayDeque<>();
        queue.offerLast(beginWord);
        visited.add(beginWord);

        int count = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                String cur = queue.pollFirst();
                if (cur.equals(endWord)) return count;

                char[] chars = cur.toCharArray();

                for (int pos = 0; pos < chars.length; pos++) {
                    char original = chars[pos];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[pos] = c;
                        String newString = new String(chars);

                        if (set.contains(newString) && !visited.contains(newString)) {
                            visited.add(newString);
                            queue.offerLast(newString);
                        }
                    }
                    chars[pos] = original;
                }
                size--;
            }
            count++;
        }
        return 0;
    }
}
