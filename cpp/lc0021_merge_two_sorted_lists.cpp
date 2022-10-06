#include <bits/stdc++.h>
using namespace std;
#include "./libs/linkedlist.h"

class Solution {
public:
  ListNode *mergeTwoLists(ListNode *list1, ListNode *list2) {
    ListNode *head = new ListNode();
    ListNode *curr = head;
    while (list1 && list2) {
      if (list1->val < list2->val) {
        curr->next = list1;
        list1 = list1->next;
      } else {
        curr->next = list2;
        list2 = list2->next;
      }
      curr = curr->next;
    }
    if (list1) {
      curr->next = list1;
    }
    if (list2) {
      curr->next = list2;
    }
    return head->next;
  }
};

int main() {
  Solution s;
  // [1,1,2,3,4,4]
  vector<int> list1 = {1, 2, 4};
  vector<int> list2 = {1, 3, 4};
  ListNode *out =
      s.mergeTwoLists(createLinkedList(list1), createLinkedList(list2));
  printLinkedList(out);
  // []
  vector<int> list1_2 = {};
  vector<int> list2_2 = {};
  ListNode *out2 =
      s.mergeTwoLists(createLinkedList(list1_2), createLinkedList(list2_2));
  printLinkedList(out2);
  // [0]
  vector<int> list1_3 = {};
  vector<int> list2_3 = {0};
  ListNode *out3 =
      s.mergeTwoLists(createLinkedList(list1_3), createLinkedList(list2_3));
  printLinkedList(out3);
}