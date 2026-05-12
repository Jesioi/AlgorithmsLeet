class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int[] count = new int[26];
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                count[c - 'A']++;

                int maxFreq = 0;
                for (int t : count) {
                    maxFreq = Math.max(t, maxFreq);
                }
                
                int windowSize = j - i + 1;
                if (windowSize - maxFreq <= k) {
                    maxLen = Math.max(maxLen, windowSize);
                }
            }
        }

        return maxLen;
    }
}
