package com.stan.test;

/**
 * 字符串查找
 * <p/>
 * 对于一个给定的 source 字符串和一个 target 字符串，你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。
 * <p/>
 * Created by StanWang on 16/3/1.
 */
public class FindStr {

    public int strStr(String source, String target) {

        int pos = -1;

        if (source == null || target == null) {
            return pos;
        }

        if (target.length() == 0) {
            return 0;
        }

        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target.charAt(0)) {
                pos = i;
                for (int j = 1; j < target.length(); j++) {
                    if(source.charAt(i+j) != target.charAt(j)){
                        pos = -1;
                    }
                }

                if(pos != -1){
                    return pos;
                }
            }
        }

        return pos;
    }

}
