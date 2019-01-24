package nowCoder.basicClass4;

import java.util.*;

/**
 * @authod xianCan
 * @date 2019/1/23 10:20
 *
 * 实现二叉树的先序、中序、后序遍历，包括递归方式和非递归方式
 */
public class PreInPosTraversal {

    /**
     * 前序遍历
     */
    public static void preOrderRecur(Node head){
        if (head == null)
            return;
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /**
     * 中序遍历
     */
    public static void inOrderRecur(Node head){
        if (head == null)
            return;
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    /**
     * 后序遍历
     */
    public static void posOrderRecur(Node head){
        if (head == null)
            return;
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    /**
     * 前序遍历非递归版本，需要一个栈
     */
    public static void preOrderUnRecur(Node head){
        if (head != null){
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.value + " ");
                //先存右边再存左边的子节点
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null){
                    stack.push(head.left);
                }
            }
        }
    }

    /**
     * 中序遍历非递归版本，需要一个栈
     */
    public static void inOrderUnRecur(Node head){
        if (head != null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
    }

    /**
     * 后序遍历非递归版本，需要一个栈
     * 首先用到前序遍历的方法，但是先存左节点，再存右节点，这样得到根右左的顺序，再整个翻转过来，就是左右根的顺序
     */
    public static void posOrderUnRecur(Node head){
        if (head != null){
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()){
                head = stack1.pop();
                stack2.push(head);
                System.out.print(head.value + " ");
                if (head.left != null){
                    stack1.push(head.left);
                } else {
                    stack1.push(head.right);
                }
            }
            while (stack2.isEmpty()){
                System.out.print(stack2.pop().value + " ");
            }
        }
    }

    /**
     * 按层遍历二叉树迭代版本：需要一个队列
     */
    public static void printByLevel(Node head){
        //记录当前打印行的最后节点
        Node last = head;
        //记录下一行的最后节点
        Node nextLast = head;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.print(head.value + " ");
            if (cur.left != null){
                queue.offer(cur.left);
                nextLast = cur.left;
            }
            if (cur.right != null){
                queue.offer(cur.right);
                nextLast = cur.right;
            }
            //如果遍历到了上一行的最后一个节点，换行并且把下一行的最后节点赋值给last
            if (cur == last){
                System.out.println();
                last = nextLast;
            }
        }
    }

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }
}
