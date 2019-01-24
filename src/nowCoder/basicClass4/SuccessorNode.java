package nowCoder.basicClass4;

/**
 * @authod xianCan
 * @date 2019/1/23 16:29
 */
public class SuccessorNode {

    /**
     * 找到二叉树中某一个节点的后续节点
     *
     * 后续节点定义：二叉树中序遍历中某一个节点的后一个节点就是该节点的后续节点
     *
     * 思路：如果该节点存在右子节点，那么后续节点为右子节点的最左节点；
     * 如果不存在右子节点，那么一直找父节点，直到某一节点是它父节点的左孩子
     */
    public static Node getSuccessorNode(Node node){
        if (node == null) return null;
        //存在右节点的情况
        if (node.right != null){
            Node result = node.right;
            while (result.left != null){
                result = result.left;
            }
            return result;
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    /**
     * 工程上常用的树节点：有一个指针指向该节点的父节点
     */
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }
}
