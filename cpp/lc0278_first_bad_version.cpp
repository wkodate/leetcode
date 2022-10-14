#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  //bool isBadVersion(int version) { return version >= 4; }

  int firstBadVersion(int n) {
    long long left = -1;
    long long right = n;
    while (right - left >= 1) {
      int mid = left + (right - left) / 2;
      if (isBadVersion(mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
};

int main() {
  Solution s;
  // 4, bad=4
  cout << s.firstBadVersion(5) << endl;
  // 1, bad=1
  cout << s.firstBadVersion(1) << endl;
}