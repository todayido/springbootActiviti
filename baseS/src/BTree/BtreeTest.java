package BTree;

import java.util.Arrays;

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return " name:" + this.name + " age：" + this.age;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

/**
 * @Description: 删除就会引起平衡问题，平衡为题就会出现红黑树问题，红黑树调整问题。
 */
class BinaryTree<T extends Comparable<T>> {
    class Node {
        private Comparable<T> data;
        private Node parent;
        private Node left;
        private Node right;

        public Node(Comparable<T> data) {
            this.data = data;
        }

        public void addNode(Node newNode) {
            if (newNode.data.compareTo((T) this.data) <= 0) {
                if (this.left == null) {// 现在没有左子树
                    this.left = newNode;// 保存左子树
                    newNode.parent = this; //保存父节点
                } else {
                    this.left.addNode(newNode);//继续向下判断
                }
            } else {
                if (this.right == null) {
                    this.right = newNode;
                    this.parent = this;
                } else {
                    this.right.addNode(newNode);
                }
            }
        }

        public void toArrayNode() {
            if (this.left != null) {
                this.left.toArrayNode();
            }
            BinaryTree.this.returnData[BinaryTree.this.foot++] = this.data;
            if (this.right != null) {
                this.right.toArrayNode();
            }
        }
    }

    //实现
    private Node root;
    private int count = 0;
    private Object[] returnData;
    private int foot = 0;

    void addNode(Comparable<T> data) {
        if (data == null) {
            throw new NullPointerException("数据不能为空。");
        }

        Node newNode = new Node(data);

        if (this.root == null) {
            this.root = newNode;
        } else {
            this.root.addNode(newNode);
        }

        this.count++;
    }


    public Object[] toArray() {
        if (this.count == 0) {
            return null;
        }
        this.returnData = new Object[this.count];
        this.foot = 0;
        this.root.toArrayNode();
        return this.returnData;
    }
}

public class BtreeTest {
    public static void main(String[] args) {
        BinaryTree<Person> tree = new BinaryTree<>();
        tree.addNode(new Person("zhangsan", 20));
        tree.addNode(new Person("lisi", 22));
        tree.addNode(new Person("wangwu", 16));
        tree.addNode(new Person("maliu", 90));
        tree.addNode(new Person("zhaoqi", 89));
        System.out.println(Arrays.toString(tree.toArray()));
    }
}
