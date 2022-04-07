#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int countTriples(int n) {
    set<int> s;
    for (int i = 1; i <= n; i++) {
      s.insert(i * i);
    }
    int count = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (s.count(i * i + j * j)) {
          count++;
        }
      }
    }
    return count;
  }
};

int main() {
  Solution s;
  // 2
  cout << s.countTriples(5) << endl;
  // 4
  cout << s.countTriples(10) << endl;
  // 4
  cout << s.countTriples(12) << endl;
}