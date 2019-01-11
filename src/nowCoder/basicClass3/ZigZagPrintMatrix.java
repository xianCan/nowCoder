package nowCoder.basicClass3;

/**
 * @authod xianCan
 * @date 2019/1/10 14:45
 *
 * “之”字形打印矩阵
 * 【题目】 给定一个矩阵matrix，按照“之”字形的方式打印这个矩阵，
 *
 * 例如： 1 2 3 4 5 6 7 8 9 10 11 12，“之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11，8，12
 *
 * 【要求】 额外空间复杂度为O(1)。
 */
public class ZigZagPrintMatrix {
    public static void zigZagPrintMatrix(int[][] matrix){
        int leftR = 0;
        int leftC = 0;
        int rightR = 0;
        int rightC = 0;
        boolean direction = true;
        while (leftR <= matrix.length-1 || leftC <= matrix[0].length-1){
            printMatrix(matrix, leftR, leftC, rightR, rightC, direction);
            direction = !direction;
            if (leftR == matrix.length-1){
                leftC++;
            }else if (leftR < matrix.length-1){
                leftR++;
            }
            if (rightC == matrix[0].length-1){
                rightR++;
            }else if (rightC < matrix[0].length-1){
                rightC++;
            }
            if (leftR == matrix.length-1 && leftC == matrix[0].length-1){
                System.out.print(matrix[leftR][leftC]);
                break;
            }
        }
    }

    private static void printMatrix(int[][] matrix, int leftR, int leftC, int rightR, int rightC, boolean direction){
        if (direction){
            int curR = leftR;
            int curC = leftC;
            while (curR >= rightR){
                System.out.print(matrix[curR--][curC++]+" ");
            }
        } else {
            int curR = rightR;
            int curC = rightC;
            while (curR <= leftR){
                System.out.print(matrix[curR++][curC--]+" ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        zigZagPrintMatrix(matrix);
    }
}
