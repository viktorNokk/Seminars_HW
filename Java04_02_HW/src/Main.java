import java.util.Stack;

public class Main {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, stackDfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int stackDfs(int[][] grid, int i, int j) {
        int area = 0;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            i = cell[0];
            j = cell[1];
            if (i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] != 1) {
                continue;
            }
            grid[i][j] = 0;
            area++;
            stack.push(new int[]{i - 1, j});
            stack.push(new int[]{i + 1, j});
            stack.push(new int[]{i, j - 1});
            stack.push(new int[]{i, j + 1});
        }

        return area;
    }
}