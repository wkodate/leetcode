#include <bits/stdc++.h>
using namespace std;
#include "./libs/array.h"

class Solution {
private:
  map<int, int> getNumFrequency(vector<int> nums) {
    map<int, int> map;
    for (int i = 0; i < nums.size(); i++) {
      if (map.count(nums[i])) {
        map[nums[i]]++;
      } else {
        map[nums[i]] = 1;
      }
    }
    return map;
  }

public:
  vector<int> intersect(vector<int> &nums1, vector<int> &nums2) {
    vector<int> res;
    map<int, int> map1 = getNumFrequency(nums1);
    map<int, int> map2 = getNumFrequency(nums2);
    for (auto m : map1) {
      if (map2.count(m.first)) {
        for (int i = 0; i < min(map1[m.first], map2[m.first]); i++) {
          res.push_back(m.first);
        }
      }
    }
    return res;
  }
};

int main() {
  Solution s;
  // [2,2]
  vector<int> nums1 = {1, 2, 2, 1};
  vector<int> nums2 = {2, 2};
  vector<int> out = s.intersect(nums1, nums2);
  printArray(out);
  // [4,9]
  vector<int> nums1_2 = {4, 9, 5};
  vector<int> nums2_2 = {9, 4, 9, 8, 4};
  vector<int> out2 = s.intersect(nums1_2, nums2_2);
  printArray(out2);
}