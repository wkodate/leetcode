#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int countOdds(int low, int high) {
    if (low % 2 == 0) {
      low += 1;
    }
    if (high % 2 == 0) {
      high -= 1;
    }
    return (high - low) / 2 + 1;
  }
};

int main() {
  Solution s;
  // 3
  cout << s.countOdds(3, 7) << endl;
  // 1
  cout << s.countOdds(8, 10) << endl;
}