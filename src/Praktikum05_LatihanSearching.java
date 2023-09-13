import java.io.*;
import java.lang.*;
import java.util.*;
public class Praktikum05_LatihanSearching {
    public static int[] sisipSebelum(int[] arr, int kunci, int dataBaru) {
        int indexKunci = -1;

        for(int i = 0; i<arr.length; i++) {
            if(arr[i] == kunci) {
                indexKunci = i;
                break;
            }
        }
        if(indexKunci == -1) {
            System.out.println("Data kunci tidak ditemukan");
            return arr;
        }

        int[] hasil = new int[arr.length + 1];
        for(int i = 0; i < indexKunci; i++) {
            hasil[i] = arr[i];
        }
        hasil[indexKunci] = dataBaru;
        for(int i = indexKunci + 1; i < hasil.length; i++) {
            hasil[i] = arr[i - 1];
        }
        arr = hasil;
        return arr;
    }
    public static int[] addX(int n, int arr[], int x, int key) {
        int i;

        // create a new array of size n+1
        int newarr[] = new int[n + 1];

        // insert the elements from
        // the old array into the new array
        // insert all elements till n
        // then insert x at n+1
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];

        newarr[n] = x;

        return newarr;
    }

    public static void main(String[] args) {
        int n = 10;
        int i;

        // initial array of size 10
        int arr[]
                = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // print the original array
        System.out.println("Initial Array:\n"
                + Arrays.toString(arr));

        // element to be added
        int x;
        Scanner input = new Scanner(System.in);
        System.out.print("Add data search : ");
        x = input.nextInt();

        int y;
        System.out.println("Kata Kunci: ");
        y = input.nextInt();

        // call the method to add x in arr
//        arr = addX(n, arr, x, y);
        arr = sisipSebelum(arr, x, y);

        // print the updated array
        System.out.println("\nArray with " + x
                + " added:\n"
                + Arrays.toString(arr));
    }
}
