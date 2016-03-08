package com.stan.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定 n 对括号，请写一个函数以将其生成新的括号组合，并返回所有组合结果。
 * <p>
 * Created by Stan on 2016/3/8.
 */
public class GenerateParenthesis {

    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ls = new ArrayList<>();
        if (n <= 0)
            return ls;
        Gen(n, n, "", ls);

        return ls;
    }

    public static void Gen(int l, int r, String s, List<String> ls) {
        if (r < l)
            return;
        if (l == 0 && r == 0)
            ls.add(s);
        if (l > 0)
            Gen(l - 1, r, s + '(', ls);
        if (r > 0)
            Gen(l, r - 1, s + ')', ls);
    }
}
