package com.stan.test;

/**
 * 纠正搜索二叉树 TODO WRONG!!!!
 *
 * Created by StanWang on 16/2/29.
 */
public class RecoverBinarySearchTree {


    //前驱缓存节点
    Node preNode;
    //第一个错误节点
    Node wrongNode1;
    //第二个错误节点
    Node wrongNode2;




    //使用递归的方式查找错误节点
    public void findErrorNode(Node root) {

        if(root == null){
            return;
        }

        findErrorNode(root.left);


        if(preNode == null){
            preNode = root;
        }else{

            if(preNode.value > root.value){
                if(wrongNode1 == null){
                    wrongNode1 = preNode;
                }
                wrongNode2 = root;
            }

            preNode = root;

        }

        findErrorNode(root.right);

    }


    public void recoverTree(Node tree){

        preNode = null;
        wrongNode1 = null;
        wrongNode2 = null;

        findErrorNode(tree);

        swap(wrongNode1,wrongNode2);
    }

    /**
     * 不使用交换值的方式恢复,交换节点引用,即需要替换节点的 父节点,左节点,右节点 的引用
     */
    private void swap(Node wrongNode1, Node wrongNode2) {

        if(wrongNode1 != null && wrongNode2 != null){

            Node temp = wrongNode1;



        }



    }

    public static void main(String[] args) throws CloneNotSupportedException {

        Node n2 = new Node(2,null,null);
        Node n3 = new Node(3,null,null);
        Node n1 = new Node(1,n2,n3);
        Node n0 = new Node(1,n1,null);


        Node b2 = new Node(2,null,null);
        Node b3 = new Node(3,null,null);
        Node b1 = new Node(1,b2,b3);
        Node b0 = new Node(1,b1,null);










    }
}

/**
 * 搜索二叉树节点
 */
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

}
