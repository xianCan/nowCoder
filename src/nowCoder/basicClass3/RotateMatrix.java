package nowCoder.basicClass3;

/**
 * @authod xianCan
 * @date 2019/1/10 9:30
 *
 * 旋转正方形矩阵
 * 【题目】 给定一个整型正方形矩阵matrix，请把该矩阵调整成顺时针旋转90度的样子。
 *
 * 【要求】 额外空间复杂度为O(1)。
 */
public class RotateMatrix {
    public static void rotateMatrix(int[][] matrix){
        int upR = 0;
        int upC = 0;
        int downR = matrix.length - 1;
        int downC = matrix[0].length - 1;
        while (upR < downR){
            rotateMatrix(matrix, upR++, upC++, downR--, downC--);
        }
    }

    private static void rotateMatrix(int[][] matrix,int upR, int upC, int downR, int downC){
        int curR = upR;
        int curC = upC;
        int i=0;
        while (i < downC-upC){
            int temp = matrix[curR][curC+i];
            matrix[curR][curC+i] = matrix[downR-i][curC];
            matrix[downR-i][curC] = matrix[downR][downC-i];
            matrix[downR][downC-i] = matrix[curR+i][downC];
            matrix[curR+i][downC] = temp;
            i++;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotateMatrix(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }
}
