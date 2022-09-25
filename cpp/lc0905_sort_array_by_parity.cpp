#include <bits/stdc++.h>
using namespace std;
#include "./libs/array.h"

class Solution {
public:
  vector<int> sortArrayByParity(vector<int> &nums) {
    vector<int> res;
    for (int i = 0; i < nums.size(); i++) {
      if (nums[i] % 2 == 0) {
        res.push_back(nums[i]);
      }
    }
    for (int i = 0; i < nums.size(); i++) {
      if (nums[i] % 2 != 0) {
        res.push_back(nums[i]);
      }
    }
    return res;
  }
};

int main() {
  Solution s;
  // [2,4,3,1]
  vector<int> arr1 = {3, 1, 2, 4};
  vector<int> out1 = s.sortArrayByParity(arr1);
  printArray(out1);
  // [0]
  vector<int> arr2 = {0};
  vector<int> out2 = s.sortArrayByParity(arr2);
  printArray(out2);
}