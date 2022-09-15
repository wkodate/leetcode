#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int findNumbers(vector<int> &nums) {
    int res = 0;
    for (int i = 0; i < nums.size(); i++) {
      if (to_string(nums[i]).size() % 2 == 0) {
        res++;
      }
    }
    return res;
  }
};

int main() {
  Solution s;
  // 2
  vector<int> nums1 = {12, 345, 2, 6, 7896};
  cout << s.findNumbers(nums1) << endl;
  // 1
  vector<int> nums2 = {555, 901, 482, 1771};
  cout << s.findNumbers(nums2) << endl;
}