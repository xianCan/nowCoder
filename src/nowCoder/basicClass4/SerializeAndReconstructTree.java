package nowCoder.basicClass4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @authod xianCan
 * @date 2019/1/24 9:34
 *
 * 二叉树的序列化和反序列化
 */
public class SerializeAndReconstructTree {
    /**
     * 前序遍历的方式序列化二叉树
     */
    public static String serialByPre(Node head){
        if (head == null){
            return "#!";
        }
        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    /**
     * 反序列化一颗以前序遍历的方式序列化的二叉树
     */
    public static Node reconByPreString(String preStr){
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i=0; i != values.length; i++){
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    private static Node reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if ("#".equals(value))return null;
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }

    /**
     * 按层的方式序列化二叉树，需要一个队列
     */
    public static String serialByLevel(Node head){
        if (head == null)return "#!";
        String res = head.value + "!";
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            if (head.left != null){
                res += head.left.value + "!";
                queue.offer(head.left);
            } else {
              res += "#!";
            }
            if (head.right != null){
                res += head.right.value + "!";
                queue.offer(head.right);
            } else {
                res += "#!";
            }
        }
        return res;
    }

    /**
     * 按层遍历反序列化二叉树，需要一个队列
     */
    public static Node reconByLevelString(String levelStr){
        String[] values = levelStr.split("!");
        int i = 0;
        Node head = generateNodeByStr(values[i++]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        Node node = null;
        while (!queue.isEmpty()){
            node = queue.poll();
            node.left = generateNodeByStr(values[i++]);
            node.right = generateNodeByStr(values[i++]);
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return head;
    }

    private static Node generateNodeByStr(String str){
        if ("#".equals(str))
            return null;
        return new Node(Integer.valueOf(str));
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
