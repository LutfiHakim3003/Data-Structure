import java.util.HashMap;

public class Praktikum06_HashTablePercobaan {
    public static void main(String[] args) {
        HashMap<Integer, String> hash_map = new HashMap<Integer, String>();

        hash_map.put(10, "TRPL");
        hash_map.put(15, "1B");
        hash_map.put(20, "Poliwangi");
        hash_map.put(25, "Banyuwangi");
        hash_map.put(30, "Jinggo");

        System.out.println("Data pada Hash Table: " + hash_map);

        String masukkanData = (String)hash_map.put(20, "All");
        System.out.println("Data Baru: " + masukkanData);

        System.out.println("Data Hash: " + hash_map);
    }
}
