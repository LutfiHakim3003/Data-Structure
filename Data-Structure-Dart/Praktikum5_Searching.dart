// import 'Praktikum5_LinearSearch.dart';
import 'Praktikum5_BinarySearch.dart';

void main() {
  List<int> arr = [2, 3, 4, 10, 40];
  int x = 10;
  int size = arr.length;
  // int result = IterativeLinearSearch(arr, x);
  //int result = RecursiveLinearSearch(arr, size, x);
  // List<int> result = linerSearch(arr, x);

  int result = RecursiveBinarySearch(arr, 0, size - 1, x);

  // if (result.isEmpty) {
  //   print("Elemen tidak ada dalam List");
  // } else {
  //   print("Elemen ditemukan pada indeks ke: $result");
  // }
  if (result == -1) {
    print("Elemen tidak ada dalam List");
  } else {
    print("Elemen ditemukan pada indeks ke: $result");
  }
}
