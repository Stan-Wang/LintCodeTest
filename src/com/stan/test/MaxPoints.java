package com.stan.test;

import java.util.HashMap;

/**
 * 给出二维平面上的n个点，求最多有多少点在同一条直线上。
 * <p>
 * Created by Stan on 2016/3/3.
 */
public class MaxPoints {

    public int maxPoints(Point[] points) {

        if (points == null || points.length == 0) {
            return 0;
        }

        HashMap<Double, Integer> map= new HashMap<>();

        //至少有一个点
        int max = 1;

        for(int i = 0 ; i < points.length; i++) {

            map.clear();

            map.put((double)Integer.MIN_VALUE, 1);

            int dup = 0;
            for(int j = i + 1; j < points.length; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    dup++;
                    continue;
                }

                double key=points[j].x - points[i].x == 0 ?
                        Integer.MAX_VALUE :
                        0.0 + (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);

                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 2);
                }
            }

            for (int temp: map.values()) {
                if (temp + dup > max) {
                    max = temp + dup;
                }
            }

        }
        return max;
    }


}

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}