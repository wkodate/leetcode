#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  bool validMountainArray(vector<int> &arr) {
    if (arr.size() < 3) {
      return false;
    }
    bool increasing = true;
    for (int i = 0; i < arr.size() - 1; i++) {
      if (increasing) {
        if (arr[i] > arr[i + 1]) {
          if (i == 0) {
            return false;
          }
          increasing = false;
        } else if (arr[i] == arr[i + 1]) {
          return false;
        }
      } else {
        if (arr[i] <= arr[i + 1]) {
          return false;
        }
      }
    }
    return !increasing;
  }
};

int main() {
  Solution s;
  // false
  vector<int> arr1 = {2, 1};
  cout << s.validMountainArray(arr1) << endl;
  // false
  vector<int> arr2 = {3, 5, 5};
  cout << s.validMountainArray(arr2) << endl;
  // true
  vector<int> arr3 = {0, 3, 2, 1};
  cout << s.validMountainArray(arr3) << endl;
  // false
  vector<int> arr4 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
  cout << s.validMountainArray(arr4) << endl;
}