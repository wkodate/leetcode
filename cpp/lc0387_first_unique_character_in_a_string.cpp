#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int firstUniqChar(string s) {
    map<char, int> map;
    for (int i = 0; i < s.size(); i++) {
      char c = s.at(i);
      if (map.count(c)) {
        map[c]++;
      } else {
        map[c] = 1;
      }
    }
    for (int i = 0; i < s.size(); i++) {
      char c = s.at(i);
      if (map[c] == 1) {
        return i;
      }
    }
    return -1;
  }
};

int main() {
  Solution s;
  // 0
  cout << s.firstUniqChar("leetcode") << endl;
  // 2
  cout << s.firstUniqChar("loveleetcode") << endl;
  // -1
  cout << s.firstUniqChar("aabb") << endl;
}