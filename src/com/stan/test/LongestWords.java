package com.stan.test;

import java.util.*;

/**
 * 给一个词典，找出其中所有最长的单词。
 *
 * Created by StanWang on 2016/3/5.
 */
public class LongestWords {

    ArrayList<String> longestWords(String[] dictionary) {


        if(dictionary == null || dictionary.length == 0){
            return new ArrayList<>();
        }

        int MaxCount = 0;

        Map<Integer,ArrayList<String>> map = new HashMap<>();



        for(String s : dictionary){

            int l = s.length();

            if(l > MaxCount){
                MaxCount = l;
            }

            if(map.containsKey(l)){
                map.get(l).add(s);
            }else{
                map.put(l,new ArrayList<>(Collections.singletonList(s)));
            }
        }

        return map.get(MaxCount);

    }
}
