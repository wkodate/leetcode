#include <bits/stdc++.h>
using namespace std;

struct ListNode {
  int val;
  ListNode *next;
  ListNode() : val(0), next(nullptr) {}
  ListNode(int x) : val(x), next(nullptr) {}
  ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode *createLinkedList(vector<int> arr) {
  int n = arr.size();
  ListNode *head = new ListNode(arr[0]);
  ListNode *cur = head;
  for (int i = 1; i < n; i++) {
    cur->next = new ListNode(arr[i]);
    cur = cur->next;
  }
  return head;
}

void printLinkedList(ListNode *head) {
  ListNode *cur = head;
  while (true) {
    cout << cur->val;
    cur = cur->next;
    if (cur) {
      cout << " -> ";
    } else {
      break;
    }
  }
  cout << endl;
}
