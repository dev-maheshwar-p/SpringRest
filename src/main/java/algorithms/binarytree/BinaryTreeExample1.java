package algorithms.binarytree;

public class BinaryTreeExample1 {

    private class BinaryTree<T>{

        Node<T> root;

        public BinaryTree(T data){
            root = new Node<>(data);
        }

        public BinaryTree(){
            root = null;
        }

        private class Node<T>{

            T data;

            public T getData() {
                return data;
            }

            public void setData(T data) {
                this.data = data;
            }

            public Node getLeft() {
                return left;
            }

            public void setLeft(Node left) {
                this.left = left;
            }

            public Node getRight() {
                return right;
            }

            public void setRight(Node right) {
                this.right = right;
            }

            Node left, right;

            public Node(T data) {
                this.data = data;
                left = right = null;
            }
        }

        public Node<T> insert(Node root, T data){
            Node currentNode = root, previousNode = null;

            boolean isLeftChild = false;
            while(currentNode!=null){

                String sLocalData = String.valueOf(data);
                String sCurrentNodeData = String.valueOf(currentNode.data);


                if(sLocalData.equalsIgnoreCase(sCurrentNodeData)){
                    throw new IllegalArgumentException("The value supplied is already present");
                }

                previousNode = currentNode;

                if(sLocalData.compareTo(sCurrentNodeData) < 1){
                    currentNode = previousNode.left;
                    isLeftChild = true;
                }else{
                    currentNode = previousNode.right;
                    isLeftChild = false;
                }
            }

            Node newNode = new Node(data);

            if(root==null){
                this.root = newNode;
                return root;
            }

            if(isLeftChild){
                previousNode.left = newNode;
            }else{
                previousNode.right = newNode;
            }

            return newNode;
        }
    }




    public static void main(String[] args) {
        BinaryTreeExample1 bte = new BinaryTreeExample1();
        BinaryTree bt = bte.new BinaryTree("Root Node");
        BinaryTree bt2 = bte.new BinaryTree();

        //bt.root.left = bt.new Node("Node Root/Left");
        //bt.root.right = bt.new Node("Node Root/Right");
//
//
//      System.out.println(bt.root.data);
//      System.out.println(bt.root.left.data);
//      System.out.println(bt.root.right.data);

        bt.insert(bt.root,20);
        bt.insert(bt.root,10);
        bt.insert(bt.root,30);

        bt2.insert(bt2.root,"root");


        System.out.println(bt.root.data);
        System.out.println(bt.root.left.data);
        System.out.println(bt.root.left.left.data);
        System.out.println(bt.root.left.right.data);

        System.out.println(bt2.root.data);


    }
}
