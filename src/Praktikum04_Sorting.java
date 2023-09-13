import java.util.Scanner;

public class Praktikum04_Sorting {
    /* Quick Sort Algorithm */
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        /* Index of smaller element indicates the right position
            of pivot found so far
        */
        int i = (low - 1);
        for(int j = low; j <= high-1; j++) {
            // If current element is smaller than the pivot
            if(arr[j] < pivot) {
              // increment index of smaller element
              i++;
              swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    static void QuickSort(int[] arr, int low, int high) {
        if(low < high) {
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            QuickSort(arr, low, pi - 1);
            QuickSort(arr, pi + 1, high);
        }
    }

    /* Merge Sort Algorithm */
    static void Merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i=0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while(i < n1 && j < n2) {
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while(i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        /* Copy remaining elements of R[] if any */
        while(j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    static void MergeSort(int arr[], int l, int r) {
        if(l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            MergeSort(arr, l, m);
            MergeSort(arr, m + 1, r);

            // Merge the sorted halves
            Merge(arr, l, m, r);
        }
    }
    /* Print Hasil Sorting */
    static void PrintArray(int arr[]) {
        int size = arr.length;
        for(int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = { 10, 7, 8, 9, 1, 5 };
        int size = arr.length;

        System.out.println("Data Belum Urut: ");
        for(int m = 0; m < size; m++) {
            System.out.print(arr[m] + " ");
        }
        System.out.println();

        Scanner input = new Scanner(System.in);
        System.out.println("Pilihan:");
        System.out.println("1. Quick Sort");
        System.out.println("2. Merge Sort");
        System.out.print("Masukkan Pilihan: ");
        int pilihan = input.nextInt();

        switch (pilihan) {
            case 1:
                QuickSort(arr, 0, size - 1);
                System.out.println("Hasil Pengurutan dengan Quick Sort: ");
                break;
            case 2:
                MergeSort(arr, 0, size - 1);
                System.out.println("Hasil Pengurutan dengan Merge Sort: ");
                break;
            default:
                System.out.println("Pilihan tidak Tersedia!");
        }

//        QuickSort(arr, 0, n - 1);
//        MergeSort(arr, 0, n - 1);
        PrintArray(arr);
    }
}