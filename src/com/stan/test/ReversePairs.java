package com.stan.test;

/**
 * 在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。给你一个数组，求出这个数组中逆序对的总数。
 * 概括：如果a[i] > a[j] 且 i < j， a[i] 和 a[j] 构成一个逆序对。
 *
 * @author StanWang
 * @date 2016/5/25
 */
public class ReversePairs {

    /**
     * 思路 :  遍历数组，比较当前元素和前面所有元素，逆序则计数器+1
     */
    public long reversePairs(int[] A) {

        long count = 0;

        if (A.length < 2) return count;

        //第一个元素无需比较故略过
        for (int i = 1; i < A.length; i++) {

            for (int j = 0; j < i; j++) {
                if (A[j] > A[i]) {
                    count++;
                }
            }

        }

        return count;
    }
}
