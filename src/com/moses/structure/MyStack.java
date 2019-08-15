package com.moses.structure;

/**
 * 栈
 */
public class MyStack<T> {
    private T[] array;
    private int maxSize;
    private int top;

    public MyStack(int size){
        this.maxSize = size;
        array = (T[])new Object[size];
        top = -1;
    }

    public void push(T value){
        if(top < maxSize - 1){
            array[++top] = value;
        }
    }

    public T pop(){
        return array[top--];
    }

    public T peek(){
        return array[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == (maxSize - 1);
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<Integer>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek());

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }
}
