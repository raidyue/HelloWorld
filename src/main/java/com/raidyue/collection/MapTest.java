package com.raidyue.collection;

import java.util.HashMap;

/**
 * 15-11-20
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>() {{
            put("a", 1);
            put("b", 3);
            put("c", 2);
        }};


    }

}
