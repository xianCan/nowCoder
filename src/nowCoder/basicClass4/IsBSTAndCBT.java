package nowCoder.basicClass4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @authod xianCan
 * @date 2019/1/24 14:16
 *
 * 判断一棵树是否是搜索二叉树、判断一棵树是否是完全二叉树
 */
public class IsBSTAndCBT {
    /**
     * 是否是搜索二叉树
     */
    public static boolean isBST(Node head){
        if (head == null)
            return true;
        return false;
    }

    /**
     * 是否是完全二叉树，广度优先的遍历思想，需要一个队列
     */
    public static boolean isCBT(Node head){
        if (head == null)return true;
        Queue<Node> queue = new LinkedList<>();
        //用于判断是否遍历到了叶子节点
        Node l = null, r = null;
        boolean leaf = false;
        queue.offer(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (l != null || r !=null)) || (l == null && r !=null))
                return false;
            if (l != null)
                queue.offer(l);
            if (r != null)
                queue.offer(r);
            //如果当前节点没有右孩子，那么往后bi的所有
            else
                leaf = true;
        }
        return true;
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
