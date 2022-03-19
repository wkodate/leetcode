#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int numSpecial(vector<vector<int>> &mat) {
    vector<int> row(mat.size());
    vector<int> col(mat[0].size());
    for (int i = 0; i < mat.size(); i++) {
      int cnt = 0;
      for (int j = 0; j < mat[0].size(); j++) {
        row[i] += mat[i][j];
        col[j] += mat[i][j];
      }
    }

    int res = 0;
    for (int i = 0; i < mat.size(); i++) {
      for (int j = 0; j < mat[0].size(); j++) {
        if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
          res++;
        }
      }
    }
    return res;
  }
};

int main() {
  Solution s;
  // 1
  vector<vector<int>> mat1 = {{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
  cout << s.numSpecial(mat1) << endl;
  // 3
  vector<vector<int>> mat2 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
  cout << s.numSpecial(mat2) << endl;
}