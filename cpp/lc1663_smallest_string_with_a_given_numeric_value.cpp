#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  string getSmallestString(int n, int k) {
    string res = "";
    for (int i = 0; i < n; i++) {
      if ((k - (n - res.size() - 1)) / 26 == 0) {
        res += (char)('a' - 1 + k - (n - res.size() - 1));
        while (n > res.size()) {
          res += 'a';
        }
        break;
      }
      res += 'z';
      k -= 26;
    }
    reverse(res.begin(), res.end());
    return res;
  }
};

int main() {
  Solution s;
  // "aay"
  cout << s.getSmallestString(3, 27) << endl;
  // "aaszz"
  cout << s.getSmallestString(5, 73) << endl;
}