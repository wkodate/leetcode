package com.wkodate.leetcode.LC0690_EmployeeImportance;

import com.wkodate.leetcode.Employee;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> empMap = new HashMap<>();
        for (Employee emp : employees) {
            empMap.put(emp.id, emp);
        }
        Employee root = empMap.get(id);
        int sum = 0;
        Deque<Employee> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Employee emp = queue.remove();
            sum += emp.importance;
            if (emp.subordinates.isEmpty()) {
                continue;
            }
            for (Integer subId : emp.subordinates) {
                queue.add(empMap.get(subId));
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        Employee e1 = new Employee(1, 5, list);
        Employee e2 = new Employee(2, 3, new ArrayList<>());
        Employee e3 = new Employee(3, 3, new ArrayList<>());
        List<Employee> emps = new ArrayList<>();
        emps.add(e1);
        emps.add(e2);
        emps.add(e3);
        System.out.println(s.getImportance(emps, 1));
    }

}
