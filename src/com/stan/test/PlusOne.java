package com.stan.test;

import java.util.Arrays;

/**
 * 给定一个非负数，表示一个数字数组，在该数的基础上+1，返回一个新的数组。
 * <p>
 * 该数字按照大小进行排列，最大的数在列表的最前面。
 * <p>
 * 给定 [1,2,3] 表示 123, 返回 [1,2,4].
 * <p>
 * 给定 [9,9,9] 表示 999, 返回 [1,0,0,0].
 * <p>
 * Created by xdja on 2016/3/3.
 */
public class PlusOne {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[] {1,2,3})));
        System.out.println(Arrays.toString(plusOne(new int[] {9,9,9})));
    }

    public static int[] plusOne(int[] digits) {

        if (digits.length == 0) {
            return digits;
        }

        boolean isAdd = false;

        for (int i = digits.length -1; i >= 0; i--) {

            int nu ;

            if(i == digits.length -1){
                nu = digits[i] + 1;
            }else{
                nu = digits[i];
            }


            if (isAdd) {
                nu++;
                isAdd = false;
            }


            if (nu == 10) {
                digits[i] = 0;
                isAdd = true;
            }else {
                digits[i] = nu;
            }
        }

        if (isAdd) {
            int[] addon = new int[digits.length + 1];
            addon[0] = 1;
            System.arraycopy(digits, 0, addon, 1, digits.length);

            return addon;
        } else {
            return digits;
        }

    }

}
