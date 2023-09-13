import java.util.Scanner;

public class Praktikum03_AlgoritmaSorting {
    // Insertion Algorithm
    void InsertionSort(int arr[]) {
        int n = arr.length;
        for(int i=1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j>=0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }

    /* Selection Sort */
    void SelectionSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int max_idx = i;
            for(int j = i+1; j<n; j++) {
                if (arr[j] > arr[max_idx]) {
                    max_idx = j;
                }
            }
            int temp = arr[max_idx];
            arr[max_idx] = arr[i];
            arr[i] = temp;
        }
    }

    /* Selection Sort */
    void BubbleSort(int arr[]) {
        int n = arr.length;
        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    void ShellSort(int arr[]) {
        int i;
        Boolean tukar = true;
        int jarak = arr.length;
        while(jarak > 1) {
            jarak = jarak/2;
            tukar = true;
            while(tukar) {
                tukar = false;
                i=0;
                while (i < arr.length - jarak) {
                    if(arr[i] > (arr[i + jarak])) {
                        int temp = arr[i];
                        arr[i] = arr[i + jarak];
                        arr[i + jarak] = temp;
                        tukar = true;
                    }
                    i++;
                }
            }
        }
    }

    int ShellSort2(int arr[]) {
        int n = arr.length;
        // Start with a big gap, then reduced the gap
        for(int gap=n/2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for(int i = gap; i < n; i+=1) {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = arr[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for(j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
            }
        }
        return 0;
    }
    void printArray(int arr[]) {
        // Hasil Sorting
        System.out.println("Hasil Pengurutan: ");
        for(int i=0; i< arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
//        int arr[] = {12, 11, 13, 5, 6};

        Scanner input = new Scanner(System.in);
        System.out.println("Tentukan jumlah data yang dimasukkan: ");
        int jumlah = input.nextInt();
        int arr[] = new int[jumlah];

        System.out.println("Masukkan Data: ");
        for(int i = 0; i < jumlah; i++) {
            arr[i] = input.nextInt();
        }
        System.out.print("Data yang diinput: ");
        for(int j = 0; j<arr.length; j++) {
            System.out.print(arr[j] + " ");
        }

        System.out.println();
        Praktikum03_AlgoritmaSorting ob = new Praktikum03_AlgoritmaSorting();
        ob.InsertionSort(arr);
//        ob.SelectionSort(arr);
//        ob.BubbleSort(arr);
//        ob.ShellSort(arr);
//        ob.ShellSort2(arr);

        ob.printArray(arr);
    }
}
