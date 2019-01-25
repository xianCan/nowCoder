package nowCoder.basicClass4;

/**
 * @authod xianCan
 * @date 2019/1/25 13:41
 *
 * 已知一棵完全二叉树，求其节点的个数
 *
 * 要求：时间复杂度低于O(N)，N为这棵树的节点
 */
public class CompleteTreeNodeNumber {

    public static int nodeNum(Node head){
        if (head == null) return 0;
        return 0;
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
