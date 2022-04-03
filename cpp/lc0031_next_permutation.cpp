#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
  void swap(vector<int> &nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  void reverse(vector<int> &nums, int start) {
    int i = start;
    int j = nums.size() - 1;
    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }

public:
  void nextPermutation(vector<int> &nums) {
    int i = nums.size() - 2;
    while (i >= 0 && nums[i + 1] <= nums[i]) {
      i--;
    }
    if (i >= 0) {
      int j = nums.size() - 1;
      while (nums[j] <= nums[i]) {
        j--;
      }
      swap(nums, i, j);
    }
    reverse(nums, i + 1);

    for (int i = 0; i < nums.size(); i++) {
      cout << nums[i];
    }
    cout << endl;
  }
};

int main() {
  Solution s;
  // [1,3,2]
  vector<int> nums = {1, 2, 3};
  s.nextPermutation(nums);
  // [1,2,3]
  vector<int> nums2 = {3, 2, 1};
  s.nextPermutation(nums2);
  // [1,5,1]
  vector<int> nums3 = {1, 1, 5};
  s.nextPermutation(nums3);
}