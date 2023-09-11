/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week.pkg5.reiorityqueue.pkg11.pkg9.pkg2566;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author Guest-Student
 */
public class NewClass {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue();
        pq.add(3);
        pq.add(2);
        pq.add(1);
        System.out.println(pq);
        // ผลลัพท์ [1, 3, 2]
        int x = pq.element(); // element คือค่าตัวแรกของ PriorityQueue
        System.out.println(x);
        //ผลลัพท์ 1
        pq.remove();
        pq.remove();
        pq.remove();
        // remove เป็นการลบตัวแรก
        System.out.println(pq);
        
        
        
        Random random = new Random ();
        for(int i=0 ; i<10; i++){
            pq.add(random.nextInt(100)+1);
            // เพิ่มแบบ Random 10 ตัว
        }
        System.out.println(pq);
        // ผลลัพท์แบบยังไม่ sort หรือเรียง [1, 13, 78, 28, 20, 90, 84, 90, 40, 98]
        Integer[] y = new Integer[10];
        int i=0;
        while(!pq.isEmpty()){
            y[i] = pq.remove();
            i++;
        }
        System.out.println(Arrays.toString(y));
        // ผลลัพท์ [14, 14, 43, 56, 58, 68, 80, 83, 83, 91]
        // การ remove ของ PriorityQueue เป็นแบบ poll
        // ยังไม่เข้าใจว่าทำไมถึง sort
    }
}
