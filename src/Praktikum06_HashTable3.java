import java.util.*;
public class Praktikum06_HashTable3 {
        public static void main(String args[]) {
            Hashtable<Integer,String> hashtable=new Hashtable<Integer,String>();
            hashtable.put(200,"A");
            hashtable.put(202,"B");
            hashtable.put(201,"C");
            hashtable.put(203,"D");
            System.out.println("Before remove: "+ hashtable);
            // Remove value for key 202
            hashtable.remove(202);
            System.out.println("After remove: "+ hashtable);
    }
}
