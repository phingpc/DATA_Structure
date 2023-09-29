/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week9.laps.binarysearchtree;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author PHinG Jakkaphat
 */
public class BST {

    static void inorder(DefaultMutableTreeNode root) {
        if (root != null) {
            if (root.getChildCount() > 0) {
                inorder(root.getNextNode()); // left recursion
            }
            if (Integer.parseInt(root.toString()) != 0) {
                System.out.print(root + " ");
            }
            if (root.getChildCount() > 1) {
                inorder(root.getNextNode().getNextSibling()); // right recursion
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {4, 7, 6, 2, 8, 5, 3, 10, 1, 9}; // test 1 = 5,3,4,2,1 test 2 = 2,5,1,7,3,4,6
        //test 3 = 4, 7, 6, 2, 8, 5, 3, 10, 1, 9 test 4 = 1, 10, 8, 5, 7, 2, 9, 4, 6, 3
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(data[0]); // node root ของต้นไม้ -- root ตัวแรก
        DefaultMutableTreeNode p = root; // node อ้างอิง node root เพื่อใช้ในการท่องไปในต้นไม้
        //////////////////////////////////////////////
        //////////////////////////////////////////////
        //////////////////////////////////////////////
        for (int i = 1; i < data.length; i++) {
            while (true) {
                if (p.getChildCount() == 0) {
                    if (data[i] < Integer.parseInt(p.toString())) {
                        p.add(new DefaultMutableTreeNode(data[i]));
                        p.add(new DefaultMutableTreeNode(0));
                        break;
                    } else {
                        p.add(new DefaultMutableTreeNode(0));
                        p.add(new DefaultMutableTreeNode(data[i]));
                        break;
                    }
                } else if (p.getChildCount() == 2) {
                    if (Integer.parseInt(p.toString()) > data[i]) {
                        if (Integer.parseInt(p.getChildAt(0).toString()) == 0) {
                            p.getNextNode().setUserObject(data[i]);
                            break;
                        } else {
                            p = (DefaultMutableTreeNode) p.getChildAt(0);
                        }
                    } else {
                        if (Integer.parseInt(p.getChildAt(1).toString()) == 0) {
                            p.getNextNode().getNextSibling().setUserObject(data[i]);
                            break;
                        } else {
                            p = (DefaultMutableTreeNode) p.getChildAt(1);
                        }
                    }
                }
            }
            p = root;
        }
        //////////////////////////////////////////////
        //////////////////////////////////////////////
        //////////////////////////////////////////////
        System.out.println("Depth : " + root.getDepth() + " total node : " + data.length);
        System.out.print("inorder : ");
        inorder(root);
        //////////////////////////////////////////////
        //////////////////////////////////////////////
        //////////////////////////////////////////////
        System.out.println("");
        System.out.print("breadthfristsearch : ");
        Enumeration<DefaultMutableTreeNode> bfs = root.breadthFirstEnumeration();
        while (bfs.hasMoreElements()) {
            //System.out.print(bfs.nextElement() + " ");
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) bfs.nextElement();
            if (Integer.parseInt(node.getUserObject().toString()) != 0) {
                System.out.print(node + " ");
            }
        }
        //////////////////////////////////////////////
        //////////////////////////////////////////////
        //////////////////////////////////////////////
        System.out.println("");
        System.out.print("preorder : ");
        Enumeration<DefaultMutableTreeNode> pod = root.preorderEnumeration(); // สำหรับ preorder
        while (pod.hasMoreElements()) {
            //System.out.print(bfs.nextElement() + " ");
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) pod.nextElement();
            if (Integer.parseInt(node.getUserObject().toString()) != 0) {
                System.out.print(node + " ");
            }
        }
        //////////////////////////////////////////////
        //////////////////////////////////////////////
        //////////////////////////////////////////////
        
    }

}
