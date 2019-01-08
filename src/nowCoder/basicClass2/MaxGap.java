package nowCoder.basicClass2;

/**
 * @authod xianCan
 * @date 2019/1/7 17:45
 *
 * 桶排序的应用
 *
 * 题目描述：
 *     给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O(N)，且要求不能用非基于比
 * 较的排序。
 */
public class MaxGap {
    /**
     *    这题的大体思路就是桶排序，但是，不需要全部排序，只需要大体有序，其实就是每个桶内的数不需要有序，接下来我将解释为什么桶内的数不需要排序。
     * n个任意的数，划分到n个桶里：
     *    首先第一种情况，如果恰好每个桶都只有一个数，划分后不就恰好有序了吗，有序这道题不就好解决了吗！
     *    另一种情况，在每个数数值范围非常大的时候也是很常见的，就是数不会均匀的落到每个桶中，这题的主要难点也在这。如何解决？ 想想看，在任意一个
     * 桶内任何情况下任意俩数的最大差值是多少，最大不就是桶的大小减一吗？ 但是，在全局中肯定存在两个桶，后面一个桶的最小值和前一个桶的最大值差值
     * 大于桶大小，且这两个桶之间不存在其他有数存在的桶。
     *
     *     其实我们只需要遍历次数组，找出最大最小值，然后安装最大最小值，将其他数划分到n个桶里。然后求连续两个非空桶i j的bucket[j].min - bucket[i].max
     * 的最大值即可。
     * @param nums
     * @return
     */
    public static int maxGap(int[] nums){
        if (nums == null || nums.length < 2) return 0;
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        if (min == max)
            return 0;
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int position = 0;
        for(int i=0;i<nums.length;i++){
            position = getPosition(nums[i], min, max, len);
            mins[position] = hasNum[position] ? Math.min(mins[position], nums[i]): nums[i];
            maxs[position] = hasNum[position] ? Math.max(maxs[position], nums[i]): nums[i];
            hasNum[position] = true;
        }
        int res=0;
        int lastMax = maxs[0];
        for (int i=1;i<hasNum.length;i++){
            if (hasNum[i]){
                res= Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    private static int getPosition(int num, int min, int max, int len){
        return ( (num-min) * len / (max-min) );
    }
}
