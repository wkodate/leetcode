#include <bits/stdc++.h>
using namespace std;
#include "./libs/array.h"

class Solution {
public:
  int removeElement(vector<int> &nums, int val) {
    int cnt = 0;
    for (int i = 0; i < nums.size(); i++) {
      if (nums[i] == val) {
        nums[i] = 100;
        cnt++;
      }
    }
    sort(nums.begin(), nums.end());
    printArray(nums);
    return nums.size() - cnt;
  }
};

int main() {
  Solution s;
  // 2, nums = [2,2,_,_]
  vector<int> nums = {3, 2, 2, 3};
  cout << s.removeElement(nums, 3) << endl;
  // 5, nums = [0,1,4,0,3,_,_,_]
  vector<int> nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
  cout << s.removeElement(nums2, 2) << endl;
}