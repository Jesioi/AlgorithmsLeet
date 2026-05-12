class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> square = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                char c = board[i][j];

                //把位置映射成九宫格的某个格子
                String box = (i / 3) + "," + (j / 3);

                rows.putIfAbsent(i, new HashSet<>());
                cols.putIfAbsent(j, new HashSet<>());
                square.putIfAbsent(box, new HashSet<>());

                if (rows.get(i).contains(c) || cols.get(j).contains(c) || square.get(box).contains(c)) {
                    return false;
                }

                rows.get(i).add(c);
                cols.get(j).add(c);
                square.get(box).add(c);
            }
        }
        return true;
    }
}
