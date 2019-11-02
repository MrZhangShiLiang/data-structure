package com.zsl.tree;

import com.zsl.tree.po.Person;

/**
 * @author zsl
 * @date 2019/9/17
 */
public class Node {
    Person person;
    Node left;
    Node right;

    @Override
    public String toString() {
        return "Node{" +
                "person=" + person +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
}
