import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
//import java.util.*;
import javax.swing.tree.*;
//import javax.swing.tree.TreeNode;
//import javax.swing.tree.MutableTreeNode;
//import javax.swing.tree.DefaultMutableTreeNode;

class CompleteBinarySearchTree {

    DefaultMutableTreeNode root;

    public CompleteBinarySearchTree() {
        root = null;
    }

    void createFromArray(int[] a) {
        for (int i : a) {
            add(i);
        }
    }

    void add(int data) {
        if (root == null) {
            root = new DefaultMutableTreeNode(data);
        } else {
            addComplete(root, data);
            //addBST(root, data);
        }
    }

    // this is the add for complete binary tree ... ok
    void addComplete(DefaultMutableTreeNode node, int data) {
        if (node.getChildCount() < 2) {
            node.add(new DefaultMutableTreeNode(data));
        } else {
            addComplete(node.getNextNode(), data);
        }
    }

    // this is the add for BST
    void addBST(DefaultMutableTreeNode node, int data) {
        switch (node.getChildCount()) {
            case 0:
                if (data < Integer.parseInt(node.toString())) { // add as left node
                    node.add(new DefaultMutableTreeNode(data));
                    node.add(new DefaultMutableTreeNode(0));
                } else {  // add as right node
                    node.add(new DefaultMutableTreeNode(0));
                    node.add(new DefaultMutableTreeNode(data));
                }
                break;
            case 2:
                if (data < Integer.parseInt(node.toString())) {
                    if (Integer.parseInt(node.getChildAt(0).toString()) == 0) {
                        node.getNextNode().setUserObject(data);
                    } else {
                        addBST(node.getNextNode(), data);
                    }
                } else {
                    if (Integer.parseInt(node.getChildAt(1).toString()) == 0) {
                        node.getNextNode().getNextSibling().setUserObject(data);
                    } else {
                        addBST(node.getNextNode().getNextSibling(), data);
                    }
                }
                break;
            default:
                break;
        }
    }
}

class Student {

    public String code;
    public String name;
    public int score;

    Student(String c, String n, int s) {
        code = c;
        name = n;
        score = s;
    }

    @Override
    public String toString() {
        return code;
    }
}

public class DSLab9 {

    static int nBST = 0;
    static int countBST = 0;

    static String genInput9_1(int n) {

        String s = "";
        List<Integer> l1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            l1.add(i + 1);
        }
        Collections.shuffle(l1);
        for (int i = 0; i < n; i++) {
            s += l1.get(i);
            if (i < n - 1) {
                s += ", ";
            }
        }

