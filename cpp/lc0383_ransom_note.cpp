#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  bool canConstruct(string ransomNote, string magazine) {
    map<char, int> dict;
    for (int i = 0; i < magazine.size(); i++) {
      dict[magazine[i]]++;
    }
    for (int i = 0; i < ransomNote.size(); i++) {
      char c = ransomNote[i];
      if (dict.count(c) == 0 || dict[c] <= 0) {
        return false;
      }
      dict[c]--;
    }
    return true;
  }
};

int main() {
  Solution s;
  // false
  cout << s.canConstruct("a", "b") << endl;
  // false
  cout << s.canConstruct("aa", "ab") << endl;
  // true
  cout << s.canConstruct("aa", "aab") << endl;
}