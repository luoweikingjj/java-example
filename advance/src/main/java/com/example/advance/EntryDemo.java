package com.example.advance;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EntryDemo {
    public static void main(String[] args) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("黄晓明", "杨颖");
        stringStringHashMap.put("文章", "马伊琍");
        stringStringHashMap.put("邓超", "孙俪");

        Set<Map.Entry<String, String>> entries = stringStringHashMap.entrySet();
        for (Map.Entry entry : entries) {
            System.out.println(entry.getKey()+"|"+entry.getValue());
            // 邓超|孙俪
            // 文章|马伊琍
            // 黄晓明|杨颖
        }
    }
}
