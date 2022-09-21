#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  bool checkIfExist(vector<int> &arr) {
    for (int i = 0; i < arr.size(); i++) {
      for (int j = i + 1; j < arr.size(); j++) {
        if (arr[i] == 2 * arr[j] || 2 * arr[i] == arr[j]) {
          return true;
        }
      }
    }
    return false;
  }
};

int main() {
  Solution s;
  // true
  vector<int> arr = {10, 2, 5, 3};
  cout << s.checkIfExist(arr) << endl;
  // false
  vector<int> arr2 = {3, 1, 7, 11};
  cout << s.checkIfExist(arr2) << endl;
  // true
  vector<int> arr3 = {7, 1, 14, 11};
  cout << s.checkIfExist(arr3) << endl;
}