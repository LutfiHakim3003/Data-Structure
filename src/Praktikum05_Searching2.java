import java.util.Scanner;

public class Praktikum05_Searching2 {
    // Iteratively Sequential Search
    public static int SequentialSearch(int arr[], int x) {
        int size = arr.length;
        if(size == 0) {
            return -1;
        } else {
            for (int i = 0; i < size; i++) {
                if(arr[i] == x) {
                    return i;
                }
            }
            return -1;
        }
    }
    // Recursively Sequential Search
    public static int RecursiveSequentialSearch(int arr[], int l, int r, int key) {
        if(r < l) {
            return -1;
        } else if(arr[l] == key) {
            return l;
        } else if (arr[r] == key) {
            return r;
        } else {
            return RecursiveSequentialSearch(arr, l + 1, r - 1, key);
        }
    }

    public static int[] LinearlySearch(int arr[], int x) {
        int k = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == x) {
                k++;
            }
        }
        int[] indeksArray = new int[k];
        int j = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == x) {
                indeksArray[j] = i;
                j++;
            }
        }
        return indeksArray;
    }
    public static int RecursiveBinarySearch(int arr[], int l, int r, int x) {
        if(r >= l) {
            int mid = l + (r - l) / 2;
            if(arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                return RecursiveBinarySearch(arr, l, mid-1, x);
            } else {
                return RecursiveBinarySearch(arr, mid+1, r, x);
            }
        }
        return -1;
    }
    static int IterativeBinarySearch(int arr[], int low, int high, int x){
        for (int i = 0; i < arr.length; i++) {
            int mid = (low + high)/2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        } return -1;
    }
    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 10, 30, 40};
        int size = arr.length;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan data yang dicari: ");
        int x = scanner.nextInt();

//        int result;
//        result = SequentialSearch(arr, x);
//        result = RecursiveSequentialSearch(arr, 0, size-1, x);
//        result = RecursiveBinarySearch(arr, 0, size-1, x);
//        result = IterativeBinarySearch(arr, 0, size-1, x);
        int[] result = LinearlySearch(arr, x);

//        if(result == -1) {
//            System.out.println("Data tidak ditemukan");
//        } else {
//            System.out.println("Data ditemukan pada indeks ke: " + result);
//        }
    }
}
