// Searching Algorithm with Iteratively Linear Search
int IterativeLinearSearch(List<int> arr, int x) {
  int N = arr.length;
  for (int i = 0; i < N; i++) {
    if (arr[i] == x) {
      return i;
    }
  }
  return -1;
}

// Iteratively Linear Search with print for all data list searched
List<int> linerSearch(List<int> arr, int x) {
  List<int> temp = [];
  int N = arr.length;
  for (int i = 0; i < N; i++) {
    if (arr[i] == x) {
      temp.add(i);
    }
  }
  return temp;
}

// Searching Algorithm with Recursively Linear Search
int RecursiveLinearSearch(List<int> arr, int size, int key) {
  if (size == 0) {
    return -1;
  } else if (arr[size - 1] == key) {
    // Return the index of found key.
    return size - 1;
  } else {
    return RecursiveLinearSearch(arr, size - 1, key);
  }
}
