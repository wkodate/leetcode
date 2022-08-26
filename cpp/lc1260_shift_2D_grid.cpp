#include <bits/stdc++.h>
using namespace std;

class Solution {
 public:
  vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {
    vector<vector<int>> res(grid.size(), vector<int>(grid[0].size()));
    int row_size = grid.size();
    int col_size = grid[0].size();
    for (int i = 0; i < row_size; i++) {
      for (int j = 0; j < col_size; j++) {
        int shift_row = (i + (j + k) / col_size) % row_size;
        int shift_col = (j + k) % col_size;
        res[shift_row][shift_col] = grid[i][j];
      }
    }
    return res;
  }
};

int main() {
  Solution s;
  // [[9,1,2],[3,4,5],[6,7,8]]
  vector<vector<int>> grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
  vector<vector<int>> res = s.shiftGrid(grid, 1);
  for (int i = 0; i < res.size(); i++) {
    for (int j = 0; j < res[0].size(); j++) {
      cout << res[i][j] << " ";
    }
    cout << endl;
  }

  // [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
  vector<vector<int>> grid2 = {
      {3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}};
  vector<vector<int>> res2 = s.shiftGrid(grid2, 4);
  for (int i = 0; i < res2.size(); i++) {
    for (int j = 0; j < res2[0].size(); j++) {
      cout << res2[i][j] << " ";
    }
    cout << endl;
  }

  // [[1,2,3],[4,5,6],[7,8,9]]
  vector<vector<int>> grid3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
  vector<vector<int>> res3 = s.shiftGrid(grid3, 9);
  for (int i = 0; i < res3.size(); i++) {
    for (int j = 0; j < res3[0].size(); j++) {
      cout << res3[i][j] << " ";
    }
    cout << endl;
  }
}