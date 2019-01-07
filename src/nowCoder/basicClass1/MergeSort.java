package nowCoder.basicClass1;

/**
 * @authod xianCan
 * @date 2019/1/4 15:53
 */
public class MergeSort {
    /**
     * 归并排序，时间复杂度O(N*logN)，额外空间复杂度O(N)
     * @param arr
     */
    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2)return;
        mergeSort(arr, 0, arr.length-1);
    }

    private static void mergeSort(int[] arr, int left, int right){
        if (left==right)
            return;
        int middle = left+right >> 2;
        mergeSort(arr, left, middle);
        mergeSort(arr, middle+1, right);
        merge(arr, left, middle, right);
    }

    private static void merge(int[] arr, int left, int middle, int right){
        int[] temp = new int[right-left+1];
        int i=0,l=left,r=middle+1;
        while (l <=middle && r <=right){
            temp[i++] = arr[l]<arr[r]?arr[l++]:arr[r++];
        }
        while (l <= middle){
            temp[i++] = arr[l++];
        }
        while (r <= right){
            temp[i++] = arr[r++];
        }
        for (i=0;i<temp.length;i++){
            arr[left+i] = temp[i];
        }
    }
}
