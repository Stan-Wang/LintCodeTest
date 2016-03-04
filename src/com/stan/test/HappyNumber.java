package com.stan.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个数是不是快乐是这么定义的：对于一个正整数，每一次将该数替换为他每个位置上的数字的平方和，然后重复这个过程直到这个数变为1，或是无限循环但始终变不到1。如果可以变为1，那么这个数就是快乐数。
 *
 * Created by Stan on 2016/3/4.
 */
public class HappyNumber {

    private List<Integer> temp = new ArrayList<Integer>();

    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        String s = String.valueOf(n);

        int number = 0;

        for (int i = 0; i < s.length(); i++) {
            int m = Integer.valueOf(String.valueOf(s.charAt(i)));
            number = number + getSqrt(m);
        }

        if(number == 1) return true;

        if(temp.contains(number)){
            return false;
        }else{
            temp.add(number);
        }

        return isHappy(number);
    }

    private static int getSqrt(int i) {
        return i * i;
    }
}
