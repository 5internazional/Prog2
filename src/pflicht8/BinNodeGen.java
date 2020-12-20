package pflicht8;

public class BinNodeGen<E> {
    E data;
    BinNodeGen<E> left, right;

    /**
     * Constructor for an empty binary tree node
     */
    BinNodeGen() {
        left = right = null;
    }

    /**
     * Constructor for a binary tree node with a value and without children
     *
     * @param d node data
     */
    BinNodeGen(E d) {
        data = d;
        left = right = null;
    }

    /**
     * Constructor for a binary tree node with a value and children
     *
     * @param d node data
     * @param l left child
     * @param r right child
     */
    BinNodeGen(E d, BinNodeGen<E> l, BinNodeGen<E> r) {
        data = d;
        left = l;
        right = r;
    }

    /**
     * @param data value to set in a node
     * @throws IllegalArgumentException when data is null
     */
    public void setData(E data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        this.data = data;
    }

    /**
     * @param left value to set in a left child of the node
     * @throws IllegalArgumentException when data is null
     */
    public void setLeft(BinNodeGen<E> left) throws IllegalArgumentException {
        if (left == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        this.left.data = left.data;
    }

    /**
     * @param right value to set in a right child of the node
     * @throws IllegalArgumentException when data is null
     */
    public void setRight(BinNodeGen<E> right) throws IllegalArgumentException {
        if (right == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        this.right.data = right.data;
    }

    @Override
    public String toString() {
        return "BinNodeGen{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
