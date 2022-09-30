#include <bits/stdc++.h>
using namespace std;
#include "./libs/linkedlist.h"

class Solution {
public:
  bool isPalindrome(ListNode *head) {
    ListNode *slow = head;
    ListNode *fast = head;
    // Find middle
    while (fast && fast->next) {
      fast = fast->next->next;
      slow = slow->next;
    }

    // Reverse
    ListNode *prev = NULL;
    ListNode *curr = slow;
    while (curr) {
      ListNode *next = curr->next;
      curr->next = prev;
      prev = curr;
      curr = next;
    }

    // Compare
    while (prev) {
      if (prev->val != head->val) {
        return false;
      }
      prev = prev->next;
      head = head->next;
    }
    return true;
  }
};

int main() {
  Solution s;
  // true
  vector<int> head = {1, 2, 2, 1};
  cout << s.isPalindrome(createLinkedList(head)) << endl;
  // false
  vector<int> head2 = {1, 2};
  cout << s.isPalindrome(createLinkedList(head2)) << endl;
}