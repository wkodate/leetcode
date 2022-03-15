#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  vector<int> runningSum(vector<int> &nums) {
    vector<int> sum(nums.size());
    sum[0] = nums[0];
    for (int i = 1; i < nums.size(); i++) {
      sum[i] = sum[i - 1] + nums[i];
    }
    return sum;
  }
};

int main() {
  Solution s;
  vector<int> nums1 = {1, 2, 3, 4};
  vector<int> result1 = s.runningSum(nums1);
  for (int i = 0; i < result1.size(); i++) {
    // [1,3,6,10]
    cout << result1[i] << endl;
  }
  vector<int> nums2 = {1, 1, 1, 1, 1};
  vector<int> result2 = s.runningSum(nums2);
  for (int i = 0; i < result2.size(); i++) {
    // [1,2,3,4,5]
    cout << result2[i] << endl;
  }
  vector<int> nums3 = {3, 1, 2, 10, 1};
  vector<int> result3 = s.runningSum(nums3);
  for (int i = 0; i < result3.size(); i++) {
    // [3,4,6,16,17]
    cout << result3[i] << endl;
  }
}