import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
public class Praktikum06_HashTable2 {
    // Create a hash map
    public static void main(String args[]){
        //Create Hashtable object.
        Hashtable hashtable = new Hashtable();

        //Add objects to the Hashtable.
        hashtable.put(2,"Bharat");
        hashtable.put(1,"Richi");
        hashtable.put(5,"Sahdev");
        hashtable.put(3,"Rajesh");
        hashtable.put(4,"Himanshu");

        //Print the Hashtable object.
        System.out.println("Hashtable elements:");
        System.out.println(hashtable);

        //Get iterator
        Set set=hashtable.entrySet();
        Iterator iterator=set.iterator();

        //Print the Hashtable elements using iterator.
        System.out.println("Hashtable elements using iterator:");
        while(iterator.hasNext()){
            Map.Entry mapEntry=(Map.Entry)iterator.next();
            System.out.println("Key: " + mapEntry.getKey() +
                    ", " + "Value: " + mapEntry.getValue());
        }
    }
}
