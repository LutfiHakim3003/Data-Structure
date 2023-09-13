public class Praktikum04_Sorting2 {
    /* Quick Sort */
    static void QuickSort(int[] arr, int low, int high) {
        // low = indeks mulai melakukan iterasi
        // high = indeks batas melakukan iterasi
        if(low < high) {
            // pi adalah indeks pembagi, arr[high] adalah indeks paling kanan sendiri
            int pi = partition(arr, low, high);

            // Qoncuer untuk data pada indeks sebelum pivot
            QuickSort(arr, low, pi - 1);
            // Qoncuer untuk data pada indeks setelah pivot
            QuickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int i = low - 1;
        for(int j = low; j <= high-1; j++) {
            if(arr[j] > pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i + 1;
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* Merge Sort Algorithm */
    static void MergeSort(int[] arr, int l, int r) {
        if(l < r) {
            int m = l + (r-l) / 2;

            MergeSort(arr, l, m); // elemen sebelah kiri
            MergeSort(arr, m+1, r); // elemen sebelah kanan

            Merge(arr, l, m, r);
        }
    }
    static void  Merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i=0; i<n1; i++)
            L[i] = arr[l + i];
        for(int j=0; j<n2; j++)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;

        while(i < n1 && j < n2) {
            if(L[i] >= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    /* Cetak Array */
    static void PrintArray(int[] arr) {
        int size = arr.length;
        for(int i=0; i<size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = { 10, 7, 8, 9, 1, 5, 7, 6, 11, 12 };
        int size = arr.length;

        System.out.println("Data Belum Urut: ");
        PrintArray(arr);

        System.out.println();
        System.out.println("Data Hasil Pengurutan: ");
//        QuickSort(arr, 0, size-1);
        MergeSort(arr, 0, size-1);
        PrintArray(arr);
    }
}
