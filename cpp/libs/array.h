#include <bits/stdc++.h>
using namespace std;

void printArray(vector<string> &data) {
  cout << "[";
  for (int i = 0; i < data.size(); i++) {
    cout << data[i];
    if (i != data.size() - 1) {
      cout << " ";
    }
  }
  cout << "]" << endl;
}

void printArray(vector<int> &data) {
  vector<string> data_str;
  for (int i = 0; i < data.size(); i++) {
    data_str.push_back(to_string(data[i]));
  }
  printArray(data_str);
}