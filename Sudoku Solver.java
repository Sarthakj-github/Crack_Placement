class Solution {
    public void solveSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>(9), cols = new ArrayList<>(9), boxes = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    rows.get(i).add(board[i][j]);
                    cols.get(j).add(board[i][j]);
                    boxes.get((i / 3) * 3 + j / 3).add(board[i][j]);
                }
            }
        solve(board, 0, 0, rows, cols, boxes);
    }

    private boolean solve(char[][] board, int i, int j, List<Set<Character>> rows, List<Set<Character>> cols, List<Set<Character>> boxes) {
        if (i == 9) return true;
        if (board[i][j] != '.') return solve(board, i + (j + 1) / 9, (j + 1) % 9, rows, cols, boxes);

        int boxIndex = (i / 3) * 3 + j / 3;
        for (char k = '1'; k <= '9'; k++) {
            if (!rows.get(i).contains(k) && !cols.get(j).contains(k) && !boxes.get(boxIndex).contains(k)) {
                board[i][j] = k;
                rows.get(i).add(k);
                cols.get(j).add(k);
                boxes.get(boxIndex).add(k);
                if (solve(board, i + (j + 1) / 9, (j + 1) % 9, rows, cols, boxes)) return true;
                board[i][j] = '.';
                rows.get(i).remove(k);
                cols.get(j).remove(k);
                boxes.get(boxIndex).remove(k);
            }
        }
        return false;
    }
}
