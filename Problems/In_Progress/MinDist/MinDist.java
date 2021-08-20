package LeetcodeProjects.Problems.In_Progress.MinDist;
public class MinDist {

    public static void main(String[] args) {
        System.out.println(minDistance("sea", "eat"));
    }

    public static int minDistance(String word1, String word2) {
        if (word1.contains(word2) || word2.contains(word1)) {
            return Math.abs(word2.length() - word1.length());
        }
        int minDist = Integer.MAX_VALUE, minDistCalc = 0;
        int i = 0;
        String[] words = { word1, word2 };
        while (i < word1.length() || i < word2.length()) {
            for (int j = 0; j < 2; j++) {
                String word = words[j];
                String otherWord = words[(j + 1) % 2];
                if (i < word.length()) {
                    String wordmod = word.substring(0, i) + word.substring(i + 1, word.length());
                    minDistCalc++;
                    minDistCalc += minDistance(wordmod, otherWord);
                    if (minDistCalc < minDist) {
                        minDist = minDistCalc;
                    }

                }
            }
            i++;
        }

        return minDist;
    }

}
