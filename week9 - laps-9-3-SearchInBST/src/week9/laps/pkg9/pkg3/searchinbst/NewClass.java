/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week9.laps.pkg9.pkg3.searchinbst;

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

    public Student(String a, String b, int c) {
        code = a;
        name = b;
        score = c;
    }
}

public class NewClass {

    public static void main(String[] args) {
        Student[] stu = new Student[5];
        /*stu[0] = new Student("001","JHS",3);
        stu[1] = new Student("005","ADM",5);
        stu[2] = new Student("002","IOT",1);
        stu[3] = new Student("004","ZXX",2);
        stu[4] = new Student("003","KDU",4);
         */
        stu[0] = new Student("003", "XWN", 5);
        stu[1] = new Student("002", "WIJ", 3);
        stu[2] = new Student("001", "DQX", 2);
        stu[3] = new Student("004", "LBE", 4);
        stu[4] = new Student("005", "CAW", 1);

        String key = "005"; // ค้นหา

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
        int found = 0; // ไว้ใช้ยืนยันว่าค้นหาเจอไหมแค่นั้น

        // วิธีที่ 1
        /*Enumeration<DefaultMutableTreeNode> EN = root.breadthFirstEnumeration(); // สำหรับ preorder
        while (EN.hasMoreElements()){
            p = EN.nextElement();
            if(Integer.parseInt(p.toString()) == Integer.parseInt(key.toString())){
                found = 1;
                break;
            }
        }
        if(found == 1){
            System.out.println(p);
        } else {
            System.out.println("Not found");
        }*/
        // วิธีที่ 2
        while (true) {
            if (Integer.parseInt(key.toString()) == Integer.parseInt(p.toString())) {
                found = 1;
                break;
            }
            if (Integer.parseInt(key.toString()) < Integer.parseInt(p.toString())) {
                p = p.getNextNode();
            }
            if (Integer.parseInt(key.toString()) > Integer.parseInt(p.toString())) {
                p = p.getNextNode().getNextSibling();
            }
        }
        if (found == 1) {
            for (int i = 0; i < stu.length; i++) {
                if (Integer.parseInt(stu[i].code) == Integer.parseInt(p.toString())) {
                    System.out.println(stu[i].code+" "+stu[i].name+" "+stu[i].score);
                }
            }
        } else {
            System.out.println("Not found");
        }
    }
}
