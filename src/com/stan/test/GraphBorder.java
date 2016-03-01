package com.stan.test;

import java.util.*;

/**
 * 整体边界问题  TODO WRONG!!!!
 * <p/>
 * Created by Administrator on 2016/2/29.
 */
public class GraphBorder {

    public static void main(String[] args) {

        int inArray[][] = {{1, 5, 4}, {2, 6, 2}, {3, 4, 5}};

//        int inArray[][] = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};

        List<int[]> outArray = getCommonBorder(inArray);

        printListArray(outArray);

    }

    private static void printListArray(List<int[]> outArray) {
        for (int[] o : outArray) {
            for (int i = 0; i < o.length; i++) {
                System.out.print(o[i] + "\t");
            }
            System.out.println();
        }
    }


    /***
     * 解题思路：获取整体边界即 X轴单位下的最大值 Height 所组成的图形边界
     */
    public static List<int[]> getCommonBorder(int[][] in) {

        Map<Integer, Integer> resualtMap = new TreeMap<>();

        // X轴最大值
        int x_max = 0;

        for (int[] anIn : in) {

            int right = anIn[0];
            int left = anIn[1];
            int height = anIn[2];

            for (int index = right; index <= left; index++) {

                if (index > x_max) {
                    x_max = index;
                }

                if (!resualtMap.containsKey(index)) {
                    resualtMap.put(index, height);
                    continue;
                }

                if ((resualtMap.get(index) < height)) {
                    resualtMap.put(index, height);
                }
            }

        }


        System.out.println(resualtMap);

        int start = 0, end = 0, h = 0;
        List<int[]> resualt = new ArrayList<>();

        for (int i = 0; i <= x_max; i++) {

            if(!resualtMap.containsKey(i)){
                if(start != 0){
                    resualt.add(new int[]{start,end,h});
                }
                start = 0; end = 0; h = 0;
                continue;
            }

            int height = resualtMap.get(i);

            if(start == 0){
                start = i;
                h = height;
            }

            if(h == height){
                end = i;
                continue;
            }

            if(h < height){
                end = i;
                resualt.add(new int[]{start,end,h});
                start = i;
                end = i;
                h=height;
            }else{
                resualt.add(new int[]{start,end,h});
                start = i - 1;
                end = i;
                h=height;
            }

        }

        resualt.add(new int[]{start,end,h});


        return resualt;
    }
}



