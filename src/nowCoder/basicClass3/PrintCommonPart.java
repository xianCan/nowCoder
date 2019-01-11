package nowCoder.basicClass3;

/**
 * @authod xianCan
 * @date 2019/1/11 13:38
 *
 * 打印两个有序链表的公共部分
 *
 * 【题目】 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
 */
public class PrintCommonPart {
    /**
     *
     * @param head1
     * @param head2
     */
    public void printCommonPart(Node head1, Node head2){
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1 != null && cur2 != null){
            if (cur1.value == cur2.value){
                System.out.print(cur1.value+" ");
                cur1 = cur1.next;
            } else if (cur1.value > cur2.value){
                cur2 = cur2.next;
            } else {
                cur1 = cur1.next;
            }
        }
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
