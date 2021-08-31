package Problems.In_Progress.SetZeroes;

import Common.ImportJson;
import java.util.*;

public class SetZeroes {
    public static void main(String[] args) {
        Integer[][] IntMatrix = ImportJson.getIntMatrix("SetZeroes/mat1.txt");
        int[][] matrix = ImportJson.intFromInt(IntMatrix);
        new Solution().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
        setZeroes(matrix, new int[] { 0, 0 });
    }

    public void setZeroes(int[][] matrix, int[] currPos) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] currIndex = new int[] { 0, 0 };

        for (int i = 0; i < m * n; i++) {
            int x = currIndex[0], y = currIndex[1];
            if (matrix[x][y] != 0)
                continue;

            boolean firstOfRow = x - 1 < 0;
            boolean firstOfColumn = y - 1 < 0;
            if (!firstOfRow && matrix[x - 1][y] == 0) {
                matrix[x][y] = 0;
            }

            else {
                for (int j = 0; j < x; j++) {
                    matrix[j][y] = 0;
                }
            }

            if (x + 1 < m) {
                setZeroes(matrix, new int[] { x + 1, y });
            }

            if (!firstOfColumn && matrix[x][y - 1] == 0) {
                matrix[x][y] = 0;
            }

            else {
                for (int j = 0; j < y; j++) {
                    matrix[x][j] = 0;
                }
            }

            if (y + 1 < n) {
                setZeroes(matrix, new int[] { x, y + 1 });
            }
        }

    }
    /*
     * public void setZeroes(int[][] matrix) { int m = matrix.length; int n =
     * matrix[0].length; int[] currIndex = new int[] { 0, 0 }; boolean zeroRow =
     * false, zeroClmn = false; for (int i = 0; i < m * n; i++) { int x =
     * currIndex[0], y = currIndex[1]; if (matrix[x][y] == 0) { if(x == 1 && y == 4)
     * System.out.print(""); if (x == 0) { zeroRow = true; if(y != 0) for (int j =
     * 0; j < m; j++) matrix[j][y] = 0;
     * 
     * } if (y == 0) { zeroClmn = true; if(x != 0) for (int j = 0; j < n; j++)
     * matrix[x][j] = 0; } if (matrix[x][0] != 0 && matrix[0][y] != 0) { for (int j
     * = 0; j < m; j++) matrix[j][y] = 0;
     * 
     * for (int j = 0; j < n; j++) matrix[x][j] = 0;
     * 
     * } } currIndex = nextIndex(currIndex, m, n); } if (zeroRow) { for (int j = 0;
     * j < n; j++) matrix[0][j] = 0; }
     * 
     * if (zeroClmn) { for (int j = 0; j < m; j++) matrix[j][0] = 0; } }
     */

    public int[] nextIndex(int[] currIndex, int m, int n) {
        int x = currIndex[0], y = currIndex[1];
        if (y == 0) {
            if (++x < m) {
                return new int[] { x, y };
            }
            return new int[] { 0, 1 };

        } else if (x == 0) {
            if (++y < n) {
                return new int[] { x, y };
            }
            return new int[] { 1, 1 };
        }

        if (++y < n)
            return new int[] { x, y };

        return new int[] { ++x, 1 };
    }

}
