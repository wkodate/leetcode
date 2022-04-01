#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  void reverseString(vector<char> &s) {
    for (int i = 0; i < s.size() / 2; i++) {
      char tmp = s[i];
      s[i] = s[s.size() - i - 1];
      s[s.size() - i - 1] = tmp;
    }
  }
};

int main() {
  Solution s;

  vector<char> str = {'h', 'e', 'l', 'l', 'o'};
  s.reverseString(str);
  vector<char> str2 = {'H', 'a', 'n', 'n', 'a', 'h'};
  s.reverseString(str2);
}