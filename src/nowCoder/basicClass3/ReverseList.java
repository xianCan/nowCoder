package nowCoder.basicClass3;

/**
 * @authod xianCan
 * @date 2019/1/10 14:12
 *
 * 反转单向和双向链表
 * 【题目】 分别实现反转单向链表和反转双向链表的函数。
 *
 * 【要求】 如果链表长度为N，时间复杂度要求为O(N)，额外空间复杂度要求为O(1)
 */
public class ReverseList {
    /**
     * 反转单链表
     * @param head
     * @return
     */
    public static Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 反转双向链表
     * @param head
     * @return
     */
    public static DoubleNode reverseList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
    /**
     * 单链表
     */
    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }
    }

    /**
     * 双向链表
     */
    public static class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data){
            this.value = data;
        }
    }
}
