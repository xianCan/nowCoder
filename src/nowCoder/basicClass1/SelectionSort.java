package nowCoder.basicClass1;

/**
 * @authod xianCan
 * @date 2019/1/3 13:57
 */
public class SelectionSort {
    /**
     * 选择排序，时间复杂度O(N^2)，额外空间复杂度O(1)
     * 工程上已基本不使用
     * @param arr
     */
    public static void selectionSort(int[] arr){
        if (arr == null || arr.length<2) return;
        for (int i=0;i<arr.length;i++){
            int minIndex = i;
            for (int j=i+1;j<arr.length;j++){
                minIndex = arr[j]<arr[i]?j:i;
            }
            swap(arr,i,minIndex);
        }
    }

    private static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
