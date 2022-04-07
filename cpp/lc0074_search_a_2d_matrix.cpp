#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  bool searchMatrix(vector<vector<int>> &matrix, int target) {
    int l1 = -1;
    int r1 = (int)matrix.size();
    while (r1 - l1 > 1) {
      int mid = l1 + (r1 - l1) / 2;
      if (matrix[mid][matrix[0].size() - 1] >= target) {
        r1 = mid;
      } else {
        l1 = mid;
      }
    }
    cout << "l1=" << l1 << ",r1=" << r1 << endl;
    if (r1 > matrix.size() - 1) {
      return false;
    }
    int l2 = -1;
    int r2 = (int)matrix[0].size();
    while (r2 - l2 > 1) {
      int mid = l2 + (r2 - l2) / 2;
      if (matrix[r1][mid] >= target) {
        r2 = mid;
      } else {
        l2 = mid;
      }
    }
    if (r2 > matrix[0].size() - 1) {
      return false;
    }
    return matrix[r1][r2] == target;
  }
};

int main() {
  Solution s;
  // true
  vector<vector<int>> nums = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
  cout << s.searchMatrix(nums, 3) << endl;
  // false
  cout << s.searchMatrix(nums, 13) << endl;
  // true
  cout << s.searchMatrix(nums, 1) << endl;
  // true
  cout << s.searchMatrix(nums, 60) << endl;
  // false
  cout << s.searchMatrix(nums, 61) << endl;
}