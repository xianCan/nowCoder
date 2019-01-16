package nowCoder.basicClass3;

import java.util.HashMap;

/**
 * @authod xianCan
 * @date 2019/1/11 17:30
 *
 * 题目描述：
 *     复制含有随机指针节点的链表
 *
 *     Node类中的value是节点值，next指针和正常单链表中next指针的意义一样，都指向下一个节点，rand指针是Node类中新增的指针，这个指针可能指向链
 * 表中的任意一个节点，也可能指向null。 给定一个由Node节点类型组成的无环单链表的头节点head，请实现一个 函数完成这个链表中所有结构的复制，并返
 * 回复制的新链表的头节点。
 *
 * 进阶：
 *     不使用额外的数据结构，只用有限几个变量，且在时间复杂度为 O(N) 内完成原问题要实现的函数。
 */
public class CopyListWithRandom {
    /**
     * 使用额外空间HashMap的方法
     * @param head 头节点
     * @return
     */
    public static Node copyListWithRandom(Node head){
        if (head == null ) return null;
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (cur != null){
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 不使用额外空间的方法
     * @param node 头节点
     * @return
     */
    public static Node copyListWithRandomWithoutOtherMemory(Node head){
        if (head == null) return null;
        Node cur = head;
        Node next = null;
        // copy node and link to every node
        while (cur != null){
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur= next;
        }
        cur = head;
        Node curCopy = null;
        // set copy node rand
        while (cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        Node res = head.next;
        cur = head;
        // split
        while (cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

    /**
     * 复杂链表
     */
    public static class Node {
        public int value;
        public Node next;
        public Node rand;
        public Node(int data) { this.value = data; }
    }
}
