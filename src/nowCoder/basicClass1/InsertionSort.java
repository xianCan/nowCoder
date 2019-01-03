package nowCoder.basicClass1;

/**
 * @authod xianCan
 * @date 2019/1/3 14:16
 */
public class InsertionSort {
    /**
     * 插入排序，时间复杂度O(N^2)，额外空间复杂度O(1)
     * 工程上会在数组相对有序时使用，比如java内置排序就是先使用快排，再使用插排
     * @param arr
     */
    public static void insertionSort(int[] arr){
        if (arr==null || arr.length<2)return;
        for (int i=1;i<arr.length;i++){
            for (int j=i-1;j>=0 && arr[j]>arr[j+1];j--){
                swap(arr, j, j+1);
            }
        }
    }

    private static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
