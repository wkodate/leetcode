#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int hammingWeight(uint32_t n) {
    int cnt = 0;
    for (int i = 31; i >= 0; i--) {
      if (n & (1 << i)) {
        cnt++;
      }
    }
    return cnt;
  }
};

int main() {
  Solution s;
  // 3
  bitset<32> n("00000000000000000000000000001011");
  cout << s.hammingWeight(n.to_ulong()) << endl;
  // 1
  bitset<32> n2("00000000000000000000000010000000");
  cout << s.hammingWeight(n2.to_ulong()) << endl;
  // 31
  bitset<32> n3("11111111111111111111111111111101");
  cout << s.hammingWeight(n3.to_ulong()) << endl;
}