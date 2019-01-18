package nowCoder.basicClass3;

/**
 * @authod xianCan
 * @date 2019/1/16 17:06
 *
 * 两个单链表相交的一系列问题
 *     在本题中，单链表可能有环，也可能无环。给定两个单链表的头节点 head1和head2，这两个链表可能相交，也可能不相交。请实现一个函数，
 * 如果两个链表相交，请返回相交的第一个节点；如果不相交，返回null 即可。 要求：如果链表1的长度为N，链表2的长度为M，时间复杂度请达到
 * O(N+M)，额外空间复杂度请达到O(1)
 */
public class FindFirstIntersectNode {
    /**
     * 获得两个链表的第一个相交节点
     * @param head1 头节点1
     * @param head2 头节点2
     * @return
     */
    public static Node getIntersectNode(Node head1, Node head2){
        if (head1 == null || head2 == null)
            return null;
        Node loopNode1 = getLoopNode(head1);
        Node loopNode2 = getLoopNode(head2);
        //如果两个链表都没有环，则按照无环的情况，先让较长的链表先走与短链表的差值，然后两个一起走，走到相等的地方就是交点
        if (loopNode1 == null && loopNode2 == null){
            return  getIntersectWithoutLoop(head1, head2);
        }
        //如果两个链表都有环，如果环的入口节点不相等，则没有交点；如果相等，就把链表从环入口节点截断，看成两个无环链表求节点
        else if(loopNode1 !=null && loopNode2 != null){
            if (loopNode1 != loopNode2)return null;
            return getIntersectWithLoop(head1, head2, loopNode1);
        }
        //如果只有其中一个有环，另一个没有，则不可能有交点
        return null;
    }

    /**
     * 1.判断链表是否有环
     * 2.获得有环链表的第一个入口节点
     * @param head 头节点
     * @return
     */
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null)return null;
        Node slow = head.next, fast=head.next.next;
        while (slow != fast){
            if (fast.next == null || fast.next.next == null)return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 获得两无环链表的第一个交点
     * @param head1 头节点1
     * @param head2 头节点2
     * @return
     */
    public static Node getIntersectWithoutLoop(Node head1, Node head2){
        if (head1 == null || head2 == null)return null;
        int length1 = getListLength(head1, null);
        int length2 = getListLength(head2, null);
        if (length1 >= length2 ){
            return getIntersectWithoutLoop(head1, length1, head2, length2);
        }else{
            return getIntersectWithoutLoop(head2, length2, head1, length1);
        }
    }

    /**
     * 获得两有环链表的第一个交点
     * @param head1 头节点1
     * @param head2 头节点2
     * @param loopNode 环的入口节点
     * @return
     */
    public static Node getIntersectWithLoop(Node head1, Node head2, Node loopNode){
        if (head1 == null || head2 == null) return null;
        int length1 = getListLength(head1, loopNode);
        int length2 = getListLength(head2, loopNode);
        //这种情况下肯定有交点，直接调用私有无环方法
        if (length1 >= length2 ){
            return getIntersectWithoutLoop(head1, length1, head2, length2);
        }else{
            return getIntersectWithoutLoop(head2, length2, head1, length1);
        }
    }

    /**
     * 私有方法，获得两无环链表的第一个交点,默认length1>length2
     * @param head1 链表1的头节点
     * @param length1 链表1的长度
     * @param head2 链表2的头节点
     * @param length2 链表2的长度
     * @return
     */
    private static Node getIntersectWithoutLoop(Node head1, int length1, Node head2, int length2){
        int temp = length1-length2;
        Node cur1 = head1,cur2 = head2;
        while (temp > 0){
            cur1 = cur1.next;
            temp--;
        }
        while (cur1 != cur2){
            if (cur1 == null || cur2 == null)return null;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 获得一个链表的长度
     * @param head 头节点
     * @param stopNode 不需要那么长的长度，到这个节点就停止
     * @return
     */
    public static int getListLength(Node head, Node stopNode){
        Node cur = head;
        int length = 0;
        while (cur != stopNode && cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }

    /**
     * 单链表
     */
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
}
