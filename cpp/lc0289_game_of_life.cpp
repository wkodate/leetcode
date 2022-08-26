#include <bits/stdc++.h>
using namespace std;

class Solution {
 public:
  void gameOfLife(vector<vector<int>>& board) {
    vector<vector<int>> b(board.size(), vector<int>(board[0].size()));
    for (int i = 0; i < board.size(); i++) {
      for (int j = 0; j < board[0].size(); j++) {
        int count = 0;
        for (int di = -1; di <= 1; di++) {
          for (int dj = -1; dj <= 1; dj++) {
            if (di == 0 && dj == 0) {
              continue;
            }
            int row = i + di;
            int col = j + dj;
            if (row >= 0 && row < board.size() && col >= 0 &&
                col < board[0].size() && board[row][col] == 1) {
              count++;
            }
          }
        }
        if (count == 2 && board[i][j] == 1) {
          b[i][j] = 1;
        }
        if (count == 3) {
          b[i][j] = 1;
        }
      }
    }
    board = b;
    for (int i = 0; i < board.size(); i++) {
      for (int j = 0; j < board[0].size(); j++) {
        cout << board[i][j] << " ";
      }
      cout << endl;
    }
  }
};

int main() {
  Solution s;
  // [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
  vector<vector<int>> board = {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};
  s.gameOfLife(board);
  // [[1,1],[1,1]]
  vector<vector<int>> board2 = {{1, 1}, {1, 0}};
  s.gameOfLife(board2);
}