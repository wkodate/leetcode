#include <bits/stdc++.h>
using namespace std;
#include "./libs/array.h"

class Solution {
public:
  void duplicateZeros(vector<int> &arr) {
    for (int i = 0; i < arr.size() - 1; i++) {
      if (arr[i] != 0) {
        continue;
      }
      int tmp1 = 0;
      int tmp2 = arr[i + 1];
      for (int j = i + 1; j < arr.size() - 1; j++) {
        arr[j] = tmp1;
        tmp1 = tmp2;
        tmp2 = arr[j + 1];
      }
      arr[arr.size() - 1] = tmp1;
      i++;
    }
    printArray(arr);
  }
};

int main() {
  Solution s;
  // [1,0,0,2,3,0,0,4]
  vector<int> arr1 = {1, 0, 2, 3, 0, 4, 5, 0};
  s.duplicateZeros(arr1);
  // [1,2,3]
  vector<int> arr2 = {1, 2, 3};
  s.duplicateZeros(arr2);
}