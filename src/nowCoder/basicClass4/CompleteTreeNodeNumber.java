package nowCoder.basicClass4;

/**
 * @authod xianCan
 * @date 2019/1/25 13:41
 *
 * 已知一棵完全二叉树，求其节点的个数
 *
 * 要求：时间复杂度低于O(N)，N为这棵树的节点
 *
 * 思路：因为满树的节点数=2^h−1
 *     如果一个节点的右子树的最左节点到达完全二叉树的最后一层，则左子树为满树，节点个数等于左子树的节点数+递归求右子树的节点数+本节点，
 * 如果此节点的右子树的最左节点没有到完全二叉树的最后一层，则右子树为满树，节点个数等于右子树的节点数+递归求左子树的节点+本节点。
 */
public class CompleteTreeNodeNumber {

    public static int nodeNum(Node head){
        if (head == null) return 0;
        return bs(head, 1, mostLeftHeight(head, 1));
    }

    /**
     * 递归方法
     * @param head 头节点
     * @param l 头节点的右孩子的最左孩子所在的层数
     * @param height 总层数
     * @return
     */
    private static int bs(Node head, int l, int height){
        if (l == height)
            return 1;
        if (mostLeftHeight(head.right, l + 1) == height){
            return (1 << (height-1)) + bs(head.right, l+1, height);
        } else {
            return (1 << (height-l-1)) + bs(head.left, l+1, height);
        }
    }

    /**
     * 获得头节点右孩子的最左孩子所在的层数
     * @param head
     * @param level
     * @return
     */
    private static int mostLeftHeight(Node head, int level){
        while (head != null){
            level++;
            head = head.left;
        }
        return level-1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));

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
