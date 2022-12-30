public class Main {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sc][sc];
        if (oldColor != color) {
            floodFillUtil(image, sr, sc, oldColor, color);
        }
        return image;
    }
    private void floodFillUtil (int[][] image, int row, int col, int oldColor, int color) {
        // если текущий пиксель выходит за пределы
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != oldColor) {
            return;
        }
        //установить текущий пиксель в новый цвет
        image[row][col] = color;

        floodFillUtil(image, row + 1, col, oldColor, color);
        floodFillUtil(image, row - 1, col, oldColor, color);
        floodFillUtil(image, row, col + 1, oldColor, color);
        floodFillUtil(image,row,col - 1, oldColor, color);

    }
}