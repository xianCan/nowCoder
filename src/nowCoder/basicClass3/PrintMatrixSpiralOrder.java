package nowCoder.basicClass3;

/**
 * @authod xianCan
 * @date 2019/1/9 14:12
 *
 * 转圈打印矩阵
 * 【题目】 给定一个整型矩阵matrix，请按照转圈的方式打印它。
 *
 * 例如： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 打印结果为：1，2，3，4，8，12，16，15，14，13，9，5，6，7，11， 10
 *
 * 【要求】 额外空间复杂度为O(1)。
 */
public class PrintMatrixSpiralOrder {

    public static void spiralOrderPrint(int[][] matrix) {
        int upR = 0;
        int upC = 0;
        int downR = matrix.length - 1;
        int downC = matrix[0].length-1;
        while (upR < downR){
            printEdge(matrix, upR++, upC++, downR--, downC--);
        }
    }

    private static void printEdge(int[][] matrix, int upR, int upC, int downR, int downC){
        if (upR == downR){
            for (int i=upC;i<=downC;i++){
                System.out.println(matrix[upR][i]);
            }
        }else if (upC == downC){
            for (int i=upR;i<=downR;i++){
                System.out.println(matrix[i][upC]);
            }
        }else {
            int curC = upC;
            int curR = upR;
            while (curC != downC){
                System.out.print(matrix[upR][curC] +" ");
                curC++;
            }
            while (curR != downR){
                System.out.print(matrix[curR][downC] +" ");
                curR++;
            }
            while (curC != upC){
                System.out.print(matrix[downR][curC] +" ");
                curC--;
            }
            while (curR != upR){
                System.out.print(matrix[curR][upC] +" ");
                curC--;
            }
        }
    }
}
