package com.moses.structure.hashtable;

/**
 * 哈希表 - 链地址法
 * 每个单元连接链表，数据存在链表中
 */
public class HashTableChain {
    private SortLink[] hashArray;//数组中存放链表
    private int arraySize;
    public HashTableChain(int size){
        arraySize = size;
        hashArray = new SortLink[arraySize];
        //new 出每个空链表初始化数组
        for(int i = 0 ; i < arraySize ; i++){
            hashArray[i] = new SortLink();
        }
    }

    public void displayTable(){
        for(int i = 0 ; i < arraySize ; i++){
            System.out.print(i + "：");
            hashArray[i].displayLink();
        }
    }

    public int hashFunction(int key){
        return key%arraySize;
    }

    public void insert(LinkNode node){
        int key = node.getKey();
        int hashVal = hashFunction(key);
        hashArray[hashVal].insert(node);//直接往链表中添加即可
    }

    public LinkNode delete(int key){
        int hashVal = hashFunction(key);
        LinkNode temp = find(key);
        hashArray[hashVal].delete(key);//从链表中找到要删除的数据项，直接删除
        return temp;
    }

    public LinkNode find(int key){
        int hashVal = hashFunction(key);
        LinkNode node = hashArray[hashVal].find(key);
        return node;
    }


    class SortLink {
        private LinkNode first;
        public SortLink(){
            first = null;
        }
        public boolean isEmpty(){
            return (first == null);
        }
        public void insert(LinkNode node){
            int key = node.getKey();
            LinkNode previous = null;
            LinkNode current = first;
            while(current != null && current.getKey() < key){
                previous = current;
                current = current.next;
            }
            if(previous == null){
                first = node;
            }else{
                previous.next = node;
            }
            node.next = current;
        }
        public void delete(int key){
            LinkNode previous = null;
            LinkNode current = first;
            if(isEmpty()){
                System.out.println("Linked is Empty!!!");
                return;
            }
            while(current != null && current.getKey() != key){
                previous = current;
                current = current.next;
            }
            if(previous == null){
                first = first.next;
            }else{
                previous.next = current.next;
            }
        }

        public LinkNode find(int key){
            LinkNode current = first;
            while(current != null && current.getKey() <= key){
                if(current.getKey() == key){
                    return current;
                }
                current = current.next;
            }
            return null;
        }

        public void displayLink(){
            System.out.println("Link(First->Last)");
            LinkNode current = first;
            while(current != null){
                current.displayLink();
                current = current.next;
            }
            System.out.println("");
        }
    }

    class LinkNode{
        private int iData;
        public LinkNode next;
        public LinkNode(int iData){
            this.iData = iData;
        }
        public int getKey(){
            return iData;
        }
        public void displayLink(){
            System.out.println(iData + " ");
        }
    }

}