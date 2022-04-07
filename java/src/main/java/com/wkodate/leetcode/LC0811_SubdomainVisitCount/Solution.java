package com.wkodate.leetcode.LC0811_SubdomainVisitCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] cpdomainArr = cpdomain.split(" ", 2);
            int count = Integer.parseInt(cpdomainArr[0]);
            String domain = cpdomainArr[1];
            String subdomain = "";
            String[] splitted = domain.split("\\.");
            for (int i = splitted.length - 1; i >= 0; i--) {
                if ("".equals(subdomain)) {
                    subdomain = splitted[i];
                } else {
                    subdomain = splitted[i] + "." + subdomain;
                }
                map.put(subdomain, map.getOrDefault(subdomain, 0) + count);
            }
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(e.getValue());
            sb.append(" ");
            sb.append(e.getKey());
            ans.add(sb.toString());
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
        System.out.println(s.subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
        // ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
        System.out.println(s.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }

}
