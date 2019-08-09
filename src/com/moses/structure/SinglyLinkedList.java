package com.moses.structure;

/**
 * 单向链表
 * 尾部操作麻烦 - 需要遍历到尾部，再
 */
public class SinglyLinkedList {
    private int size;
    private Node head;

    public SinglyLinkedList() {
        size = 0;
        head = null;
    }

    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    //在链表头添加元素
    public Object addHead(Object obj) {
        Node newHead = new Node(obj);
        if (size == 0) {
            this.head = newHead;
        } else {
            newHead.next = head;
            this.head = newHead;
        }
        size++;
        return obj;
    }

    //在链表头删除元素
    public Object deleteHead() {
        if (size == 0) {
            System.out.println("空链表，无数据.");
            return null;
        }
        Object obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    //查找指定元素，找到了返回节点Node，找不到返回null
    public Node find(Object obj) {
        Node current = head;
        int tmpSize = size;
        while (tmpSize > 0) {
            if (obj.equals(current.data)) {
                return current;
            } else {
                current = current.next;
            }
            tmpSize--;
        }
        return null;
    }

    //删除指定的元素，删除成功返回True
    public boolean delete(Object value) {
        if (size == 0) {
            return false;
        }
        Node current = head;
        Node previous = head;
        while (current.data != value) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }
        //如果删除的是第一个节点
        if (current == head) {
            head = current.next;
            size--;
        } else {
            previous.next = current.next;
            size--;
        }
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        if (size > 0) {
            Node node = head;
            int tmpSize = size;
            if (tmpSize == 1) {
                System.out.println("[" + node.data + "]");
                return;
            }
            while (tmpSize > 0) {
                if (node.equals(head)) {
                    System.out.print("[" + node.data + "->");
                } else if (node.next == null) {
                    System.out.print(node.data + "]");
                } else {
                    System.out.print(node.data + "->");
                }
                node = node.next;
                tmpSize--;
            }
            System.out.println();
        } else {
            System.out.println("[]");
        }
    }

    //查询链表的中间节点
    public Node searchMid(){
        Node p1 = head;
        Node p2 = head;
        //一个走一步，一个走两步，直到null，走一步的即到达中间节点
        while(p2 != null && p2.next != null && p2.next.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    //通过递归从尾到头输出链表
    public void printListReversely(Node node){
        if(node != null){
            printListReversely(node.next);
            if(node.data != null){
                System.out.print(node.data + " ");
            }
            if(node == head){
                System.out.println();
            }
        }
    }

    //反转链表
    public void reverseList(){
        Node pre = null;
        Node cur = head;
        while(cur != null){
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head = pre;
    }

    public static void main(String[] args) {
        SinglyLinkedList ll = new SinglyLinkedList();
        ll.addHead("A");
        ll.addHead("B");
        ll.addHead("C");
        ll.addHead("D");
        ll.printListReversely(ll.head);

        ll.display();
        ll.delete("C");
        ll.display();

        ll.addHead("E");
        ll.display();
        ll.reverseList();
        ll.display();


        System.out.println(ll.find("B"));
    }
}
