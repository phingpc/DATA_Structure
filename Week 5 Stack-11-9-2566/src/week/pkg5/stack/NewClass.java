/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week.pkg5.stack;

import java.util.Stack;

/**
 *
 * @author Guest-Student
 */
public class NewClass {
    public static void main(String[] args) {
        Stack s1 = new Stack();
        s1.push(10);
        s1.push("Hello");
        System.out.println(s1.size());
        // ผลลัพท์จะออกเป็น 2
        System.out.println(s1);
        //ผลลัพท์จะออกเป็น [10,Hello] โดยค่าที่ออกมาจะเป็น String แล้วเรียบร้อย
        //ไม่จำเป็นต้องใช้ method toString() แต่อย่างใด
        System.out.println(s1.toString().substring(1, s1.toString().length()-1));
        //เป็นData String ที่ตัดในส่วนของวงเล็บออกจากผลลัพท์โดยใช้ substring ตัดตัวแรกและตัวสุดท้าย
        for(Object i:s1){ // for (each)
            System.out.println(i);
            // ผลลัพท์จะออกเป็นค่าที่ i ของ s1 คือ 10 และ Hello
        }
        
        // เพิ่มเติมค่าใน Stack
        s1.push(20);
        s1.push(30);
        s1.push(40);
        s1.push(50);
        
        
        for(int i=0; i<6; i++){
            // ข้อควรระวังไม่ควรใช้ s1.size() เหตุเพราะค่าของ stack ที่เกิดการเพิ่มหรือลดไม่คงที่
            // หรือจำกำหนดตัวแปล int n = s1.size(); แทนก็ได้
            
            
            System.out.println("Size:"+s1.size()+" i: "+i);
            System.out.println(s1.pop() + " ");
            //ทุกครั้งที่ pop 1 ครั้ง size หรือ ขนาดของ Stack จะลดลง 1 ทำให้
            //ผล pop ที่แสดง 1 ครั้งคือค่าที่หายไป
        }
        System.out.println();
        System.out.println(s1.size()); // ขนาดของ Stack จะเหลือ 0
        
        
        //การใช้ loop while
        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.push(40);
        s1.push(50);
        while(!s1.empty()){ //ถ้า Stack s1 ยังไม่ว่างก็ทำงานต่อไป
            System.out.println(s1.pop()+" size:"+s1.size());
        }
    }
}
