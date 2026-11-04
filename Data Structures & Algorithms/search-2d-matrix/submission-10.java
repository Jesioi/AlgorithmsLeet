class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = row - 1;

        int aim;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] < target) {
                left = mid + 1;
            }else if (matrix[mid][0] > target) {
                right = mid - 1;
            }else if (matrix[mid][0] == target) {
                return true;
            } 
        }
        aim = right;
        if (aim < 0) return false;
        
        left = 0;
        right = col - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[aim][mid] == target) return true;
            if (matrix[aim][mid] > target) {
                right = mid - 1;
            }else if (matrix[aim][mid] < target) {
                left = mid + 1;
            }
        }
        return false;
        
    }
}
