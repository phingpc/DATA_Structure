/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6;

/**
 *
 * @author Guest-Student
 */
class Product {

    private int id;
    private String name;
    private int price;
    public Product (int a ,String b,int c) {
        id =a;
        name = b;
        price = c;
    }
    
    public void print () {
        System.out.println(id+"/"+name+"/"+price+"/");
    }
}

class Node {

    private Product data;
    private Node next;
    private Node prev;

    public Node(Product pro) {
        data = pro;
    }
    public void next_A (Node a) {
        next = a;
    }
    public void prev_A (Node a) {
        prev = a;
    }
    public Node realnext(){
        return next;
    }
    public void realprint () {
        data.print();
    }
}

class Linkedlist {

    private Node head;
    private Node tail;
    int count = 0;

    public void addLast(Node n) {
        if (head == null) {
            head = n;
        } else {
            tail.next_A(n);
            n.prev_A(tail);
            count++;
        }
        tail = n;
    }
    public void travers(){
        Node p = head;
        while ( p != null){
            p.realprint();
            p = p.realnext();
        }
    }
}

public class NewClass {

    public static void main(String[] args) {
        Linkedlist list = new Linkedlist(); // empty list
        list.addLast(new Node(new Product(1, "weed"+1, 1 * 100)));
        list.addLast(new Node(new Product(2, "weed"+2, 2 * 100)));
        list.addLast(new Node(new Product(3, "weed"+3, 3 * 100)));
        list.addLast(new Node(new Product(4, "weed"+4, 4 * 100)));
        list.addLast(new Node(new Product(5, "weed"+5, 5 * 100)));
        list.travers();
    }
}
