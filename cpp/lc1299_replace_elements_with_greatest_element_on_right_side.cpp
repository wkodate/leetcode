#include <bits/stdc++.h>
using namespace std;
#include "./libs/array.h"

class Solution {
public:
  vector<int> replaceElements(vector<int> &arr) {
    vector<int> res = {-1};
    int maximum = -1;
    for (int i = arr.size() - 1; i > 0; i--) {
      maximum = max(arr[i], maximum);
      res.push_back(maximum);
    }
    reverse(res.begin(), res.end());
    return res;
  }
};

int main() {
  Solution s;
  // [18,6,6,6,1,-1]
  vector<int> arr1 = {17, 18, 5, 4, 6, 1};
  vector<int> out1 = s.replaceElements(arr1);
  printArray(out1);
  // [-1]
  vector<int> arr2 = {400};
  vector<int> out2 = s.replaceElements(arr2);
  printArray(out2);
}