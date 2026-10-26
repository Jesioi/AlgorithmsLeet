class Solution {
    public boolean isAnagram(String s, String t) {
        int[] match = new int[26];

        for (char c : s.toCharArray()){
            match[c - 'a']++;
        }

        for (char a : t.toCharArray()){
            match[a - 'a']--;
        }    

        for (int i : match) {
            if (i != 0) return false;
        }
        return true;
    }
}
