#include <bits/stdc++.h>
using namespace std;
#include "./libs/array.h"

class Solution {
public:
  void moveZeroes(vector<int> &nums) {
    vector<int> arr;
    int zero_count = 0;
    for (int i = 0; i < nums.size(); i++) {
      if (nums[i] == 0) {
        zero_count++;
      } else {
        arr.push_back(nums[i]);
      }
    }
    for (int i = 0; i < zero_count; i++) {
      arr.push_back(0);
    }
    for (int i = 0; i < nums.size(); i++) {
      nums[i] = arr[i];
    }
    printArray(nums);
  }
};

int main() {
  Solution s;
  // [1,3,12,0,0]
  vector<int> nums1 = {0, 1, 0, 3, 12};
  s.moveZeroes(nums1);
  // [0]
  vector<int> nums2 = {0};
  s.moveZeroes(nums2);
  // [1,0,0]
  vector<int> nums3 = {0, 0, 1};
  s.moveZeroes(nums3);
}