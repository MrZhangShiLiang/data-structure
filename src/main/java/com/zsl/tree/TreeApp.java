package com.zsl.tree;

import com.zsl.tree.po.Person;

/**
 * @author zsl
 * @date 2019/9/17
 */
public class TreeApp {
    Node root;

    public Node find(Person person){
        Node node = root;

        while (person.getAge()!=node.person.getAge()){
            if (person.getAge()>node.person.getAge()){
                node = node.right;
            }else {
                node = node.left;
            }
            if (null == node){
                return null;
            }
        }
        return node;
    }

    public void insert(Node needInsert){
        if (null == root){
            root = needInsert;
        }else {
            Node current = root;
            Node parent;
            while (true){
                parent = current;
                if (needInsert.person.getAge()<current.person.getAge()){
                    current = current.left;
                    if (null == current) {
                        parent.left = needInsert;
                    }
                }else {
                    current = current.right;
                    if (null == current){
                        parent.right = needInsert;
                    }
                }
            }
        }
    }


    //树的删除操作很复杂，一般可以设置一个变量，isDel=true，来表示已经删除

    public TreeApp() {
    }

    public TreeApp(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
