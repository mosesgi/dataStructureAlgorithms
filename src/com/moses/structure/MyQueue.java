package com.moses.structure;

/**
 * 循环队列
 * 当队尾到数组最大值后，绕到开始的位置，从0开始
 */
public class MyQueue<T> {
    private T[] queArray;
    private int maxSize;
    private int front;
    private int rear;
    private int nItems;

    public MyQueue(int size){
        maxSize = size;
        queArray = (T[])new Object[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public boolean isFull(){
        return nItems == maxSize;
    }

    public boolean isEmpty(){
        return nItems==0;
    }

    public int getSize(){
        return nItems;
    }

    public void insert(T value){
        if(isFull()){
            System.out.println("队列已满！");
        } else {
            //如果队列尾部指向顶了，那么循环回来，指向队列的第一个元素
            if(rear == maxSize - 1){
                rear = -1;
            }
            //队尾指针加1，然后在队尾指针处插入新的数据
            queArray[++rear] = value;
            nItems++;
        }
    }

    public T remove(){
        T removeValue = null;
        if(!isEmpty()){
            removeValue = queArray[front];
            queArray[front] = null;
            front++;
            if(front == maxSize){
                front = 0;
            }
            nItems--;
            return removeValue;
        }
        return removeValue;
    }

    public T peekFront(){
        return queArray[front];
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>(3);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);

        System.out.println(queue.peekFront());  //1
        queue.remove();
        System.out.println(queue.peekFront());  //2

        queue.insert(4);
        queue.insert(5);    //队列已满

    }

}
