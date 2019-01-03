package nowCoder.basicClass1;

/**
 * @author xianCan
 * @date 2019/1/3 0:07
 */
public class BubbleSort {
    /**
     * 冒泡排序，时间复杂度O(N^2)，额外空间复杂度O(1)
     * 工程上已基本不使用
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length<2) return;
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
