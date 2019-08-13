package com.moses.structure;

public class BinaryTree {
    private Node root;      //根节点

    //查找节点
    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.data > key) {
                //当前值比查找值大，搜索左子树
                current = current.leftChild;
            } else if (current.data < key) {
                //当前值比查找值小，搜索右子树
                current = current.rightChild;
            } else {
                return current;
            }
        }
        return null;
    }

    //插入节点
    public boolean insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            //树为空，没有任何节点
            root = newNode;
            return true;
        }

        Node current = root;
        Node parentNode = null;
        while (current != null) {
            parentNode = current;
            if (current.data > data) {
                //当前值比插入值大，搜索左子节点
                current = current.leftChild;
                if (current == null) {
                    //如果左子节点为空，直接将新值插入到该节点
                    parentNode.leftChild = newNode;
                    return true;
                }
            } else {
                current = current.rightChild;
                if (current == null) {
                    //右子节点为空，直接将新值插入到该节点
                    parentNode.rightChild = newNode;
                    return true;
                }
            }
        }
        return false;
    }

    //中序遍历：左子树 -> 根节点 -> 右子树
    public void inorderTraversal(Node current) {
        if (current != null) {
            inorderTraversal(current.leftChild);
            System.out.println(current.data + " ");
            inorderTraversal(current.rightChild);
        }
    }

    //前序遍历: 根节点 -> 左子树 -> 右子树
    public void preorderTraversal(Node current) {
        if (current != null) {
            System.out.println(current.data + " ");
            preorderTraversal(current.leftChild);
            preorderTraversal(current.rightChild);
        }
    }

    //后序遍历: 左子树 -> 右子树 -> 根节点
    public void postorderTraversal(Node current) {
        if (current != null) {
            postorderTraversal(current.leftChild);
            postorderTraversal(current.rightChild);
            System.out.println(current.data + " ");
        }
    }

    //找到最大值
    public Node findMax() {
        Node current = root;
        Node maxNode = current;
        while (current != null) {
            maxNode = current;
            current = current.rightChild;
        }
        return maxNode;
    }

    //找到最小值
    public Node findMin() {
        Node current = root;
        Node minNode = current;
        while (current != null) {
            minNode = current;
            current = current.leftChild;
        }
        return minNode;
    }

    //删除节点
    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;
        //查找删除值，找不到直接返回false
        while (current.data != key) {
            parent = current;
            if (current.data > key) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }

        //如果当前节点没有子节点
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
            return true;
        } else if (current.leftChild == null && current.rightChild != null) {
            //当前节点有一个子节点- 右子节点
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
            return true;
        } else if (current.leftChild != null && current.rightChild == null) {
            //当前节点有一个子节点 - 左子节点
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
            return true;
        } else {
            //当前节点存在两个子节点
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return false;
    }

    public Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        //后继节点不是删除节点的右子节点，将后继节点替换删除节点
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(50);
        bt.insert(20);
        bt.insert(80);
        bt.insert(10);
        bt.insert(30);
        bt.insert(60);
        bt.insert(90);
        bt.insert(25);
        bt.insert(85);
        bt.insert(100);
        bt.inorderTraversal(bt.root);
        bt.delete(10);//删除没有子节点的节点
        bt.delete(30);//删除有一个子节点的节点
        bt.delete(80);//删除有两个子节点的节点
        System.out.println(bt.findMax().data);
        System.out.println(bt.findMin().data);
        System.out.println(bt.find(100));
        System.out.println(bt.find(200));
    }
}

class Node {
    int data;       //节点数据
    Node leftChild;
    Node rightChild;
    boolean isDelete;

    public Node(int data) {
        this.data = data;
    }

    public void display() {
        System.out.println(data);
    }
}