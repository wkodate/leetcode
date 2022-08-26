#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int maximumWealth(vector<vector<int>> &accounts) {
    int wealth = 0;
    for (int i = 0; i < accounts.size(); i++) {
      int sum = 0;
      for (int j = 0; j < accounts[0].size(); j++) {
        sum += accounts[i][j];
      }
      wealth = max(sum, wealth);
    }
    return wealth;
  }
};

int main() {
  Solution s;
  // 6
  vector<vector<int>> accounts1 = {{1, 2, 3}, {3, 2, 1}};
  cout << s.maximumWealth(accounts1) << endl;
  // 10
  vector<vector<int>> accounts2 = {{1, 5}, {7, 3}, {3, 5}};
  cout << s.maximumWealth(accounts2) << endl;
  // 17
  vector<vector<int>> accounts3 = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
  cout << s.maximumWealth(accounts3) << endl;
}