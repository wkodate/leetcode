#include <bits/stdc++.h>
using namespace std;
#include "./libs/array.h"

class Solution {
public:
  void merge(vector<int> &nums1, int m, vector<int> &nums2, int n) {
    for (int i = m; i < nums1.size(); i++) {
      nums1[i] = nums2[i - m];
    }
    sort(nums1.begin(), nums1.end());
    printArray(nums1);
  }
};

int main() {
  Solution s;
  // [1,2,2,3,5,6]
  vector<int> nums1 = {1, 2, 3, 0, 0, 0};
  vector<int> nums2 = {2, 5, 6};
  s.merge(nums1, 3, nums2, 3);
  // [1]
  vector<int> nums1_2 = {1};
  vector<int> nums2_2 = {};
  s.merge(nums1_2, 1, nums2_2, 0);
  // [1]
  vector<int> nums1_3 = {0};
  vector<int> nums2_3 = {1};
  s.merge(nums1_3, 0, nums2_3, 1);
}