#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int countNegatives(vector<vector<int>> &grid) {
    int res = 0;
    for (int i = 0; i < grid.size(); i++) {
      int left = -1;
      int right = grid[i].size();
      while (right - left > 1) {
        int mid = left + (right - left) / 2;
        if (grid[i][mid] < 0) {
          right = mid;
        } else {
          left = mid;
        }
      }
      res += grid[i].size() - right;
    }
    return res;
  }
};

int main() {
  Solution s;
  // 8
  vector<vector<int>> grid1 = {
      {4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
  cout << s.countNegatives(grid1) << endl;
  // 0
  vector<vector<int>> grid2 = {{3, 2}, {1, 0}};
  cout << s.countNegatives(grid2) << endl;
}