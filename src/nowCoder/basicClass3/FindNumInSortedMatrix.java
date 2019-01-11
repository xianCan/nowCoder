package nowCoder.basicClass3;

/**
 * @authod xianCan
 * @date 2019/1/11 9:30
 *
 * 在行列都排好序的矩阵中找数
 * 【题目】 给定一个有N*M的整型矩阵matrix和一个整数K，matrix的每一行和每一 列都是排好序的。实现一个函数，判断K是否在matrix中。
 *
 * 例如： 0 1 2 5 2 3 4 7 44 4 8 5 7 7 9 如果K为7，返回true；如果K为6，返回false。
 *
 * 【要求】 时间复杂度为O(N+M)，额外空间复杂度为O(1)。
 */
public class FindNumInSortedMatrix {
    /**
     * 从右上或者左下开始比较，每次排除一某一列的数
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumInSortedMatrix(int[][] matrix, int target){
        if (matrix.length <1 ) return false;
        int row = 0;
        int col = matrix[0].length-1;
        while (row < matrix.length && col > -1){
            if (matrix[row][col] == target){
                return true;
            }
            //如果比目标值大，直接列减1
            else if (matrix[row][col] > target){
                col--;
            }
            //如果比目标值小，行加1
            else {
                row++;
            }
        }
        return false;
    }
}
