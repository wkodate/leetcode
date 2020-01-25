package com.wkodate.leetcode.LC0535_EncodeAndDecodeTinyURL;

import java.util.HashMap;
import java.util.Map;

public class Codec {

    Map<String, String> keyToUrl = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = String.valueOf(longUrl.hashCode());
        keyToUrl.put(key, longUrl);
        StringBuilder sb = new StringBuilder("http://tinyurl.com/");
        sb.append(key);
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] splits = shortUrl.split("/");
        String key = splits[splits.length - 1];
        return String.valueOf(keyToUrl.get(key));
    }

    public static void main(String[] args) {
        Codec c = new Codec();
        String url = "https://leetcode.com/problems/design-tinyurl";
        // http://tinyurl.com/4e9iAk
        System.out.println(c.encode(url));
        System.out.println(c.decode(c.encode(url)));
    }

}
