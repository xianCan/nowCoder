package nowCoder.basicClass3;

/**
 * @authod xianCan
 * @date 2019/1/8 15:17
 *
 * 用数组结构实现大小固定的队列和栈
 */
public class ArrayToStackQueue {
    /**
     * 数组实现固定大小的栈
     */
    public static class ArrayStack{
        private Integer[] arr;
        private Integer size;

        public ArrayStack(int initSize){
            if (initSize < 0){
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
        }

        public void push(int num){
            if (size == arr.length){
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            arr[size++] = num;
        }

        public Integer pop(){
            if (size == 0){
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            return arr[--size];
        }

        public Integer peek(){
            if (size == 0)return 0;
            return arr[size-1];
        }
    }

    /**
     * 数组实现固定大小的队列
     */
    public static class ArrayQueue{
        private Integer[] arr;
        private Integer size;
        private Integer first;
        private Integer last;

        public ArrayQueue(int initSize){
            if (initSize < 0)
                throw new IllegalArgumentException("The init size is less than 0");
            arr = new Integer[initSize];
            size = 0;
            first = 0;
            last = 0;
        }

        public Integer peek(){
            if (size ==0){
                return null;
            }
            return arr[first];
        }

        public void push(int num){
            if(size == arr.length){
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            size++;
            arr[last] = num;
            last = last == arr.length-1? 0: last+1;
        }

        public Integer poll(){
            if(size == 0){
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size--;
            int temp = arr[first];
            first = first ==arr.length-1?0:first+1;
            return temp;
        }
    }
}
