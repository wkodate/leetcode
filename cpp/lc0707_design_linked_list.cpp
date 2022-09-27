#include <bits/stdc++.h>
using namespace std;

class MyLinkedList {
  vector<int> list;

public:
  MyLinkedList() {}

  int get(int index) {
    if (index >= list.size()) {
      return -1;
    }
    return list[index];
  }

  void addAtHead(int val) { addAtIndex(0, val); }

  void addAtTail(int val) { list.push_back(val); }

  void addAtIndex(int index, int val) {
    if (index > list.size()) {
      return;
    }
    list.insert(list.begin() + index, val);
  }

  void deleteAtIndex(int index) {
    if (index >= list.size()) {
      return;
    }
    list.erase(list.begin() + index);
  }
};

int main() {
  MyLinkedList *myLinkedList = new MyLinkedList();
  myLinkedList->addAtHead(1);
  myLinkedList->addAtTail(3);
  myLinkedList->addAtIndex(1, 2);
  // 2
  cout << myLinkedList->get(1) << endl;
  myLinkedList->deleteAtIndex(1);
  // 3
  cout << myLinkedList->get(1) << endl;
}