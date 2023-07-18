package com.leetcode.problems.solutions.inprogress.validsudoku;
import com.leetcode.problems.commons.utils.*;
import java.util.*;
public class ValidSudoku {
    public static void main(String[] args) {

        char[][] board = ImportJson.getCharMatrix("ValidSudoku/sudoku1.txt");
        System.out.println(new Solution().isValidSudoku(board));
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        //check rows
        for(char[] row: board) {
            boolean[] filledRows = new boolean[9];
        }
        return false;
    }
}