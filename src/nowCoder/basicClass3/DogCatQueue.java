package nowCoder.basicClass3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @authod xianCan
 * @date 2019/1/8 17:35
 *
 * 猫狗队列：
 *     实现一种狗猫队列的结构，要求如下： 用户可以调用add方法将cat类或dog类的实例放入队列中； 用户可以调用pollAll方法，将队列中所有的实例
 * 按照进队列的先后顺序依次弹出； 用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出； 用户可以调用pollCat方法，将队
 * 列中cat类的实例按照进队列的先后顺序依次弹出； 用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例； 用户可以调用isDogEmpty方法，
 * 检查队列中是否有dog类的实例； 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
 *
 * 两个队列，增加一个时间戳去判断猫还是狗先进出
 */
public class DogCatQueue {

    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue(){
        this.dogQ = new LinkedList<>();
        this.catQ = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet){
        if (pet.getType().equals("dog")){
            this.dogQ.add(new PetEnterQueue(pet, this.count++));
        } else if (pet.getType().equals("cat")){
            this.catQ.add(new PetEnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException("error, not dog or cat");
        }
    }

    public Pet pollAll(){
        if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()){
            if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()){
                return this.dogQ.poll().getPet();
            } else {
                return this.catQ.poll().getPet();
            }
        } else if (!this.dogQ.isEmpty()){
            return this.dogQ.poll().getPet();
        } else if (!this.catQ.isEmpty()){
            return this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("error, queue is empty");
        }
    }

    public Dog pollDog(){
        if (!this.isDogQueueEmpty()){
            return (Dog) this.dogQ.poll().getPet();
        } else {
            throw new RuntimeException("Dog queue is empty!");
        }
    }

    public Cat pollCat(){
        if (!this.isCatQueueEmpty()){
            return (Cat) this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("Cat queue is empty!");
        }
    }

    public boolean isEmpty(){
        return this.dogQ.isEmpty() && this.catQ.isEmpty();
    }

    public boolean isDogQueueEmpty(){
        return this.dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty(){
        return this.catQ.isEmpty();
    }


    public static class PetEnterQueue{
        private Pet pet;
        private long count;
        public PetEnterQueue(Pet pet, long count){
            this.pet = pet;
            this.count = count;
        }
        public Pet getPet(){
            return this.pet;
        }
        public long getCount(){
            return this.count;
        }
        public String getEnterPetType(){
            return this.pet.getType();
        }
    }

    /**
     * 宠物类
     */
    public static class Pet{
        private String type;
        public Pet(String type){
            this.type=type;
        }
        public String getType(){
            return this.type;
        }
    }
    /**
     * 狗
     */
    public static class Dog extends Pet{
        public Dog(){
            super("dog");
        }
    }
    /**
     * 猫
     */
    public static class Cat extends Pet{
        public Cat(){
            super("cat");
        }
    }
}
