package Problems.In_Progress.RemoveBoxes;
import Common.ImportJson;
import java.util.Arrays;
public class RemoveBoxes {
    public static void main(String[] args) {
        
        Integer[] intList = ImportJson.getIntList("RemoveBoxes/list1.txt");
        int[] boxes = Arrays.stream(intList).mapToInt(Integer::intValue).toArray();

        System.out.println(new Solution().removeBoxes(boxes));
    }
}

class Solution {
    public int removeBoxes(int[] boxes) {
        int soln = 1;

        return soln;
    }
}