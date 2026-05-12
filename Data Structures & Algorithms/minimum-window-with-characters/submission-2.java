class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int resLen = Integer.MAX_VALUE;
        int[] res = new int[]{-1,-1};
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> count = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);

                boolean flag = true;
                for (char c : map.keySet()) {
                    if (count.getOrDefault(c, 0) < map.get(c)){
                        flag = false;
                        break;
                    }
                }

                if (flag && (j - i + 1) < resLen) {
                    resLen = j - i + 1;
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
