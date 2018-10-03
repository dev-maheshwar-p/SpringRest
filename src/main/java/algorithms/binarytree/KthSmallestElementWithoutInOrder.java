package algorithms.binarytree;


public class KthSmallestElementWithoutInOrder {

        private Node rootNode;

        public static void main(String[] args) {
            new KthSmallestElementWithoutInOrder();
        }

        public KthSmallestElementWithoutInOrder() {
            addNode(rootNode, 40);
            addNode(rootNode, 20);
            addNode(rootNode, 60);
            addNode(rootNode, 10);
            addNode(rootNode, 30);
            addNode(rootNode, 50);
            addNode(rootNode, 70);

            printTreeInOrder(rootNode);

            int kthSmallestElement = findKthSmallestItem(rootNode, 2);

            if(kthSmallestElement!=-1){
                System.out.println("Kth smallest node is :"+kthSmallestElement);
            }else{
                System.out.println("Kth smallest node is not found");
            }
        }

        private int findKthSmallestItem(Node rootNode, int k) {
            if(rootNode==null){
                return -1; //Indication that kth smallest is not found.
            }

            int childCount = getNodeCount(rootNode.getLeft());

            if(childCount+1==k){ // +1 for rootNode itself
                return rootNode.getData();

            }else if(childCount+1>=k){
                return findKthSmallestItem(rootNode.getLeft(), k);
            }else{
                return findKthSmallestItem(rootNode.getRight(), k - (childCount+1));
            }
        }

        private int getNodeCount(Node node){
            if(node == null){
                return 0;
            }
            int left = getNodeCount(node.getLeft());
            int right = getNodeCount(node.getRight());
            System.out.println(1 + left + right);

            return 1 + left + right;
        }

        private void printTreeInOrder(Node rootNode){
            if(rootNode==null)
                return;
            printTreeInOrder(rootNode.getLeft());
            System.out.print(rootNode.getData() + " ");
            printTreeInOrder(rootNode.getRight());
        }

        private void addNode(Node rootNode, int data){
            if(rootNode==null){
                Node temp1 = new Node(data);
                this.rootNode=temp1;
            }else{
                addNodeInProperPlace(rootNode, data);
            }
        }
        private void addNodeInProperPlace(Node rootNode, int data){
            if(data>rootNode.getData()){
                if(rootNode.getRight()!=null){
                    addNode(rootNode.getRight(), data);
                }else{
                    Node temp1 = new Node(data);
                    rootNode.setRight(temp1);
                }
            }else if(data<rootNode.getData()){
                if(rootNode.getLeft()!=null){
                    addNode(rootNode.getLeft(), data);
                }else{
                    Node temp1 = new Node(data);
                    rootNode.setLeft(temp1);
                }
            }
        }


    class Node{

        private Node left;
        private Node right;
        private int data;

        public Node(int data){
            this.data=data;
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

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
}
