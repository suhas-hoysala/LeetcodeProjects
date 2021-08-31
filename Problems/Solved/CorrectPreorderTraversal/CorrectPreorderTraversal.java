package Problems.Solved.CorrectPreorderTraversal;

import java.util.*;

public class CorrectPreorderTraversal {
    public static void main(String[] args) {
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(new Solution().isValidSerialization(preorder));
    }
}

class Solution {
    Stack<boolean[]> vals = new Stack<>();

    public boolean isValidSerialization(String preorder) {
        if(preorder.equals("#"))
            return true;
        String[] nums = preorder.split(",");
        try {
            Integer.parseInt(nums[0]);
        } catch (NumberFormatException e) {
            return false;
        }
        
        vals.push(new boolean[] { false, false });
        for (int i = 1; i < nums.length; i++) {
            if (vals.isEmpty())
                return false;
            if (nums[i].equals("#")) {
                while(!vals.isEmpty()) {
                    if(!vals.peek()[0]) {
                        vals.peek()[0] = true;
                        break;
                    }
                    else if(!vals.peek()[1]) {
                        vals.pop();
                        break;
                    }
                    vals.pop();
                }
            }

            else {
                while(!vals.isEmpty()) {
                    if(!vals.peek()[0]) {
                        vals.peek()[0] = true;
                        vals.push(new boolean[] {false, false});
                        break;
                    }
                    else if(!vals.peek()[1]) {
                        vals.peek()[1] = true;
                        vals.push(new boolean[] {false, false});
                        break;
                    }
                    vals.pop();
                }
                
            }
        }
        while (!vals.isEmpty()) {
            boolean[] headVal = vals.pop();
            if (!headVal[0] || !headVal[1])
                return false;
        }
        return true;
    }
}
