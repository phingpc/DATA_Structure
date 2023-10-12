package week12.data;




import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Student {
    private String code;
    private String name;
    private double[] gpa;
    Student (String code, String name) {
        this.code = code;
        this.name = name;
        Random ran = new Random();
        /*for(int i=0; i<10; i++){
            this.gpa[i] = ran.nextInt(4)+ran.nextDouble();
        }*/
    }
    public String getCode () {
        return code;
    }
    @Override
    public String toString (){
        return code +" "+name;
    }
    @Override
    public int hashCode () {
        return code.hashCode();
    }
}

public class NewClass {
    
    public static Student genStudent () {
        Random random = new Random();
        int random_code = random.nextInt(1000000000-100000000+1)+100000000;
        String code = "";
        code += random_code+"";
        String name = "";
        int n = random.nextInt(10)+3;
        for(int i=0; i<n; i++){
            int random_name = random.nextInt(122-97+1)+97;
            name += Character.toString((char) random_name);
        }
        return new Student (code,name);
    }
    
    
    public static void main(String[] args) {
        //long start = System.nanoTime();
        //Runtime runtime = Runtime.getRuntime();
        int n = 10_000_000;
        /*Student[] students = new Student[n];
        
        for(int i=0; i<n; i++){
            students[i] = genStudent();
        }
        long stop = System.nanoTime();
        //TimeUnit second;
        System.out.println("Allocating time:"+ TimeUnit.NANOSECONDS.toSeconds(stop-start) + "sec.");
        
        
        
        //System.out.println("Allocating time:"+ (stop - start /1_000_000_000));
        Random r = new Random();
        
        String key = students[2].getCode();
        
        //Sequential search
        start = System.nanoTime();
        for(int i=0; i<n; i++) {
            if ( key.equalsIgnoreCase(students[i].getCode()) ){
                System.out.println("Found");
                System.out.println("DATA : "+students[i].toString());
                break;
            }
        }
        stop = System.nanoTime();
        //System.out.println("Searching time :"+ (stop - start /1_000_000_000));
        System.out.println("Searching time :"+ TimeUnit.NANOSECONDS.toSeconds(stop-start) + "sec.");
        
        
        
        //long x = Runtime.getRuntime().totalMemory();// - Runtime.getRuntime().freeMemory();
        //System.out.println(x/1_000_000); // เม็ก
        
        
        /*
        // waiting for key press
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();*/
        
        
        long start = System.nanoTime();
        
        Random r = new Random();
        int idx = r.nextInt(n);
        String key = "";
        HashMap<String,Student> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            Student x = genStudent();
            hm.put(x.getCode(), x);
            if(idx == i){
                key = x.getCode();
            }
        }
        long stop = System.nanoTime();
        System.out.println("Allocating time : "+ TimeUnit.NANOSECONDS.toSeconds(stop-start) + " sec.");
        start = System.nanoTime();
        Student y = hm.get(key);
        System.out.println("Found");
        System.out.println("DATA : "+y);
        stop = System.nanoTime();
        System.out.println("Searching time : "+ TimeUnit.NANOSECONDS.toSeconds(stop-start) + " sec.");
    }
}
