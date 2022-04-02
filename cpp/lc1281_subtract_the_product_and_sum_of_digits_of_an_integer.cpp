#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int subtractProductAndSum(int n) {
    int pro = 1;
    int sum = 0;
    int s = to_string(n).size();
    for (int i = 0; i < s; i++) {
      int d = n % 10;
      pro *= d;
      sum += d;
      n /= 10;
    }
    return pro - sum;
  }
};

int main() {
  Solution s;
  // 15
  cout << s.subtractProductAndSum(234) << endl;
  // 21
  cout << s.subtractProductAndSum(4421) << endl;
}