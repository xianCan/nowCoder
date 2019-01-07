package nowCoder.basicClass2;

import nowCoder.basicClass1.SmallNum;

/**
 * @authod xianCan
 * @date 2019/1/7 14:47
 */
public class QuickSort {
    /**
     * 随机快排，时间复杂度0(N*logN)，额外空间复杂度0(logN)
     * @param arr
     */
    public static void quickSort(int[] arr){
        if (arr ==null || arr.length<2)return;
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr,int l, int r){
        if (l<r){
            int pivot = l + (int)(Math.random() * (r-l+1));
            swap(arr, pivot, r);
            int[] partition = partition(arr, l, r);
            quickSort(arr, l, partition[0]-1);
            quickSort(arr, partition[1]+1, r);
        }
    }

    private static int[] partition(int[] arr, int l, int r){
        int less = l-1;
        int more = r;
        while (l<more){
            if (arr[l] < arr[r])
                swap(arr, ++less, l++);
            else if (arr[l] > arr[r])
                swap(arr, --more, l);
            else l++;
        }
        swap(arr, r, more);
        return new int[]{less+1, more};
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int[] ints = new int[]{2,3,6, 5};
        quickSort(ints);
        for (int i: ints)
            System.out.println(i);
    }
}
