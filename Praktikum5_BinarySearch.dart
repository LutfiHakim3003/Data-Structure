// Binary Search Recursively
int RecursiveBinarySearch(List<int> arr, int l, int r, int x) {
  if (r >= l) {
    int mid = l + ((r - l) ~/ 2);

    if (arr[mid] == x) {
      return mid;
    } else if (arr[mid] > x) {
      return RecursiveBinarySearch(arr, l, mid - 1, x);
    } else {
      return RecursiveBinarySearch(arr, mid + 1, r, x);
    }
  }
  return -1;
}

// Binary Search Iteratively
void IterativeBinarySearch(List<int> arr, int l, int r, int x) {
  while (r - l > 1) {
    int mid = (l + r) ~/ 2;
    if (arr[mid] < x) {
      l = mid + 1;
    } else {
      r = mid;
    }
  }
  if (arr[l] == x) {
    print("Data ditemukan pada Index ke $l");
  } else if (arr[r] == x) {
    print("Data ditemukan pada Index ke $r");
  } else {
    print("Data tidak ditemukan!");
  }
}
