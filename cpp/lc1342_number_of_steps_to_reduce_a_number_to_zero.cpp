#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int numberOfSteps(int num) {
    int res = 0;
    while (num != 0) {
      if (num % 2 == 0) {
        num /= 2;
      } else {
        num -= 1;
      }
      res++;
    }
    return res;
  }
};

int main() {
  Solution s;
  // 6
  cout << s.numberOfSteps(14) << endl;
  // 4
  cout << s.numberOfSteps(8) << endl;
}