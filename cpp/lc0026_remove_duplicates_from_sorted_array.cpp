#include <bits/stdc++.h>
using namespace std;
#include "./libs/array.h"

class Solution {
public:
  int removeDuplicates(vector<int> &nums) {
    if (nums.size() == 1) {
      return 1;
    }
    int cnt = 0;
    int max_number = 100;
    int i = 0;
    int j = 1;
    while (i < nums.size() && j < nums.size()) {
      if (nums[i] == nums[j]) {
        nums[j++] = max_number;
        cnt++;
        continue;
      }
      i = j++;
    }
    sort(nums.begin(), nums.end());
    printArray(nums);
    return nums.size() - cnt;
  }
};

int main() {
  Solution s;
  // 2, nums = [1,2,_]
  vector<int> nums = {1, 1, 2};
  cout << s.removeDuplicates(nums) << endl;
  // 5, nums = [0,1,2,3,4,_,_,_,_,_]
  vector<int> nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
  cout << s.removeDuplicates(nums2) << endl;
}