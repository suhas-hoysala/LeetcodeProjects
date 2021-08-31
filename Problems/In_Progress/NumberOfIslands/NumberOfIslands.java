package Problems.In_Progress.NumberOfIslands;
import java.util.*;
import org.json.*;
import textio.*;

public class NumberOfIslands {
    public static void main(String[] args) {
        TextIO.readFile("JavaStuff\\Stuff\\files\\grid1.txt");
        String s = "";
        while (!TextIO.eof()) {
            s += TextIO.getln();
        }
        List<Object> jlist = new JSONArray(s).toList();
        //char[][] grid = Arrays.asList(jlist.stream().map(i -> ((ArrayList<String>) i)).map(n -> String.join("", n))
        //        .map(n -> n.toCharArray()).toArray()).stream().map(u -> (char[]) u).toArray(char[][]::new);
        
        char[][] grid = jlist.stream().map(i -> ((ArrayList<String>) i)).map(n -> String.join("", n))
                .map(n -> n.toCharArray()).toArray(char[][]::new);
        
        // char[][] theMap = new char[theMapObj.length][theMapObj.length];

        new Solution2().numIslands(grid);

        // System.out.println(Arrays.deepToString(theMap));

    }
}

class Solution2 {
    char[][] grid;
    boolean[][] visited;

    public Solution2() {

    }

    public int numIslands(char[][] grid) {
        this.grid = grid;
        visited = new boolean[grid.length][grid[0].length];
        int islandCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int[] index = new int[] { i, j };
                if (!visited[i][j] && grid[i][j] == '1') {
                    resolveIsland(index);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private void resolveIsland(int[] index) {
        int x = index[0];
        int y = index[1];
        visited[x][y] = true;
        if (grid[x][y] == '0')
            return;

        List<int[]> adjIndices = getAdj(index);
        for (int[] adjIndex : adjIndices) {
            resolveIsland(adjIndex);
        }

    }

    private List<int[]> getAdj(int[] index) {
        List<int[]> adjIndices = new ArrayList<int[]>();
        if (index[0] - 1 >= 0) {
            adjIndices.add(new int[] { index[0] - 1, index[1] });
        }

        if (index[0] + 1 < grid.length) {
            adjIndices.add(new int[] { index[0] + 1, index[1] });
        }

        if (index[1] - 1 >= 0) {
            adjIndices.add(new int[] { index[0], index[1] - 1 });
        }

        if (index[1] + 1 < grid.length) {
            adjIndices.add(new int[] { index[0], index[1] + 1 });
        }
        return adjIndices;
    }
}
