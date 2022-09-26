#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int heightChecker(vector<int> &heights) {
    vector<int> expected = heights;
    sort(heights.begin(), heights.end());
    int res = heights.size();
    for (int i = 0; i < heights.size(); i++) {
      if (heights[i] == expected[i]) {
        res--;
      }
    }
    return res;
  }
};

int main() {
  Solution s;
  // 3
  vector<int> heights = {1, 1, 4, 2, 1, 3};
  cout << s.heightChecker(heights) << endl;
  // 5
  vector<int> heights2 = {5, 1, 2, 3, 4};
  cout << s.heightChecker(heights2) << endl;
  // 0
  vector<int> heights3 = {1, 2, 3, 4, 5};
  cout << s.heightChecker(heights3) << endl;
}