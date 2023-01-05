/*
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] mat = {{0,0,0}, {0,1,0}, {1,1,1}};
        int[][] distance = updateMatrix(mat);
        for (int[] row : distance) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] distanse = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    distanse[i][j] = 0;
                } else {
                    distanse[i][j] = Integer.MAX_VALUE;
                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < n; l++) {
                            if (mat[k][l] == 0) {
                                distanse[i][j] = Math.min(distanse[i][j], Math.abs(i - k) + Math.abs(j - l));
                            }
                        }
                    }
                }
            }
        }
        return distanse;
    }
}
