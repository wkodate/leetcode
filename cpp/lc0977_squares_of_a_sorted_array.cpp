#include <bits/stdc++.h>
using namespace std;
#include "./libs/array.h"

class Solution {
public:
  vector<int> sortedSquares(vector<int> &nums) {
    vector<int> res;
    for (int i = 0; i < nums.size(); i++) {
      res.push_back(nums[i] * nums[i]);
    }
    sort(res.begin(), res.end());
    return res;
  }
};

int main() {
  Solution s;
  // [0,1,9,16,100]
  vector<int> nums1 = {-4, -1, 0, 3, 10};
  vector<int> out1 = s.sortedSquares(nums1);
  printArray(out1);

  // [4,9,9,49,121]
  vector<int> nums2 = {-7, -3, 2, 3, 11};
  vector<int> out2 = s.sortedSquares(nums2);
  printArray(out2);
}