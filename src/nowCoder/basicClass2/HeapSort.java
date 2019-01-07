package nowCoder.basicClass2;

/**
 * @authod xianCan
 * @date 2019/1/7 16:32
 *
 * 堆排序：时间复杂度O(N*logN)，额外空间复杂度O(1)
 *
 * 堆结构非常重要
 * 1，堆结构的heapInsert与heapify
 * 2，堆结构的增大和减少
 * 3，如果只是建立堆的过程，时间复杂度为O(N)
 * 4，优先级队列结构，就是堆结构
 */
public class HeapSort {
    /**
     * 堆排序
     * @param arr
     */
    public static void heapSort(int[] arr){
        if (arr == null || arr.length<2)return;
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0){
            heapify(arr,0, size);
            swap(arr,0,--size);
        }
    }

    /**
     * 建堆
     * @param arr
     * @param index
     */
    private static void heapInsert(int[] arr, int index){
        while (arr[index] > arr[(index-1)/2]){
            swap(arr, index, (index-1)/2);
            index = (index-1)/2;
        }
    }

    /**
     * 调整
     * @param arr
     * @param index
     * @param size
     */
    private static void heapify(int[] arr, int index, int size){
        int left = index * 2 + 1;
        while ( left < size){
            int largest = left+1 < size && arr[left+1] > arr[left] ? left+1:left;
            largest = arr[largest] >arr[index] ? largest:index;
            if (largest == index)
                break;
            swap(arr, largest, index);
            index = largest;
            left = index*2+1;
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
