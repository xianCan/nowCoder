package nowCoder.basicClass2;

import nowCoder.basicClass1.SmallNum;

/**
 * @authod xianCan
 * @date 2019/1/7 14:12
 *
 * 荷兰国旗问题：
 *     给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，等于num的数放在数组的中间
 * 大于num的数放在数组的右边。
 *
 * 要求额外空间复杂度0(1)，时间复杂度0(N)
 */
public class NetherlandsFlag {
    /**
     * 本质就是快排
     * @param arr 数组
     * @param l 左边界
     * @param r 右边界
     * @param p 等于的数
     * @return
     */
    public static int[] partition(int[] arr, int l, int r, int p){
        int less = l-1;
        int more = r+1;
        while (l<more){
            if (arr[l]<p)
                swap(arr, ++less, l++);
            else if(arr[l] > p)
                swap(arr, --more, l);
            else l++;
        }
        return new int[] { less + 1, more - 1 };
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){
        int i = new SmallNum().smallNum(new int[]{2,3,6, 5});
        System.out.println(i);
    }
}
