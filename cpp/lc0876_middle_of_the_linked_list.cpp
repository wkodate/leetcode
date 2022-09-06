#include <bits/stdc++.h>
using namespace std;
#include "./libs/linkedlist.h"

class Solution {
public:
  ListNode *middleNode(ListNode *head) {
    ListNode *node = head;
    int len = 0;
    while (node != NULL) {
      node = node->next;
      len++;
    }
    ListNode *res = head;
    for (int i = 0; i < len / 2; i++) {
      res = res->next;
    }
    return res;
  }
};

int main() {
  Solution s;
  // [3,4,5]
  vector<int> arr = {1, 2, 3, 4, 5};
  ListNode *node = createLinkedList(arr);
  printLinkedList(s.middleNode(node));
  // [4,5,6]
  vector<int> arr2 = {1, 2, 3, 4, 5, 6};
  ListNode *node2 = createLinkedList(arr2);
  printLinkedList(s.middleNode(node2));
}