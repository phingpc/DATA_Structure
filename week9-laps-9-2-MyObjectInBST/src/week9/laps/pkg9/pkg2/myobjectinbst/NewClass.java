/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week9.laps.pkg9.pkg2.myobjectinbst;

import java.util.Enumeration;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author PHinG Jakkaphat
 */

class Student {
    String code;
    String name;
    int score;
    public Student(String a,String b,int c) {
        code = a;
        name = b;
        score = c;
    }
}



public class NewClass {
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
        Student[] stu = new Student [3];
        /*stu[0] = new Student("001","JHS",3);
        stu[1] = new Student("005","ADM",5);
        stu[2] = new Student("002","IOT",1);
        stu[3] = new Student("004","ZXX",2);
        stu[4] = new Student("003","KDU",4);
        */
        stu[0] = new Student("002","BRT",2);
        stu[1] = new Student("003","IIM",3);
        stu[2] = new Student("001","GQP",1);
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(stu[0].code); // node root ของต้นไม้ -- root ตัวแรก
        DefaultMutableTreeNode p = root; // node อ้างอิง node root เพื่อใช้ในการท่องไปในต้นไม้
        //////////////////////////////////////////////
        //////////////////////////////////////////////
        //////////////////////////////////////////////
        for (int i = 1; i < stu.length; i++) {
            while (true) {
                if (p.getChildCount() == 0) {
                    if (Integer.parseInt(stu[i].code) < Integer.parseInt(p.toString())) {
                        p.add(new DefaultMutableTreeNode(stu[i].code));
                        p.add(new DefaultMutableTreeNode(0));
                        break;
                    } else {
                        p.add(new DefaultMutableTreeNode(0));
                        p.add(new DefaultMutableTreeNode(stu[i].code));
                        break;
                    }
                } else if (p.getChildCount() == 2) {
                    if (Integer.parseInt(p.toString()) > Integer.parseInt(stu[i].code)) {
                        if (Integer.parseInt(p.getChildAt(0).toString()) == 0) {
                            p.getNextNode().setUserObject(stu[i].code);
                            break;
                        } else {
                            p = (DefaultMutableTreeNode) p.getChildAt(0);
                        }
                    } else {
                        if (Integer.parseInt(p.getChildAt(1).toString()) == 0) {
                            p.getNextNode().getNextSibling().setUserObject(stu[i].code);
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
        System.out.println("Depth : " + root.getDepth() + " total node : " + stu.length);
        System.out.print("inorder : ");
        inorder(root);
        //////////////////////////////////////////////
        //////////////////////////////////////////////
        //////////////////////////////////////////////
        System.out.println("");
        System.out.print("breadthfristsearch : ");
        Enumeration<DefaultMutableTreeNode> bfs = root.breadthFirstEnumeration(); // สำหรับ breadthfirstsearch
        while (bfs.hasMoreElements()) {
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
