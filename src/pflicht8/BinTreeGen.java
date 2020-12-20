package pflicht8;

public class BinTreeGen<E extends Comparable<E>> implements BinTreeGenInterface<E> {
    private StringBuilder sb = new StringBuilder();

    private BinNodeGen<E> root;

    /**
     * Constructor for a binary tree, that sets the root to null
     */
    public BinTreeGen() {
        root = null;
    }

    /**
     * Constructor for a binary tree, that sets the root to a specified root node
     *
     * @param rn root node
     */
    public BinTreeGen(BinNodeGen<E> rn) {
        root = rn;
    }

    @Override
    public boolean insertNode(E item) {
        if (root == null) {
            root = new BinNodeGen<>(item);
            return true;
        } else
            return insertNode(root, item);
    }

    /**
     * inserts node into a tree recursively, no similar items are supported
     *
     * @param node root node of a tree for traversal
     * @param item value of the node to be added into a tree
     * @return true if added successfully, false - if not
     */
    private boolean insertNode(BinNodeGen<E> node, E item) {
        if (item.compareTo(node.data) < 0) {
            if (node.left != null) {
                insertNode(node.left, item);
            } else {
                node.left = new BinNodeGen<>(item);
                return true;
            }
        } else if (item.compareTo(node.data) > 0) {
            if (node.right != null) {
                insertNode(node.right, item);
            } else {
                node.right = new BinNodeGen<>(item);
                return true;
            }
        }
        return false;
    }

    @Override
    public int countNodes(BinNodeGen<E> k) {
        int counter = 0;
        if (k != null) {
            counter = countNodes(k.left) + countNodes(k.right) + 1;
        }
        return counter;
    }

    @Override
    public int countNodes() {
        return countNodes(root);
    }


    @Override
    public BinNodeGen<E> find(E item) {
        return find(root, item);
    }

    /**
     * searches the given value of a node in a binary tree and returns the node
     *
     * @param k root node to start a traversal with
     * @param item value to be find in a tree nodes
     * @return a tree node if it was found
     */
    private BinNodeGen<E> find(BinNodeGen<E> k, E item) {
        if (k != null) {
            if (item.compareTo(k.data) == 0) {
                return k;
            } else {
                if (item.compareTo(k.data) < 0) {
                    return find(k.left, item);
                } else if (item.compareTo(k.data) > 0) {
                    return find(k.right, item);
                }
            }
        }
        return new BinNodeGen<>();
    }

    @Override
    public String toString() {
        if (root == null)
            return "null";
        else
            return print(root);
    }

    @Override
    public String print(BinNodeGen<E> b) {
        if (b == null) {
            return "null";
        } else {
            if (b.left != null) {
                print(b.left);
            }
            sb.append("\n");
            sb.append(b.data);
            sb.append("\n");

            if (b.right != null) {
                print(b.right);
            }
            return sb.toString();
        }
    }
    //Getter

    public BinNodeGen<E> getRoot() {
        return root;
    }

//    public int countBooksUntil(BinNodeGen<E> k, int year){
//        if(k.data<year)
//        if (k == null)
//            return 0;
//        if (k.data.compareTo(year)<= 0) {
//            int count = 1 + (k.left == null ? 0 : AntiquarBuecher.countNodes(k.left));
//            if (k.data.getJahr() == year)
//                return count;
//            return count + countBooksUntil(k.right, year);
//        } else return countBooksUntil(k.left, year);
//    }
}