        return s;
    }

    static Student[] genInput9_2(int n) {

        Student[] s = new Student[n];
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            l1.add(i + 1);
            l2.add(i + 1);
        }
        Collections.shuffle(l1);
        Collections.shuffle(l2);
        for (int i = 0; i < n; i++) {
            String code = l1.get(i).toString();
            for (int j = code.length(); j < 3; j++) {
                code = "0" + code;
            }
            String name = randomString(0, 3);
            int score = l2.get(i);
            s[i] = new Student(code, name, score);
        }

        return s;
    }

    static String randomString(int t, int n) {
        Random r = new Random();
        String y = "";
        if (t == 0) { // 0: gen random string as text
            for (int i = 0; i < n; i++) {
                int x = r.nextInt(26) + 65;
                y += (char) x;
            }
        } else // 1: gen random string as list of integer using shuffle 
        {
            List<Integer> number = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                number.add(i + 1);
            }
            Collections.shuffle(number);
            for (int i = 0; i < n; i++) {
                y += number.get(i);
                if (i != n - 1) {
                    y += ", ";
                }
            }
        }
        return y;
    }

    static void inorderCBT(DefaultMutableTreeNode root) {
        if (root != null) {
            if (root.getChildCount() > 0) {
                inorderCBT(root.getNextNode());
            }
            System.out.print(root);
            if (root.getNextNode() != null) {
                System.out.print(", ");
            }
            if (root.getChildCount() > 1) {
                inorderCBT(root.getNextNode().getNextSibling());
            }
        }
    }

    static void inorderBST(DefaultMutableTreeNode root) {
        if (root != null) {
            if (root.getChildCount() > 0) {
                inorderBST(root.getNextNode());
            }
            if (Integer.parseInt(root.toString()) > 0) {
                System.out.print(root);
                countBST++;
            }
            if (countBST != nBST && Integer.parseInt(root.toString()) > 0) {
                System.out.print(", ");
            }
            if (root.getChildCount() > 1) {
                inorderBST(root.getNextNode().getNextSibling());
            }
        }
    }

    public static void main(String[] args) {

        // 7.2 CreateCompleteBinaryTree ----->>
        /*
        //System.out.println("7.2 Gen testcase: ----------");
        // 0: random string, 1: random integer
        //String input = randomString(1, 100);
        //System.out.println("Input: ----------");
        //System.out.println(input);

        // Solution
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine(); 
        String[] x = input.split(",");
        DefaultMutableTreeNode root = null;
        Enumeration<DefaultMutableTreeNode> enum1;
        int count = 0;
        if (x.length == 1) {  // input as text            
            root = new DefaultMutableTreeNode(x[0].charAt(0));
            count++;
            DefaultMutableTreeNode p = root;            
            for (int i = 1; i < x[0].length(); i++) {
                enum1 = (Enumeration<DefaultMutableTreeNode>)(Object)root.breadthFirstEnumeration();
                for (int j = 0; j < (i + 1) / 2; j++) {
                    p = enum1.nextElement();
                }
                p.add(new DefaultMutableTreeNode(x[0].charAt(i)));
                count++;
            }
        } else {  // input as list of integer
            int y = Integer.parseInt(x[0].trim());
            root = new DefaultMutableTreeNode(y);
            count++;
            DefaultMutableTreeNode p = root;
            for (int i = 1; i < x.length; i++) {
                y = Integer.parseInt(x[i].trim());
                enum1 = (Enumeration<DefaultMutableTreeNode>)(Object)root.breadthFirstEnumeration();
                for (int j = 0; j < (i + 1) / 2; j++) {
                    p = enum1.nextElement();
                }
                p.add(new DefaultMutableTreeNode(y));
                count++;
            }
        }
        //System.out.println("Output: ----------");
        System.out.print(root.getDepth() + " ");
        System.out.print(count + ": ");
        enum1 = (Enumeration<DefaultMutableTreeNode>)(Object)root.breadthFirstEnumeration();
        while (enum1.hasMoreElements()) {
            DefaultMutableTreeNode node = enum1.nextElement();
            System.out.print(node);
            if (enum1.hasMoreElements()) {
                System.out.print("-");
            }
        }
        //System.out.println();
        */
        // <<----- 7.2
        
        
        
        // 7.3 inorderTraversalInCBT ----->>
        /*
        //System.out.println("7.2 Gen testcase: ----------"); 
        // 0: random string, 1: random integer
        //String input = randomString(1, 100);  
        //System.out.println("Input: ----------");
        //System.out.println(input);
        
        // Solution
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine(); 
        
        String[] x = input.split(",");
        DefaultMutableTreeNode root = null;
        Enumeration<DefaultMutableTreeNode> enum1;
        if (x.length == 1) {  // input as text            
            root = new DefaultMutableTreeNode(x[0].charAt(0));            
            DefaultMutableTreeNode p = root;            
            for (int i = 1; i < x[0].length(); i++) {
                enum1 = (Enumeration<DefaultMutableTreeNode>)(Object)root.breadthFirstEnumeration();
                for (int j = 0; j < (i + 1) / 2; j++) {
                    p = enum1.nextElement();
                }
                p.add(new DefaultMutableTreeNode(x[0].charAt(i)));                
            }
        } else {  // input as list of integer
            int y = Integer.parseInt(x[0].trim());
            root = new DefaultMutableTreeNode(y);            
            DefaultMutableTreeNode p = root;
            for (int i = 1; i < x.length; i++) {
                y = Integer.parseInt(x[i].trim());
                enum1 = (Enumeration<DefaultMutableTreeNode>)(Object)root.breadthFirstEnumeration();
                for (int j = 0; j < (i + 1) / 2; j++) {
                    p = enum1.nextElement();
                }
                p.add(new DefaultMutableTreeNode(y));                
            }
        }
        
        //System.out.println("Output: ----------");
        inorderCBT(root);
        //System.out.println();
        */
        // <<----- 7.3
        
        
        // 9.1 Create BST----->>
        /*
        // Gen testcases
        //System.out.println("9.1 Gen testcase: ----------"); 
        //int n0 = 100;
        //String text = genInput9_1(n0);
        //System.out.println(text);
        
        // Solution
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();     
        //System.out.println("Output: ----------");
        String[] temp = text.split(",");
        int n = temp.length;
        int[] data = new int[n];
        for(int i=0; i<n; i++)
            data[i] = Integer.parseInt(temp[i].trim());                
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(data[0]);
        DefaultMutableTreeNode p = root;
        for (int i = 1; i < data.length; i++) {
            while (true) {
                if (p.getChildCount() == 0) {
                    if (data[i] < Integer.parseInt(p.toString())) { // add as left node
                        p.add(new DefaultMutableTreeNode(data[i]));
                        p.add(new DefaultMutableTreeNode(0));
                    } else {  // add as right node
                        p.add(new DefaultMutableTreeNode(0));
                        p.add(new DefaultMutableTreeNode(data[i]));
                    }        
                    break;
                }
                else if (p.getChildCount() == 2) {
                    if (data[i] < Integer.parseInt(p.toString())) {
                        if (Integer.parseInt(p.getChildAt(0).toString()) == 0) {
                            p.getNextNode().setUserObject(data[i]);
                            break;
                        }
                        p = p.getNextNode();

                    } else {
                        if (Integer.parseInt(p.getChildAt(1).toString()) == 0) {
                            p.getNextNode().getNextSibling().setUserObject(data[i]);
                            break;
                        }
                        p = p.getNextNode().getNextSibling();
                    }
                }
            }
            p = root;
        }
        System.out.print(root.getDepth() + " ");
        Enumeration<DefaultMutableTreeNode> enum1 = (Enumeration<DefaultMutableTreeNode>)(Object)root.depthFirstEnumeration();
        int count = 0;
        while (enum1.hasMoreElements()) {
            DefaultMutableTreeNode node = enum1.nextElement();
            if(Integer.parseInt(node.toString()) > 0 )                
                count++;
        }
        nBST = count;
        System.out.println(count);        
        inorderBST(root);
        System.out.println();
        enum1 = (Enumeration<DefaultMutableTreeNode>)(Object)root.breadthFirstEnumeration();
        int c = 0;
        while (enum1.hasMoreElements()) {
            DefaultMutableTreeNode node = enum1.nextElement();
            if(Integer.parseInt(node.toString()) > 0 ){
                System.out.print(node);
                c++;
            }
            if(c!=count && Integer.parseInt(node.toString()) > 0)
                System.out.print(", ");
        }
        System.out.println();
        enum1 = (Enumeration<DefaultMutableTreeNode>)(Object)root.preorderEnumeration();
        c=0;
        while (enum1.hasMoreElements()) {
            DefaultMutableTreeNode node = enum1.nextElement();
            if(Integer.parseInt(node.toString()) > 0 ){
                System.out.print(node);
                c++;
            }
            if(c!=count && Integer.parseInt(node.toString()) > 0)
                System.out.print(", ");
        }
        //System.out.println();
        */
        // <<----- 9.1
        

        // 9.2 MyObjectInBST ----->>
        /*
        // Gen testcases   
        //System.out.println("9.2 Gen testcase:----------");
        //int n0 = 100;
        //System.out.println(n0);
        //Student[] s0 = genInput9_2(n0);
        //for(int i=0; i<n0; i++){
            //System.out.println(s0[i].code +" "+s0[i].name+" "+s0[i].score);
        //}
        
        // Solution
        //System.out.println("Solution:(Input)----------");        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();sc.nextLine();
        String text = sc.nextLine();
        String[] temp0 = text.split(" ");
        Student s = new Student(temp0[0], temp0[1], Integer.parseInt(temp0[2].trim()));
        
        //int n = n0;
        //Student s = s0[0];
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(s);
        DefaultMutableTreeNode p = root;
        for (int i = 1; i < n; i++) {
            text = sc.nextLine();
            String[] temp1 = text.split(" ");
            s = new Student(temp1[0], temp1[1], Integer.parseInt(temp1[2].trim()));
            //s = s0[i];
            while (true) {
                if (p.getChildCount() == 0) {
                    if (s.code.compareTo(p.getUserObject().toString()) < 0 ) { // add as left node
                        p.add(new DefaultMutableTreeNode(s));                        
                        p.add(new DefaultMutableTreeNode( new Student("0","",0) ));
                    } else {  // add as right node
                        p.add(new DefaultMutableTreeNode( new Student("0","",0)));
                        p.add(new DefaultMutableTreeNode(s));
                    }
                    break;
                } else if (p.getChildCount() == 2) {
                    if (s.code.compareTo(p.getUserObject().toString()) < 0 ) {
                        if (Integer.parseInt(p.getChildAt(0).toString()) == 0) {
                            p.getNextNode().setUserObject(s);
                            break;
                        }
                        p = p.getNextNode();

                    } else {
                        if (Integer.parseInt(p.getChildAt(1).toString()) == 0) {
                            p.getNextNode().getNextSibling().setUserObject(s);
                            break;
                        }
                        p = p.getNextNode().getNextSibling();
                    }
                }
            }
            p = root;
        }
        //System.out.println("Output:----------");
        System.out.print(root.getDepth() + " ");
        Enumeration<DefaultMutableTreeNode> enum1 = (Enumeration<DefaultMutableTreeNode>)(Object)root.depthFirstEnumeration();
        int count = 0;
        while (enum1.hasMoreElements()) {
            DefaultMutableTreeNode node = enum1.nextElement();
            if(Integer.parseInt(node.toString()) > 0 )
                count++;
        }
        nBST = count;
        System.out.println(count);        
        inorderBST(root);
        System.out.println();
        enum1 = (Enumeration<DefaultMutableTreeNode>)(Object)root.breadthFirstEnumeration();    
        int c=0;
        while (enum1.hasMoreElements()) {
            DefaultMutableTreeNode node = enum1.nextElement();
            if(Integer.parseInt(node.toString()) > 0 ){
                System.out.print(node);
                c++;
            }
            if( Integer.parseInt(node.toString()) > 0 && c!=count)
                System.out.print(", ");
        }
        System.out.println();
        enum1 = (Enumeration<DefaultMutableTreeNode>)(Object)root.preorderEnumeration();
        c=0;
        while (enum1.hasMoreElements()) {
            DefaultMutableTreeNode node = enum1.nextElement();
            if(Integer.parseInt(node.toString()) > 0 ){
                System.out.print(node);
                c++;
            }
            if(Integer.parseInt(node.toString()) > 0 && c!=count)
                System.out.print(", ");
        }
        //System.out.println();
        */
        // <<----- 9.2
        
        
        // 9.3 SearchInBST ----->>
        
        // Gen testcases   
        //System.out.println("9.3 Gen testcase:----------");
        //int n0 = 100;
        //System.out.println(n0);
        //Student[] s0 = genInput9_2(n0);
        //for(int i=0; i<n0; i++){
            //System.out.println(s0[i].code +" "+s0[i].name+" "+s0[i].score);
        //}
        //Random r = new Random();
        //String key = "xxx";
        //if(r.nextInt(2)==0)
            //key = s0[r.nextInt(n0)].code;
        //System.out.println(key);
        
        
        // Solution
        //System.out.println("Solution:(Input)----------");        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();sc.nextLine();
        String text = sc.nextLine();
        String[] temp0 = text.split(" ");
        Student s = new Student(temp0[0], temp0[1], Integer.parseInt(temp0[2].trim()));
        
        
        //int n = n0;
        //Student s = s0[0];
		
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(s);
        DefaultMutableTreeNode p = root;
        for (int i = 1; i < n; i++) {
            text = sc.nextLine();
            String[] temp1 = text.split(" ");
            s = new Student(temp1[0], temp1[1], Integer.parseInt(temp1[2].trim()));
            //s = s0[i];
            while (true) {
                if (p.getChildCount() == 0) {
                    if (s.code.compareTo(p.getUserObject().toString()) < 0 ) { // add as left node
                        p.add(new DefaultMutableTreeNode(s));                        
                        p.add(new DefaultMutableTreeNode( new Student("0","",0) ));
                    } else {  // add as right node
                        p.add(new DefaultMutableTreeNode( new Student("0","",0)));
                        p.add(new DefaultMutableTreeNode(s));
                    }
                    break;
                } else if (p.getChildCount() == 2) {
                    if (s.code.compareTo(p.getUserObject().toString()) < 0 ) {
                        if (Integer.parseInt(p.getChildAt(0).toString()) == 0) {
                            p.getNextNode().setUserObject(s);
                            break;
                        }
                        p = p.getNextNode();

                    } else {
                        if (Integer.parseInt(p.getChildAt(1).toString()) == 0) {
                            p.getNextNode().getNextSibling().setUserObject(s);
                            break;
                        }
                        p = p.getNextNode().getNextSibling();
                    }
                }
            }
            p = root;
        }
		
		// Solution -- key
		String key = sc.nextLine();
		
		
        //System.out.println("Output:----------");
        Enumeration<DefaultMutableTreeNode> enum1 = (Enumeration<DefaultMutableTreeNode>)(Object)root.depthFirstEnumeration();
        int found = 0;
        p=null;
        while (enum1.hasMoreElements()) {
            DefaultMutableTreeNode node = enum1.nextElement();
            if(Integer.parseInt(node.toString()) > 0 ){
                if( node.toString().equals(key)){
                    p = node;
                    found=1;
                    break;
                }
            }            
        }        
        if(found==0)
            System.out.println("Not found");
        else{
            Student temp = (Student)p.getUserObject();
            System.out.println(temp.code+" "+temp.name+" "+temp.score);
        }
        
        // <<----- 9.3        
    }
}
