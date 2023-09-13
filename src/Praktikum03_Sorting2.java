public class Praktikum03_Sorting2 {
    void InsertionSort(int arr[]) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    void SelectionSort(int arr[]) {
        int n = arr.length;
        for(int i = 0; i < n-1; i++) {
            int min_idx = i;
            for(int j = i+1; j<n; j++) {
                if(arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
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
    int ShellSort2(int arr[]) {
        int n = arr.length;
        for(int gap=n/2; gap > 0; gap /= 2) {
            for(int i = gap; i < n; i+=1) {
                int temp = arr[i];

                int j;
                for(j = i; j >= gap && arr[j - gap] < temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
        return 0;
    }
    void printArray(int arr[]) {
        System.out.println("Hasil Pengurutan: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 9, 7, 8};
        System.out.println("Data Asli: ");
        for(int m = 0; m < arr.length; m++) {
            System.out.print(arr[m] + " ");
        }
        System.out.println();
        Praktikum03_Sorting2 ob = new Praktikum03_Sorting2();
//        ob.InsertionSort(arr);
//        ob.SelectionSort(arr);
//        ob.BubbleSort(arr);
        ob.ShellSort2(arr);

        System.out.println();
        ob.printArray(arr);
    }
}
