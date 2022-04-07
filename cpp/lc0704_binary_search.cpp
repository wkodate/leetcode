#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int search(vector<int> &nums, int target) {
    int left = -1;
    int right = (int)nums.size();
    while (right - left > 1) {
      int mid = left + (right - left) / 2;
      if (nums[mid] >= target) {
        right = mid;
      } else {
        left = mid;
      }
    }
    if (right < nums.size() && nums[right] == target) {
      return right;
    }
    return -1;
  }
};

int main() {
  Solution s;
  // 4
  vector<int> nums = {-1, 0, 3, 5, 9, 12};
  cout << s.search(nums, 9) << endl;
  // -1
  cout << s.search(nums, 2) << endl;
  // -1
  vector<int> nums2 = {-1};
  cout << s.search(nums2, 2) << endl;
}