package com.stan.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给出飞机的起飞和降落时间的列表，用 interval 序列表示. 请计算出天上同时最多有多少架飞机？
 * <p/>
 * 如果多架飞机降落和起飞在同一时刻，我们认为降落有优先权。 即 [start,end)
 * <p/>
 * Created by StanWang on 16/3/6.
 */
public class CountOfAirplanes {

    public int countOfAirplanes(List<Interval> airplanes) {

        if(airplanes == null || airplanes.size() == 0){
            return 0;
        }

        Map<Integer, Integer> count = new HashMap<>();

        for (Interval plane : airplanes) {
            for (Integer i = plane.start; i < plane.end; i++) {
                if (count.containsKey(i)) {
                    count.put(i, count.get(i) + 1);
                } else {
                    count.put(i, 1);
                }
            }
        }

        int max = 1;

        for (int i : count.values()) {
            if (max < i) {
                max = i;
            }
        }

        return max;

    }
}

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}