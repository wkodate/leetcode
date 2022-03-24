#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  double average(vector<int> &salary) {
    sort(salary.begin(), salary.end());
    double sum = 0;
    for (int i = 1; i < salary.size() - 1; i++) {
      sum += salary[i];
    }
    return sum / (salary.size() - 2);
  }
};

int main() {
  Solution s;
  // 2500.00000
  vector<int> salary = {4000, 3000, 1000, 2000};
  cout << s.average(salary) << endl;
  // 2000.00000
  vector<int> salary2 = {1000, 2000, 3000};
  cout << s.average(salary2) << endl;
}