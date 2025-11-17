import 'dart:io'; // Import untuk menggunakan stdout.write

// Bubble Sort Asc
void BubbleSortAsc(List<int> arr) {
  int n = arr.length;
  for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - i - 1; j++) {
      if (arr[j] > arr[j + 1]) {
        int temp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = temp;
      }
    }
  }
}

// Insertion Sort secara Ascending
void InsertionSortAsc(List<int> arr) {
  int n = arr.length;
  for (int i = 1; i < n; i++) {
    int key = arr[i];
    int j = i - 1;

    while (j >= 0 && arr[j] > key) {
      arr[j + 1] = arr[j];
      j = j - 1;
    }
    arr[j + 1] = key;
  }
}

// Insertion Sort secara Descending?
void InsertionSortDesc(List<int> arr) {
  int n = arr.length;
  for (int i = 1; i < n; i++) {
    int key = arr[i];
    int j = i - 1;

    while (j >= 0 && arr[j] < key) {
      arr[j + 1] = arr[j];
      j = j - 1;
    }
    arr[j + 1] = key;
  }
}

// Selection Sort Asc
void SelectionSortAsc(List<int> arr) {
  int n = arr.length;
  for (int i = 0; i < n - 1; i++) {
    int minIdx = i;
    for (int j = i + 1; j < n; j++) {
      if (arr[j] < arr[minIdx]) {
        minIdx = j;
      }
    }
    int temp = arr[minIdx];
    arr[minIdx] = arr[i];
    arr[i] = temp;
  }
}

// Selection Sort Desc ?
void ShellSortAsc(List<int> arr) {
  int n = arr.length;
  for (int gap = n ~/ 2; gap > 0; gap ~/= 2) {
    for (int i = gap; i < n; i += 1) {
      int temp = arr[i];

      int j;
      for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
        arr[j] = arr[j - gap];
      }

      arr[j] = temp;
    }
  }
}

void PrintArray(List<int> arr) {
  print("Hasil Pengurutan: ");
  for (int i = 0; i < arr.length; i++) {
    print("${arr[i]} ");
  }
}

void PrintData(List<int> data) {
  stdout.write("Hasil Pengurutan: ");
  for (int i = 0; i < data.length; i++) {
    stdout.write("${data[i]} ");
  }
  stdout.writeln(); // Untuk menambahkan baris baru setelah selesai mencetak
}

void main() {
  List<int> arr = [4, 2, 5, 3, 9];
  print('List Data: $arr');
  BubbleSortAsc(arr);
  // InsertionSortAsc(arr);
  // InsertionSortDesc(arr);
  // SelectionSortAsc(arr);
  // ShellSortAsc(arr);
  // PrintData(arr);
  print(arr);
}
