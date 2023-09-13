public class Praktikum06_HashTable {
    public static int hash(String key, int size) {
        int hashVal = 0;
        for(int i = 0; i < key.length(); i++) {
            hashVal = (hashVal * 128 + key.charAt(i)) % size;
        }
        return hashVal % size;
    }
    public static void main(String[] args) {
        int data = hash("Struktur Data", 10);

        System.out.println(data);
    }
}
