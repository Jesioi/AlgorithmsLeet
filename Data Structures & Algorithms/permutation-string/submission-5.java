class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        Arrays.sort(str1);
        String sorted1 = new String(str1);

        for (int i = 0; i < s2.length(); i++) {
            for (int j = i; j < s2.length(); j++) {
                char[] subStr = s2.substring(i, j + 1).toCharArray();

                Arrays.sort(subStr);
                String sorted2 = new String(subStr);
                if (sorted2.equals(sorted1)) {
                    return true;
                }
            }
        }
        return false;
    }
}

