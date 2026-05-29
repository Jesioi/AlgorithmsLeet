class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if (!wordList.contains(endWord)) return 0;

        Deque<String> queue = new ArrayDeque<>();
        queue.offerLast(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size > 0) {
                String cur = queue.pollFirst();

                if (cur.equals(endWord)) return step;

                char[] chars = cur.toCharArray();

                for (int pos = 0; pos < chars.length; pos++) {
                    char original = chars[pos];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[pos] = ch;
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
            step++;
        }
        return 0;
    }

}
