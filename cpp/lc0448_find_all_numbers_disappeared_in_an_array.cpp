#include <bits/stdc++.h>
using namespace std;
#include "./libs/array.h"

class Solution {
public:
  vector<int> findDisappearedNumbers(vector<int> &nums) {
    vector<int> res;
    set<int> s;
    for (int i = 0; i < nums.size(); i++) {
      s.insert(nums[i]);
    }
    for (int i = 1; i <= nums.size(); i++) {
      if (!s.count(i)) {
        res.push_back(i);
      }
    }
    return res;
  }
};

int main() {
  Solution s;
  // [5,6]
  vector<int> nums = {4, 3, 2, 7, 8, 2, 3, 1};
  vector<int> out = s.findDisappearedNumbers(nums);
  printArray(out);
  // [2]
  vector<int> nums2 = {1, 1};
  vector<int> out2 = s.findDisappearedNumbers(nums2);
  printArray(out2);
}