class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        int left = 0;
        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        
        for (int right = 0; right < s2.length(); right++) {
            count[s2.charAt(right) - 'a']--;
            if ((right - left + 1) > len) {
                count[s2.charAt(left) - 'a']++;
                left++;
            }
            if ((right - left + 1) == len) {
                boolean match = true;

                for (int n : count) {
                    if (n != 0) {
                        match = false;
                        break;
                    }

                }
                if (match) return true;
                
            }
             
        }
        return false;
    } 
}
