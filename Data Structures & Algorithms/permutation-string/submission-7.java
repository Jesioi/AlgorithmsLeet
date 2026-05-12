class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        char[] s1Chars = s1.toCharArray();
        Arrays.sort(s1Chars);
        String str1 = new String(s1Chars);

        for (int i = len; i <= s2.length(); i++) {
            String str2 = s2.substring(i - len, i);
            char[] str2Chars = str2.toCharArray();
            Arrays.sort(str2Chars);
            String str22 = new String(str2Chars);

            if (str22.equals(str1)) {
                return true;
            }
        }
        return false;
    }
}
