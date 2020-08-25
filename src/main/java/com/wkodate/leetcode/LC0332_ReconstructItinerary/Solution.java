package com.wkodate.leetcode.LC0332_ReconstructItinerary;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        for (List<String> ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }

        LinkedList<String> path = new LinkedList<>();
        Deque<String> stack = new ArrayDeque<>();
        // start point
        stack.push("JFK");
        while (!stack.isEmpty()) {
            while (flights.containsKey(stack.peek()) && !flights.get(stack.peek()).isEmpty()) {
                stack.push(flights.get(stack.peek()).poll());
            }
            path.addFirst(stack.pop());
        }
        return path;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ["JFK", "MUC", "LHR", "SFO", "SJC"]
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(new ArrayList<>(Arrays.asList("MUC", "LHR")));
        tickets.add(new ArrayList<>(Arrays.asList("JFK", "MUC")));
        tickets.add(new ArrayList<>(Arrays.asList("SFO", "SJC")));
        tickets.add(new ArrayList<>(Arrays.asList("LHR", "SFO")));
        System.out.println(s.findItinerary(tickets));

        // ["JFK","ATL","JFK","SFO","ATL","SFO"]
        List<List<String>> tickets2 = new ArrayList<>();
        tickets2.add(new ArrayList<>(Arrays.asList("JFK", "SFO")));
        tickets2.add(new ArrayList<>(Arrays.asList("JFK", "ATL")));
        tickets2.add(new ArrayList<>(Arrays.asList("SFO", "ATL")));
        tickets2.add(new ArrayList<>(Arrays.asList("ATL", "JFK")));
        tickets2.add(new ArrayList<>(Arrays.asList("ATL", "SFO")));
        System.out.println(s.findItinerary(tickets2));
    }

}
