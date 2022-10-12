#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  bool isValid(string s) {
    stack<char> stack;
    for (int i = 0; i < s.size(); i++) {
      char c = s.at(i);
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else {
        if (stack.empty()) {
          return false;
        }
        char last = stack.top();
        if (last == '(' && c == ')' || last == '{' && c == '}' ||
            last == '[' && c == ']') {
          stack.pop();
        } else {
          return false;
        }
      }
    }
    return stack.empty();
  }
};

int main() {
  Solution s;
  // true
  cout << s.isValid("()") << endl;
  // true
  cout << s.isValid("()[]{}") << endl;
  // false
  cout << s.isValid("(]") << endl;
  // false
  cout << s.isValid("[") << endl;
  // false
  cout << s.isValid("]") << endl;
}