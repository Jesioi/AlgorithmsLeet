class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = row - 1;
        int mid = 0;

        while(left <= right) {
            mid = left + (right - left) / 2;
            if (matrix[mid][0] == target) return true;

            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        int targetRow = right;
        if (targetRow < 0) return false;

        left = 0;
        right = col - 1;
        while (left <= right) {
            int curMid = left + (right - left) / 2;
            if (matrix[targetRow][curMid] == target) return true;

            if (matrix[targetRow][curMid] > target) {
                right = curMid - 1;
            } else {
                left = curMid + 1;
            }
        }
        return false;

    }
}
//brute
//iterate every row, coloum to find target 
// O(n * m)
// O(1)

//binary search row
//binary search colum


