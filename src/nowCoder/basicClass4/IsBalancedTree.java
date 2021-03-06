package nowCoder.basicClass4;

/**
 * @authod xianCan
 * @date 2019/1/24 11:18
 */
public class IsBalancedTree {
    /**
     * 判断一棵二叉树是否是平衡二叉树
     */
    public static boolean isBalancedTree(Node head){
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 0, res);
        return res[0];
    }

    private static int getHeight(Node head, int height, boolean[] flag){
        if (head == null)
            return height;
        int leftHeight = getHeight(head.left, height+1, flag);
        if (!flag[0])
            return height;
        int rightHeight = getHeight(head.right, height+1, flag);
        if (!flag[0])
            return height;
        if (Math.abs(leftHeight-rightHeight) > 1 ){
            flag[0] = false;
        }
        return Math.max(leftHeight, rightHeight);
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
}
