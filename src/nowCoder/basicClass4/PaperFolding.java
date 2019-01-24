package nowCoder.basicClass4;

/**
 * @authod xianCan
 * @date 2019/1/24 10:56
 *
 * 折纸问题
 *
 * 【题目】 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，压出折痕后展开。此时 折痕是凹下去的，即折痕突起的方向
 *          指向纸条的背面。如果从纸条的下边向上方连续对折2 次，压出折痕后展开，此时有三条折痕，从上到下依次是下折痕、下折痕
 *          和上折痕。给定一 个输入参数N，代表纸条都从下边向上方连续对折N次，请从上到下打印所有折痕的方向。
 *
 * 例如：N=1时，打印： down；N=2时，打印： down down up
 */
public class PaperFolding {
    /**
     * 实质是打印一棵二叉树
     */
    public static void paperFolding(int num){
        print(1, num, true);
    }

    private static void print(int i, int num, boolean down){
        if (i > num)
            return;
        print(i+1, num, true);
        System.out.print(down ? "down " : "up ");
        print(i+1, num, false);
    }
}
