import java.util.*;
public class Praktikum06_HashTable4 {
    public static void main(String args[]){
        Hashtable<Integer,String> hashtable=new Hashtable<Integer,String>();
        hashtable.put(200,"A");
        hashtable.put(202,"B");
        hashtable.put(201,"C");
        hashtable.put(203,"D");
        //If and else statement as arguments of the method
        System.out.println(hashtable.getOrDefault(201, "Not Exist"));
        System.out.println(hashtable.getOrDefault(205, "Not Exist"));
    }
}
