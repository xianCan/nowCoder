package nowCoder.basicClass3;

/**
 * @authod xianCan
 * @date 2019/1/11 15:43
 *
 * 判断一个链表是否为回文结构
 * 【题目】 给定一个链表的头节点head，请判断该链表是否为回文结构。
 *
 * 例如： 1->2->1，返回true。 1->2->2->1，返回true。15->6->15，返回true。 1->2->3，返回false。
 *
 * 注：用栈可以简单地实现，不过空间复杂度为O(N)。
 * 进阶： 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1)。
 */
public class IsPalindromeList {
    /**
     * 先快慢指针找到链表的中点，然后将后半部分链表反转，再比较
     * @param head 头节点
     * @return
     */
    public boolean isPalindromeList(Node head){
        if (head == null || head.next == null)
            return true;
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;
        n1.next = null;
        Node n3 = null;
        while (n2 != null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 =n3;
        }
        n3 = n1;
        n2 = head;
        boolean res = true;
        while (n1 != null && n2 != null){
            if (n1.value != n2.value){
                res =false;
                break;
            }
            n1 =n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
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
}
