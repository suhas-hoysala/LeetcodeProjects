package Common;

import java.util.*;
import org.json.*;
import textio.*;

public class ImportJson {
    public static char[][] getCharMatrix(String filename) {
        String s = readFileData(filename);
        List<Object> jlist = new JSONArray(s).toList();
        // char[][] grid = Arrays.asList(jlist.stream().map(i -> ((ArrayList<String>)
        // i)).map(n -> String.join("", n))
        // .map(n -> n.toCharArray()).toArray()).stream().map(u -> (char[])
        // u).toArray(char[][]::new);

        char[][] grid = jlist.stream().map(i -> ((ArrayList<String>) i)).map(n -> String.join("", n))
                .map(n -> n.toCharArray()).toArray(char[][]::new);
        return grid;
    }

    public static Integer[][] getIntMatrix(String filename) {
        String s = readFileData(filename);
        List<Object> jlist = new JSONArray(s).toList();
        var grid = jlist.stream().map(i -> ((ArrayList<Integer>) i)).map(i -> i.toArray(new Integer[] {}))
                .toArray(Integer[][]::new);
        return grid;
    }

    public static Integer[] getIntList(String filename) {
        String s = readFileData(filename);
        List<Object> jlist = new JSONArray(s).toList();

        return jlist.stream().map(i -> (Integer) i).toArray(Integer[]::new);
    }

    public static int[][] intFromInt(Integer[][] fromArray) {
        int[][] retArray = new int[fromArray.length][];
        int i = 0;
        for (Integer[] x : fromArray) {
            int[] newArray = new int[x.length];
            int j = 0;
            for (int y : x)
                newArray[j++] = y;
            retArray[i++] = newArray;
        }
        return retArray;
    }

    public static Integer[][] intFromInt(int[][] fromArray) {
        Integer[][] retArray = new Integer[fromArray.length][];
        int i = 0;
        for (int[] x : fromArray) {
            Integer[] newArray = new Integer[x.length];
            int j = 0;
            for (int y : x)
                newArray[j++] = y;
            retArray[i++] = newArray;
        }
        return retArray;
    }

    public static String readFileData(String filename) {
        TextIO.readFile("files\\" + filename);
        String s = "";
        while (!TextIO.eof()) {
            s += TextIO.getln();
        }
        return s;
    }

}
