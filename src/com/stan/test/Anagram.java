package com.stan.test;

import java.util.*;

/**
 * 两个字符串是变位词
 *
 * Created by StanWang on 16/3/1.
 */
public class Anagram {


    /**
     * @param s: The first string
     * @param t: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {

        if(s == null && t==null){
            return true;
        }

        if(s == null || t == null){
            return false;
        }


        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(int i = 0;i< s.length();i++){
            list1.add((int) s.charAt(i));
        }

        for(int i = 0;i< t.length();i++){
            list2.add((int) t.charAt(i));
        }

        Collections.sort(list1);
        Collections.sort(list2);

        return list1.toString().equals(list2.toString());


    }
}
