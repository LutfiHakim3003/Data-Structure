import java.util.Scanner;

public class Praktikum05_Searching3 {
    /* Algoritma Linear atau Sequential Search */
    public static int IterativeLinearSearch(int arr[], int size, int key) {
        if(size == 0) {
            return -1;
        } else {
            for(int i = 0; i < size; i++) {
                if(arr[i] == key) {
                    return i;
                }
            }
            return -1;
        }
    }
    public static int RecursiveLinearSearch(int arr[], int size, int key) {
        if(size == 0) {
            return -1;
        } else if (arr[size - 1] == key) {
            return size - 1;
        } else {
            return RecursiveLinearSearch(arr, size-1, key);
        }
    }
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

    /* Binary Search */
    public static int RecursiveBinarySearch(int arr[], int l, int r, int k) {
        if(r >= l) {
            int mid = l + (r - l) / 2;

            if(arr[mid] == k) {
                return mid;
            } else if(arr[mid] > k) {
                return RecursiveBinarySearch(arr, l, mid-1, k);
            } else{
                return RecursiveBinarySearch(arr, mid+1, r, k);
            }
        }
        return -1;
    }
    public static int IterativeBinarySearch(int arr[], int l, int r, int k) {
        while(r >= l) {
            int mid = l + (r - l) / 2;

            if(arr[mid] == k) {
                return mid;
            } else if(arr[mid] > k) {
                l = mid + 1;
            } else{
                r = mid - 1;
            }
        }
        return -1;
    }

    public static int RecursiveIntepolationSearch(int arr[], int l, int r, int k) {
        if(l <= r && k >= arr[l] && k <= arr[r]) {
            int pos = l + (((r-l) / (arr[r] - arr[l])) * (k - arr[l]));

            if(arr[pos] == k) {
                return pos;
            } else if(arr[pos] > k) {
                return RecursiveIntepolationSearch(arr, l, pos-1, k);
            } else{
                return RecursiveIntepolationSearch(arr, pos+1, r, k);
            }
        }
        return -1;
    }

    public static int IterativeInterpolationSearch(int arr[], int l, int r, int k) {
        while(l <= r && k >= arr[l] && k <= arr[r]) {
            int pos= l + (((r - l) / (arr[r] - arr[l])) * (k - arr[l]));

            if(l == r) {
                if(arr[l] == k) {
                    return l;
                }
                return -1;
            }
            if(arr[pos] == k) {
                return pos;
            } else if(arr[pos] > k) {
                l = pos + 1;
            } else{
                r = pos - 1;
            }
        }
        return -1;
    }
    static void PrintHasil(int result) {
        if(result == -1) {
            System.out.println("Data tidak ditemukan!");
        } else {
            System.out.println("Data ditemukan pada indeks ke: " + result);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 10, 30, 40 };
        int size = arr.length;

        System.out.print("Data: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Data: ");
        int x = input.nextInt();

        int result;
//        result = IterativeLinearSearch(arr, size, x);
//        result = RecursiveLinearSearch(arr, size, x);
//        result = RecursiveSequentialSearch(arr, 0, size-1, x);
//        result = RecursiveBinarySearch(arr, 0, size-1, x);
//        result = IterativeBinarySearch(arr, 0, size-1, x);
//        result = RecursiveIntepolationSearch(arr, 0, size-1, x);
        result = IterativeInterpolationSearch(arr, 0, size-1, x);

        PrintHasil(result);
    }
}
