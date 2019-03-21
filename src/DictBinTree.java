public class DictBinTree implements Dict{

    private Node root;
    private int[] orderedTree;
    private int treeSize = 0;
    private boolean treeInitiated;

    public int[] getOrderedTree(){
        return this.orderedTree;
    }

    @Override
    public void insert(int k) {
        this.treeSize++;

        Node z = new Node(k);
        Node y = null;
        Node x = this.root;

        while(x != null){
            y = x;
            if(z.getKey() < x.getKey()) x = x.getLeft();
            else x = x.getRight();
        }

        z.setParent(y);
        if (y == null) this.root = z;
        else if (z.getKey() < y.getKey()) y.setLeft(z);
        else y.setRight(z);
    }

    @Override
    public int[] orderedTraversal() {
        int[] ordered = this.inorderTreeWalk(this.root);
        this.treeSize = ordered.length;
        this.treeInitiated = false; //If orderedTraversel is called again on the same tree, the treesize has to be adjusted again
        return ordered;
    }

    private int[] inorderTreeWalk(Node x){
        if (treeInitiated == false){
            this.orderedTree = new int[treeSize];
            this.treeInitiated = true;
        }
        if (x != null){
            inorderTreeWalk(x.getLeft());
            this.orderedTree[this.orderedTree.length - this.treeSize--] = x.getKey();
            inorderTreeWalk(x.getRight());
        }
        return this.orderedTree;
    }

    @Override
    public boolean search(int k) {
        if (treeSearch(this.root, k) == null) return false;
        return true;
    }

    private Node treeSearch(Node x, int k){
        if((x == null) || k == x.getKey()) return x;
        if (k < x.getKey()) return treeSearch(x.getLeft(), k);
        else return treeSearch(x.getRight(), k);
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
