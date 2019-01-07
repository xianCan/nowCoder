package nowCoder.basicClass1;

/**
 * @authod xianCan
 * @date 2019/1/7 9:15
 *
 * 小和问题和逆序对问题，本质：归并排序的应用
 *
 * 小和问题：
 *     在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和
 *
 * 例子：
 * [1,3,4,2,5]
 * 1左边比1小的数，没有；
 * 3左边比3小的数，1；
 * 4左边比4小的数，1、3；
 * 2左边比2小的数，1；
 * 5左边比5小的数，1、3、4、2；
 * 所以小和为1+1+3+1+1+3+4+2=16
 *
 *
 * 逆序对问题：
 *     在一个数组中，左边的数如果比右边的数大，则这两个数构成一个逆序对，请打印所有逆序
 * 对。
 */
public class SmallNum {
    private int res = 0;
    /**
     * 归并排序过程中有一次比较大小，可以算出小和，
     * 注意：某个数比右边数组的某个数要小时，那么这个数比右边数组从这个数开始的所有数都要小，不要漏算
     * @param arr
     * @return
     */
    public int smallNum(int[] arr){
        if (arr == null || arr.length<2)return 0;
        split(arr,0,arr.length-1);
        return res;
    }

    private void split(int[] arr, int left, int right){
        if (left==right)return;
        int middle = (left+right)>>1;
        split(arr, left, middle);
        split(arr, middle+1, right);
        merge(arr, left, middle, right);
    }

    private void merge(int[] arr, int left, int middle, int right){
        int[] temp = new int[right-left+1];
        int p=left,q=middle+1,i=0;
        while (p <= middle && q<=right){
            if (arr[p]<arr[q]){
                temp[i++] = arr[p++];
                res += right - q +1;
            }else {
                temp[i++] = arr[q++];
            }
        }
        while (p<=middle){
            temp[i++] = arr[p++];
        }
        while (q<=right){
            temp[i++] = arr[q++];
        }
        for (i=0;i<temp.length;i++){
            arr[left+i] = temp[i];
        }
    }

    public static void main(String[] args){
        int i = new SmallNum().smallNum(new int[]{2,3,6, 5});
        System.out.println(i);
    }
}
