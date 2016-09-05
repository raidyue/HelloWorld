package com.raidyue.helloworld;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 15-12-7
 */
public class HelloWorld {

    public static void main(String[] args) {
//        String query = "快乐大本营 第一集精彩片段";
//        for (char c : query.toCharArray()) {
//            System.out.println(Character.toString(c).matches("[0-9A-Za-z\\u4E00-\\u9FA5]+"));
//        }
//        System.out.println(query.replaceAll("[^0-9A-Za-z\\u4E00-\\u9FA5]","").length());
        split_word();
//        rmBracket("sda(2013)（纯表演版）");
    }

    public static String rmBracket(String title) {
        /**
         * 去掉中英文括号
         */
        String newTitle = title.replaceAll("\\(.*?\\)|（.*?）", "");
        return newTitle;
    }

    public static void split_word() {
        priorityQuery();
        Pattern pattern = Pattern.compile("([a-zA-Z\\u4E00-\\u9FA5·]+?)[0-9]{1,2}之.*$");
        match_word(pattern, "猪猪侠9");
    }

    static Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            System.out.println(String.format("%s>%s=%s", o1, o2, o1 > o2));
//            if (o1 > o2) {
//                return -1;
//            } else if (o1 < o2) {
//                return 1;
//            } else {
//                return 0;
//            }
            return 0;
        }
    };

    public static void priorityQuery() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);
        queue.add(1243);
        queue.add(23);
        queue.add(123);
        for (Integer aQueue : queue) {
            System.out.println(aQueue);
        }
        Integer item = queue.poll();
        while (item != null) {
            System.out.println(item);
            item = queue.poll();
        }
    }


    public static void match_word(Pattern pattern, String str) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {

            System.out.println(String.format("groupCount=%s group0=%s group1=%s",
                                             matcher.groupCount(), matcher.group(0), matcher.group(1)));
        }
    }
}
