package Problems.In_Progress.FindLUSLength;

import java.util.Arrays;
import java.util.Random;

public class findLUSLength {
    public static void main(String[] args) {
        
        System.out.println(new Solution().lcsLength("aaa","aa"));
        System.out.println(new Solution().findLUSlength(new String[] {"aaa","aaa","aa"}));
    }
    
    static String[] randomStrings(int numStrings, int maxLength) {
        String[] randomStrings = new String[numStrings];
        var randStream = new Random().ints((int) 'a', (int) 'a'+26).iterator();
        
        for(int i = 0; i < numStrings; i++) {
            int stringLength = new Random().nextInt(maxLength) + 1;
            char[] charArray = new char[stringLength];
            for(int j = 0; j < stringLength; j++) {
                charArray[j] = (char) (int) randStream.nextInt();
            }
            randomStrings[i] = new String(charArray);
        }

        return randomStrings;
        
    }
}

class Solution {
    public int findLUSlength(String[] strs) {
        int maxUncommon = -1;
        for(int i = 0; i < strs.length; i++) {
            for(int j = i; j < strs.length; j++) {
                int res = Math.min(strs[i].length(), strs[j].length()) - lcsLength(strs[i], strs[j]);
                if(res > maxUncommon && res > 0)
                    maxUncommon = res;
            }
        }
        return maxUncommon;
    }
    
    public int lcsLength(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0)
                    continue;
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }
}