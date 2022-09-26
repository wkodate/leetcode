#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int thirdMax(vector<int> &nums) {
    set<int> s;
    for (int i = 0; i < nums.size(); i++) {
      s.insert(nums[i]);
    }
    priority_queue<int> queue;
    for (auto k : s) {
      queue.push(k);
    }
    if (queue.size() < 3) {
      return queue.top();
    }
    int res = 0;
    for (int i = 0; i < 3; i++) {
      res = queue.top();
      queue.pop();
    }
    return res;
  }
};

int main() {
  Solution s;
  // 1
  vector<int> nums = {3, 2, 1};
  cout << s.thirdMax(nums) << endl;
  // 2
  vector<int> nums2 = {1, 2};
  cout << s.thirdMax(nums2) << endl;
  // 1
  vector<int> nums3 = {2, 2, 3, 1};
  cout << s.thirdMax(nums3) << endl;
}