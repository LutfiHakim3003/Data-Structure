// import 'Praktikum4_QuictSort.dart';
import 'Praktikum4_MergeSort.dart';

void main() {
  List<int> arr = [10, 7, 8, 9, 1, 5];
  print("List Data: ${arr}");

  int n = arr.length;
  // QuickSort(arr, 0, n - 1);

  MergeSort(arr, 0, n - 1);
  print("Hasil Sorting: ${arr}");
}
