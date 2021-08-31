package Problems.In_Progress.RectangleArea;

import java.util.*;
import Common.*;

public class RectangleArea {
    public static void main(String[] args) {
        int[][] rectangles = ImportJson.intFromInt(ImportJson.getIntMatrix("RectangleArea\\rect3.txt"));
        System.out.println(new Solution().rectangleArea(rectangles));
    }
}

class Solution {
    TreeSet<int[]> gridRecs = new TreeSet<>(
            (a, b) -> a[0] != b[0] ? ((Integer) a[0]).compareTo(b[0]) : -((Integer) a[2]).compareTo(b[2]));
    
    static final int mod = ((int) Math.pow(10, 9) + 7);

    public int rectangleArea(int[][] rectangles) {
        int totalArea = 0;


        return totalArea;
    }

    int calculateArea(int totalArea, int[] partialRectRec) {
        int newArea = mulmod(Math.abs(submod(partialRectRec[3], partialRectRec[1], mod)), Math.abs(submod(partialRectRec[3], partialRectRec[1], mod)), mod);
        return (totalArea + newArea) % mod;
        
    }

    static int submod(int a, int b, int mod) {
        return ((a % mod) - (b % mod)) % mod;
    }

    static int mulmod(int a, int b, int mod) {
        int res = 0; // Initialize result
        a = a % mod;
        while (b > 0) {
            // If b is odd, add 'a' to result
            if (b % 2 == 1) {
                res = (res + a) % mod;
            }

            // Multiply 'a' with 2
            a = (a * 2) % mod;

            // Divide b by 2
            b /= 2;
        }

        // Return result
        return res % mod;
    }
}