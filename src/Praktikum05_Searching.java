import java.util.Scanner;

public class Praktikum05_Searching {
    public static int SequentialSearch(int arr[], int x) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            if(arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    static int LinearSearch (int arr[], int x){
        int N = arr.length;
        boolean find = false;
        for (int i = 0; i < N; i++) {
            if (arr[i] == x) {
                System.out.println("Element is present at index : " + i);
                find = true;
            }
        } if (!find) {
            System.out.println("Element is not present at index array");
        }
        return -1;
    }
    public static int LinearSearchRecursive(int arr[], int size, int key) {
        if (size == 0) {
            return -1;
        }
        else if (arr[size - 1] == key) {
            // Return the index of found key.
            return size - 1;
        }
        else {
            return LinearSearchRecursive(arr, size, key);
        }
    }

    static void BinarySearchIterative(int arr[], int x) {
        int size = arr.length;
        int l = 0;
        int r = size - 1;

        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (arr[mid] < x) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        if (arr[l] == x) {
            System.out.println("Found At Index " + l );
        }
        else if (arr[r] == x) {
            System.out.println("Found At Index " + r );
        }
        else {
            System.out.println("Not Found" );
        }
    }
    public static int binarySearchRecursive(int arr[], int l, int r, int x)  {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x) {
                return mid;
            }
            else if (arr[mid] > x) {
                return binarySearchRecursive(arr, l, mid - 1, x);
            } else {
                return binarySearchRecursive(arr, mid + 1, r, x);
            }
        }
        return -1;
    }

    static int binarysearchIterative (int arr[], int low, int high, int x){
        for (int i = 0; i < arr.length; i++) {
            int mid = (low + high)/2;
            if (x == arr[mid]) {
                return mid;
            } else if (x > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        } return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arr[] = { 2, 3, 4, 10, 40, 10};
        //int x = 40;
        int size = arr.length;

        System.out.println("Data Array :");
        for(int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.print("Add data search : ");
        int x = scanner.nextInt();

        int result;
        result = LinearSearch(arr, x);
//        result = LinearSearchRecursive(arr, size - 1, x);
        //result = binarySearchRecursive(arr, 0, size-1, x);
        //result = binarysearchIterative(arr, 0, size-1, x);
//        if(result == -1) {
//            System.out.println("Elemen tidak ditemukan");
//        } else {
//            System.out.println("Data ditemukan pada indeks ke: " + result);
//        }
    }
}
