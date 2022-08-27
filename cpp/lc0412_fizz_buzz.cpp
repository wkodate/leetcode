#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  vector<string> fizzBuzz(int n) {
    vector<string> res = {};
    for (int i = 1; i <= n; i++) {
      if (i % 3 == 0 && i % 5 == 0) {
        res.push_back("FizzBuzz");
      } else if (i % 3 == 0) {
        res.push_back("Fizz");
      } else if (i % 5 == 0) {
        res.push_back("Buzz");
      } else {
        res.push_back(to_string(i));
      }
    }
    return res;
  }
};

int main() {
  Solution s;
  // ["1","2","Fizz"]
  vector<string> ans = s.fizzBuzz(3);
  for (int i = 0; i < ans.size(); i++) {
    cout << ans[i] << endl;
  }

  // ["1","2","Fizz","4","Buzz"]
  vector<string> ans2 = s.fizzBuzz(5);
  for (int i = 0; i < ans2.size(); i++) {
    cout << ans2[i] << endl;
  }

  // ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
  vector<string> ans3 = s.fizzBuzz(15);
  for (int i = 0; i < ans3.size(); i++) {
    cout << ans3[i] << endl;
  }
}