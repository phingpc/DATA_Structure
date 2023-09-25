/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week7.laps.tree;

import java.util.Enumeration;
import java.util.Scanner;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author PHinG Jakkaphat
 */


public class NewClass {
    // ข้อ 7.3
    static void inorder (DefaultMutableTreeNode root) {
        if(root!=null) {
            if(root.getChildCount()>0){
                inorder(root.getNextNode());
            }
            System.out.print(root+",");
            if(root.getChildCount()>1) {
                inorder(root.getNextNode().getNextSibling());
            }
        }
    }
    
    
    
    public static void main(String[] args) {
        String[] a ={"PNAHJMS"};
        DefaultMutableTreeNode root_a = null;
        Enumeration<DefaultMutableTreeNode> enum1;
        // if (a.length == 1) ข้อมูลเป็นข้อมตวาม
        root_a = new DefaultMutableTreeNode(a[0].charAt(0));
        DefaultMutableTreeNode p_a = root_a;
        for(int i=1; i<a[0].length(); i++) {
            enum1 = root_a.breadthFirstEnumeration();
            for(int j=0; j<(i+1)/2; j++) {
                p_a = enum1.nextElement();
            }
            p_a.add(new DefaultMutableTreeNode(a[0].charAt(i)));
        }
        //แสดงผลลัพท์
        // getDepth() ความลึกของต้นไม้
        System.out.print(root_a.getDepth()+" "+a[0].length()+":");
        String ans = ""; // เตรียม string สำหรับใส่ข้อมูล
        enum1 = root_a.breadthFirstEnumeration();
        for(int i=0; i<a[0].length(); i++){
            ans += enum1.nextElement()+"-";
        }
        System.out.print(ans.substring(0, ans.length()-1)+""); // substring เอา - ตัวสุดท้ายออก
        //ผลลัพท์ 2 7:P-N-A-H-J-M-S
        System.out.println("");
        
        // ข้อมูลที่เป็นตัวเลข
        int[] b = {4,2,5,1,3};
        DefaultMutableTreeNode root_b = null;
        Enumeration<DefaultMutableTreeNode> enum2;
        root_b = new DefaultMutableTreeNode(b[0]);
        DefaultMutableTreeNode p_b = root_b;
        for(int i=1; i<b.length; i++) {
            enum2 = root_b.breadthFirstEnumeration();
            for(int j=0; j<(i+1)/2; j++) {
                p_b = enum2.nextElement();
            }
            p_b.add(new DefaultMutableTreeNode(b[i]));
        }
        //แสดงผลลัพท์
        System.out.print(root_b.getDepth()+" "+b.length+":");
        enum2 = root_b.breadthFirstEnumeration();
        String ans_2 = "";// เตรียม string สำหรับใส่ข้อมูล
        for(int i=0; i<b.length; i++) {
            ans_2 += enum2.nextElement()+"-";
        }
        System.out.print(ans_2.substring(0, ans_2.length()-1)+"");
        //ผลลัพท์ 2 5:4-2-5-1-3
        System.out.println("");
        
        // ข้อ 7.3
        int[] c = {2,5,1,4,3};
        DefaultMutableTreeNode root_c = null;
        Enumeration<DefaultMutableTreeNode> enum3;
        root_c = new DefaultMutableTreeNode(c[0]);
        DefaultMutableTreeNode p_c = root_c;
        for(int i=1; i<c.length; i++) {
            enum3 = root_c.breadthFirstEnumeration();
            for(int j=0; j<(i+1)/2; j++) {
                p_c = enum3.nextElement();
            }
            p_c.add(new DefaultMutableTreeNode(c[i]));
        }
        inorder(root_c);
        //ผลลัพท์ 4,5,3,2,1,
    }
}
