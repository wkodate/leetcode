#include <bits/stdc++.h>
using namespace std;

class Solution {
 public:
  vector<int> topKFrequent(vector<int>& nums, int k) {
    map<int, int> count_map;
    for (int i = 0; i < nums.size(); i++) {
      count_map[nums[i]]++;
    }
    auto comp = [&count_map](int n1, int n2) {
      return count_map[n1] > count_map[n2];
    };
    priority_queue<int, vector<int>, decltype(comp)> heap(comp);

    for (pair<int, int> p : count_map) {
      heap.push(p.first);
      if (heap.size() > k) {
        heap.pop();
      }
    }
    vector<int> top(k);
    for (int i = k - 1; i >= 0; i--) {
      top[i] = heap.top();
      heap.pop();
    }
    return top;
  }
};

int main() {
  Solution s;
  vector<int> nums = {1, 1, 1, 2, 2, 3};

  // [1,2]
  vector<int> ans = s.topKFrequent(nums, 2);
  for (int i = 0; i < ans.size(); i++) {
    cout << ans[i] << endl;
  }

  // [1]
  vector<int> nums2 = {1};
  vector<int> ans2 = s.topKFrequent(nums2, 1);
  for (int i = 0; i < ans2.size(); i++) {
    cout << ans2[i] << endl;
  }

  // [1,3,4]
  vector<int> nums3 = {1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 5};
  vector<int> ans3 = s.topKFrequent(nums3, 3);
  for (int i = 0; i < ans3.size(); i++) {
    cout << ans3[i] << endl;
  }
}