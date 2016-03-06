package com.stan.test;

import java.util.ArrayList;

/**
 * 给一个由数字组成的字符串。求出其可能恢复为的所有IP地址。
 *
 * Created by StanWang on 16/3/6.
 */
public class RestoreIpAddresses {

    public ArrayList<String> restoreIpAddresses(String s) {

        ArrayList<String> result = new ArrayList<>();

        //当传入字符串长度小于四或大于十二,无法组成合法IP  0.0.0.0 ~ 111.111.111.111
        if(s.length() < 4 || s.length() > 12){
            return result;
        }

        //如果传入字符长度仅有四位即只存在一种组合
        if(s.length() == 4){
            StringBuffer sb = new StringBuffer();

            for(int i = 0 ; i < s.length() ; i++){
                sb.append(s.charAt(i)).append(".");
            }

            sb.deleteCharAt(sb.length() - 1);

            result.add(sb.toString());
            return result;
        }


        //递归过滤不合法数据
        filter(result, new ArrayList<String>(), s , 0);

        return result;

    }

    public void filter(ArrayList<String> result, ArrayList<String> list, String s, int start){
        if(list.size() == 4){
            if(start != s.length())
                return;

            StringBuffer sb = new StringBuffer();
            for(String tmp: list){
                sb.append(tmp);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return;
        }

        for(int i=start; i<s.length() && i<= start+3; i++){
            String tmp = s.substring(start, i+1);
            if(ok(tmp)){
                list.add(tmp);
                filter(result, list, s, i+1);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean ok(String s){
        if(s.charAt(0) == '0')
            return s.equals("0");
        int digit = Integer.valueOf(s);
        return digit >= 0 && digit <= 255;
    }


}
