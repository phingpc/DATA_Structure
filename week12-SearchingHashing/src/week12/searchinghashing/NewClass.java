
package week12.searchinghashing;

class student {
    private String code;
    private String name;
    student (String code ,String name) {
        this.code = code;
        this.name = name;
    }
    // ถ้าทำถูกต้องหรือเขียยนถูกต้อง จะต้องให้ทำ @Override method ขึ้นมา
    @Override
    public int hashCode(){
        return code.hashCode();
    }
}


public class NewClass {
    public static void main(String[] args) {
        // ถ้าเป็น primitive data type ต้องใช้การแปลงตัวแปลด้วย
        int x=10; // นี้คือ primitive data type
        System.out.println(Integer.hashCode(x)); // ผลลัพท์ 10
        String y = "Hello"; // นี้คือ Object
        System.out.println(y.hashCode()); // ผลลัพท์ 69609650
        /////////////////////////////////////
        // ไม่ได้ขึ้นอยู่กับค่าใน hashcode แต่ขึ้นอยู่กับ address ที่ตั้งของข้อมูล
        // แต่! ถ้า @Override method ผลลัพท์ที่เหมือนกัน
        /////////////////////////////////////
        student z1 = new student("001","James");
        System.out.println(z1.hashCode()); // ผลลัพท์ 366712642
        student z2 = new student("001","James");
        System.out.println(z2.hashCode()); // ผลลัพท์ 1829164700
        // ผลลัพท์ หลังจาก @Override method ผลลัพท์ของ z1 = 47665 ผลลัพท์ของ z2 = 47665
        //(ผลลัพท์จะเหมือนกันถ้าค่าเท่ากันทันที)
        
    }
}
