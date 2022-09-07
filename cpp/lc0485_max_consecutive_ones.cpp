#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int findMaxConsecutiveOnes(vector<int> &nums) {
    int res = 0;
    int cnt = 0;
    for (int i = 0; i < nums.size(); i++) {
      if (nums[i] == 1) {
        cnt++;
      } else {
        res = max(cnt, res);
        cnt = 0;
      }
    }
    res = max(cnt, res);
    return res;
  }
};

int main() {
  Solution s;
  // 3
  vector<int> arr = {1, 1, 0, 1, 1, 1};
  cout << s.findMaxConsecutiveOnes(arr) << endl;
  // 2
  vector<int> arr2 = {1, 0, 1, 1, 0, 1};
  cout << s.findMaxConsecutiveOnes(arr2) << endl;
}