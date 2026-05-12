class Solution {
    public boolean isAnagram(String s, String t) {
        int[] match = new int[26];
        for (char c : s.toCharArray()) {
            match[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            match[c - 'a']--;
        }

        for (int i : match) {
            if (i != 0) return false;
        }
        return true;
    }
}
//approach 1:
//array mapping number of char appeared
//deduct for second string
//if numbers are greater than 0 return false