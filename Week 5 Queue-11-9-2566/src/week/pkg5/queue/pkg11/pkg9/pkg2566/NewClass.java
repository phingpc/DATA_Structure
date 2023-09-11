/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week.pkg5.queue.pkg11.pkg9.pkg2566;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Guest-Student
 */
public class NewClass {
    public static void main(String[] args) {
        
        Queue<String> q1 = new LinkedList();
        // Queue ใช้ได้แค่เพิ่ม-ลดจากข้างหลังเท่านั้น
        q1.add("อัส");
        q1.add("กิต");
        q1.add("หลิว");
        q1.add("นิว");
        q1.add("ปาร์ม");
        q1.add("มาย");
        q1.add("แฮะ");
        // add เฉยๆจะเท่ากับ addLast
        System.out.println(q1);
        // ผลลัพท์ [อัส, กิต, หลิว, นิว, ปาร์ม, มาย, แฮะ]
        while(!q1.isEmpty()){ // ทำจนกว่า Queue q1 จะว่าง
            System.out.print(q1.remove()+" ");
        }
        System.out.println();
        System.out.println(q1.poll()); // ถ้า Queue ว่างจะขึ้น null
        
        Deque <String> q2 = new LinkedList<>();
        // Deque ใช้ได้ทั้งเพิ่ม-ลดข้อมูลทั้งด้านหน้าและด้านหลัง
        q2.addFirst("อัส");
        q2.addFirst("กิต");
        q2.addFirst("หลิว");
        q2.addFirst("นิว");
        q2.addFirst("ปาร์ม");
        q2.addFirst("มาย");
        q2.addFirst("แฮะ");
        System.out.println(q2);
        //ผลลัพท์ [แฮะ, มาย, ปาร์ม, นิว, หลิว, กิต, อัส]
        
        //วิธีทำ reverse String
        Deque <Character> q3 = new LinkedList<>();
        String text = "Silpakorn";
        for(int i=0; i<text.length(); i++){
            q3.add(text.charAt(i));
        }
        System.out.println(q3);
        // ผลลัพท์ [S, i, l, p, a, k, o, r, n]
        String reverse = "";
        while(!q3.isEmpty()){
            reverse += q3.removeLast();
            // เพิ่มจากค่าที่ลบตัวสุดท้าย
            //เช่น ลบค่า n ก็นำ n ไปเพิ่มในStringว่างที่เตรียมเอาไว้ซึ่งคือ reverse
        }
        System.out.println(reverse);
    }
}
