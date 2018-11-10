package algorithms.binarytree;/* Iterative Java program for merge sort */

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeExample1<T> {

    Node root;
    static Queue<BinaryTreeExample1.Node> queue = new PriorityQueue<>();

    static Stack<BinaryTreeExample1.Node> stack = new Stack<>();


    BinaryTreeExample1(){
        root = null;
    }

    BinaryTreeExample1(T data){
        root = new Node(data);
    }

    class Node implements  Comparable{

        T data;
        Node left, right;

        public Node(T data) {
            this.data = data;
            this.left = this.right = null;
        }

        @Override
        public int compareTo(Object o) {
            return 1;
        }
    }


    /* Driver program to test above functions */
    public static void main(String[] args) {
        BinaryTreeExample1<String> tabt = new BinaryTreeExample1();
        BinaryTreeExample1.Node root = tabt.new Node("100");
        tabt.root = root;

        tabt.insert(tabt.root, "200");
        tabt.insert(tabt.root, "50");

        tabt.insert(tabt.root, "30");
        tabt.insert(tabt.root, "40");

        tabt.insert(tabt.root, "190");
        tabt.insert(tabt.root, "210");


        printInOrderTraversalWithStack(tabt.root);

        System.out.println("********************");

        printInOrderTraversal(tabt.root);
//
//        tabt.delete(tabt.root, "50");
//
//        printInOrderTraversal(tabt.root);

//        printLevelOrderTraversal(tabt.root);


//        System.out.println(root.data);
//        System.out.println(root.left.data);
//
//        System.out.println(root.left.left.data);
//        System.out.println(root.left.left.right.data);
//
//        System.out.println(root.right.data);
//        System.out.println(root.right.left.data);
//        System.out.println(root.right.right.data);


//        System.out.println(tabt.getInOrderSuccessor(tabt.root, tabt.root).data);
//        System.out.println(tabt.getInOrderSuccessor(tabt.root, tabt.root.left).data);
//        System.out.println(tabt.getInOrderSuccessor(tabt.root, tabt.root.left.left).data);
//        System.out.println(tabt.getInOrderSuccessor(tabt.root, tabt.root.left.left.right).data);
//        System.out.println(tabt.getInOrderSuccessor(tabt.root, tabt.root.right).data);
//        System.out.println(tabt.getInOrderSuccessor(tabt.root, tabt.root.right.left).data);
//        System.out.println(tabt.getInOrderSuccessor(tabt.root, tabt.root.right.right).data);

        System.out.println();

    }

    private static void printInOrderTraversalWithStack(BinaryTreeExample1.Node root) {

        BinaryTreeExample1.Node currentNode = root;

        while(!(stack.size()==0) || currentNode !=null){

            while(currentNode!=null){
                stack.push(currentNode);
                currentNode=currentNode.left;
            }

            currentNode = stack.pop();
            System.out.println(currentNode.data);

            currentNode = currentNode.right;
        }

    }

    private static void printLevelOrderTraversal(BinaryTreeExample1.Node root){

        queue.add(root);


        while(!queue.isEmpty()){
            BinaryTreeExample1.Node cn = queue.poll();
            System.out.println(cn.data);

            if(cn.left!=null){
                queue.add(cn.left);
            }if(cn.right!=null){
                queue.add(cn.right);
            }
        }

    }

    private static void printInOrderTraversal(BinaryTreeExample1.Node root) {

        if(root==null) return;

        printInOrderTraversal(root.left);
        System.out.println(root.data);
        printInOrderTraversal(root.right);
    }


    Node minValue(Node node) {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private static void printPreOrderTraversal(BinaryTreeExample1.Node root) {

        if(root==null) return;

        System.out.println(root.data);
        printPreOrderTraversal(root.left);
        printPreOrderTraversal(root.right);
    }


    private static void printPostOrderTraversal(BinaryTreeExample1.Node root) {

        if(root==null) return;

        printPostOrderTraversal(root.left);
        printPostOrderTraversal(root.right);
        System.out.println(root.data);
    }

    private Node delete(Node root, T data) {

        Object[] resultsArr = findNode(root, data);

        Node currentNode = (Node)resultsArr[2], previousNode = (Node) resultsArr[1];
        boolean isLeftDataNode = (boolean) resultsArr[0];

//        Node currentNode = root, previousNode = null;
//
//        if (root == null) return root;
//
//
//        boolean isLeftDataNode = false;
//        boolean isLessThan = isLessThan(currentNode.data.toString(), data.toString());
//
//        previousNode = currentNode;
//
//        if (isLessThan) {
//            isLeftDataNode = true;
//            currentNode.left = delete(currentNode.left, data);
//        } else if (!isLessThan && !currentNode.data.toString().equalsIgnoreCase(data.toString())){
//            isLeftDataNode = false;
//            currentNode.right = delete(currentNode.right, data);
//        }
//        else if(!isLessThan && currentNode.data.toString().equalsIgnoreCase(data.toString())){

            /*
                Case 1 : Where Node to be deleted has no child sub tree [Leaf Node]
             */
            if(currentNode.left == null && currentNode.right == null){
                previousNode.left = null;
                previousNode.right = null;
                currentNode = null;
            }
            /*
                Case 2 : Where Node to be deleted has 1 child in right sub tree
             */
            else if(currentNode.left == null && currentNode.right != null){
                previousNode.right = currentNode.right;
                currentNode = null;
            }
            /*
                Case 3 : Where Node to be deleted has 1 child in left sub tree
             */
            else if(currentNode.left != null  && currentNode.right == null){
                previousNode.left = currentNode.left;
                currentNode = null;
            }

            /*
                Case 4 : Where Node to be deleted has 2 children [has a sub tree as a child]
             */

            else if(currentNode.left != null && currentNode.right != null){
                if(isLeftDataNode){
                    previousNode.left = getInOrderSuccessor(root, currentNode);
                    currentNode = null;
                }else if (!isLeftDataNode){
                    previousNode.right = getInOrderSuccessor(root, currentNode);
                    currentNode = null;
                }
            }
//        }

        return currentNode;
    }

    private Object[] findNode(Node root, T data) {

        Node currentNode = root, previousNode=null;

        boolean isLeft = true;

        while(currentNode!=null){

            if(isLessThan(data.toString(), currentNode.data.toString())){
                previousNode = currentNode;
                currentNode = currentNode.left;
                isLeft = true;
            } else if(!(isLessThan(data.toString(), currentNode.data.toString()))
                && !(data.toString().equalsIgnoreCase(currentNode.data.toString()))){
                previousNode = currentNode;
                currentNode = currentNode.right;
                isLeft = false;
            }else if(!(isLessThan(data.toString(), currentNode.data.toString()))
                    && (data.toString().equalsIgnoreCase(currentNode.data.toString()))){
                break;
            }
        }
        Object[] resultArr = new Object[3];
        resultArr[0] = isLeft;
        resultArr[1] = previousNode;
        resultArr[2] = currentNode;


        return resultArr;
    }

    private Node getInOrderSuccessor(Node root, Node dataNode) {

        Node currentNode = root, previousNode = null;

        if(dataNode.right!=null){
            return minValue(dataNode.right);
        }

        while(root!=null) {

            boolean isLessThan = isLessThan(dataNode.data.toString(), root.data.toString());

            if (isLessThan) {
                previousNode = root;
                root = root.left;
            } else if (!isLessThan) {
                root = root.right;
            } else
                break;
        }

        return previousNode;

    }

    private Node insert(Node root, T data) {
        Node currentNode = root, previousNode = null;

        boolean isLeftChild = true;
        String newData = data.toString();

        while(currentNode!=null){

            String nodeData = currentNode.data.toString();

            if (nodeData.equalsIgnoreCase(newData)) {
                throw new IllegalArgumentException("This is duplicate value in the tree");
            }

            previousNode = currentNode;

            boolean isLessThan = isLessThan(newData, nodeData);

            if(isLessThan){
                currentNode = previousNode.left;
                isLeftChild = true;
            }else{
                currentNode = previousNode.right;
                isLeftChild = false;
            }

        }

        Node node = new BinaryTreeExample1.Node(newData);

        if(this.root == null){
            root = node;

            return root;
        }

        if(isLeftChild){
            previousNode.left = node;
        }else{
            previousNode.right = node;
        }

        return node;
    }

    private boolean isLessThan(String newData, String nodeData) {


        boolean sLocalIsDigit = NumberUtils.isDigits(newData);
        boolean sCurrentIsDigit = NumberUtils.isDigits(nodeData);

        BigInteger intLocalData,intCurrentNodeData;
        boolean isLessThan = false;

            /*
                To compare numeric strings compareTo doesnt work out of the box.
             */

        if(sLocalIsDigit && sCurrentIsDigit){
            intLocalData = new BigInteger(newData);
            intCurrentNodeData = new BigInteger(nodeData);

            isLessThan = intLocalData.compareTo(intCurrentNodeData) < 0;
        }else{
            isLessThan = newData.compareTo(nodeData) < 0;
        }

        return isLessThan;
    }
}