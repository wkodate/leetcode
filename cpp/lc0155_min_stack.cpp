#include <bits/stdc++.h>
using namespace std;

class MinStack {
public:
  stack<int> stack1;
  stack<int> stack2;

  MinStack() {}

  void push(int val) {
    stack1.push(val);
    if (stack2.empty() || val <= getMin()) {
      stack2.push(val);
    }
  }

  void pop() {
    if (stack1.top() == getMin()) {
      stack2.pop();
    }
    stack1.pop();
  }

  int top() { return stack1.top(); }

  int getMin() { return stack2.top(); }
};

int main() {
  MinStack *minStack = new MinStack();
  minStack->push(-2);
  minStack->push(0);
  minStack->push(-3);
  // return -3
  cout << minStack->getMin() << endl;
  minStack->pop();
  // return 0
  cout << minStack->top() << endl;
  // return -2
  cout << minStack->getMin() << endl;
}