package com.example.advance.stream;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Stream;

public class GetStream {
    public static void main(String[] args) {
        getCollectionStream();
        getMapStream();
        getArrayStream();
    }

    /**
     * java.util.Collection 接口中加入了default方法 stream 用来获取流，所以其所有实现类均可获取流。
     */
    private static void getCollectionStream() {
        ArrayList<String> strings1 = new ArrayList<>();
        Stream<String> stream1 = strings1.stream();

        HashSet<String> strings2 = new HashSet<>();
        Stream<String> stream2 = strings2.stream();
    }

    private static void getMapStream() {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        Stream<String> keyStream = stringStringHashMap.keySet().stream();
        Stream<String> valueStream = stringStringHashMap.values().stream();

        Stream<Map.Entry<String, String>> entryStream = stringStringHashMap.entrySet().stream();
    }

    private static void getArrayStream() {
        int[] arr = {1, 2, 3, 4, 5};
        Stream<int[]> arr1 = Stream.of(arr);
    }
}
