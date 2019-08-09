package com.moses.structure;

/**
 * 双向链表
 */
public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private class Node{
        private Object data;
        private Node next;
        private Node prev;

        public Node(Object data){
            this.data = data;
        }
    }

    public DoublyLinkedList(){
        size = 0;
        head = null;
        tail = null;
    }

    public void addHead(Object value){
        Node newNode = new Node(value);
        if(size == 0){
            head = newNode;
            tail = newNode;
            size++;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    public void addTail(Object value){
        Node newNode = new Node(value);
        if(size == 0){
            head = newNode;
            tail = newNode;
            size++;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public Node deleteHead(){
        Node tmp = head;
        if(size != 0){
            head = head.next;
            head.prev = null;
            size--;
        }
        return tmp;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void display(){
        if(size == 0){
            System.out.println("[]");
            return;
        }
        Node node = head;
        int tmpSize = size;
        if(tmpSize == 1){
            System.out.println("[" + node.data + "]");
            return;
        }
        while(tmpSize >0){
            if(node.equals(head)){
                System.out.print("[" + node.data + "->");
            } else if(node.next == null){
                System.out.print(node.data + "]");
            } else {
                System.out.print(node.data + "->");
            }
            node = node.next;
            tmpSize--;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        DoublyLinkedList ll = new DoublyLinkedList();
        ll.addHead(5);
        ll.addTail(3);
        ll.addHead(4);
        ll.addHead(2);
        ll.addTail(8);
        ll.display();
        System.out.println(ll.deleteHead().data);
        ll.display();
    }
}
