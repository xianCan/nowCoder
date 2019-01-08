package nowCoder.basicClass3;

import java.util.Stack;

/**
 * @authod xianCan
 * @date 2019/1/8 17:01
 *
 * 题目描述：
 *     实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 *
 * 【要求】
 * 1．pop、push、getMin操作的时间复杂度都是O(1)。
 * 2．设计的栈类型可以使用现成的栈结构
 *
 * 定义两个栈可以实现
 */
public class GetMinStack {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int num){
        stack1.push(num);
        if (stack2.size()==0)
            stack2.push(num);
        else{
            if ( num <= stack2.peek()){
                stack2.push(num);
            }
        }
    }

    public int pop(){
        int temp= stack1.pop();
        if (temp == stack2.peek()){
            stack2.pop();
        }
        return temp;

    }

    public int getMin(){
        return stack2.peek();
    }
}
