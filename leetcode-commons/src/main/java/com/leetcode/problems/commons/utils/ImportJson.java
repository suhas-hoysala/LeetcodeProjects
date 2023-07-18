package com.leetcode.problems.commons.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class ImportJson {

    private static final Gson GSON = new Gson();
    private static final TypeToken<List<Object>> LIST_OBJECT_TOKEN = new TypeToken<>() {};
    public static char[][] getCharMatrix(String filename) {
        String s = readFileData(filename);
        List<Object> jlist = GSON.fromJson(s, LIST_OBJECT_TOKEN);
        // char[][] grid = Arrays.asList(jlist.stream().map(i -> ((ArrayList<String>)
        // i)).map(n -> String.join("", n))
        // .map(n -> n.toCharArray()).toArray()).stream().map(u -> (char[])
        // u).toArray(char[][]::new);

        char[][] grid = jlist.stream().map(i -> ((ArrayList<String>) i)).map(n -> String.join("", n))
                .map(String::toCharArray).toArray(char[][]::new);
        return grid;
    }

    public static Integer[][] getIntMatrix(String filename) {
        String s = readFileData(filename);
        List<Object> jlist = GSON.fromJson(s, LIST_OBJECT_TOKEN);
        var grid = jlist.stream().map(i -> ((ArrayList<Integer>) i)).map(i -> i.toArray(new Integer[] {}))
                .toArray(Integer[][]::new);
        return grid;
    }

    public static Integer[] getIntList(String filename) {
        String s = readFileData(filename);
        List<Object> jlist = GSON.fromJson(s, LIST_OBJECT_TOKEN);

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
        StringBuilder s = new StringBuilder();
        try (InputStream is = ImportJson.class.getClassLoader().getResourceAsStream("files/" + filename)) {
            try (InputStreamReader streamReader =
                         new InputStreamReader(is, StandardCharsets.UTF_8);
                 BufferedReader reader = new BufferedReader(streamReader)) {

                String line;
                while ((line = reader.readLine()) != null) {
                    s.append(line).append("\n");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return s.toString();
    }

}
