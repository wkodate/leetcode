#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int findLucky(vector<int> &arr) {
    map<int, int> map;
    for (int i = 0; i < arr.size(); i++) {
      if (map.count(arr[i])) {
        map[arr[i]] = map[arr[i]] + 1;
      } else {
        map[arr[i]] = 1;
      }
    }

    int res = -1;
    for (auto p : map) {
      if (p.first == p.second && p.first > res) {
        res = p.first;
      }
    }
    return res;
  }
};

int main() {
  Solution s;
  // 2
  vector<int> arr1 = {2, 2, 3, 4};
  cout << s.findLucky(arr1) << endl;
  // 3
  vector<int> arr2 = {1, 2, 2, 3, 3, 3};
  cout << s.findLucky(arr2) << endl;
  // -1
  vector<int> arr3 = {2, 2, 2, 3, 3};
  cout << s.findLucky(arr3) << endl;
}