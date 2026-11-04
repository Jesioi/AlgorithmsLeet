class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];

        int freq = 0;
        int left = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;

            freq = Math.max(freq, count[s.charAt(right) - 'A']);
            while ((right - left + 1) - freq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max((right - left + 1), res);

        }

        return res;
    }
}
