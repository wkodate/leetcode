#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int brokenCalc(int startValue, int target) {
    int ans = 0;
    while (target > startValue) {
      ans++;
      if (target % 2 == 1) {
        target++;
      } else {
        target /= 2;
      }
    }
    return ans + startValue - target;
  }
};

int main() {
  Solution s;
  // 2
  cout << s.brokenCalc(2, 3) << endl;
  // 2
  cout << s.brokenCalc(5, 8) << endl;
  // 3
  cout << s.brokenCalc(3, 10) << endl;
}