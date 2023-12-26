package com.dp.util;

public class  StringUtil {


    public static boolean isNotNull(String str){

        if (str != null && !str.equals("")) {
            return true;
        }
        return false;
    }


    public static boolean isNull(String... params) {
        if (params == null || params.length <= 0) {
            return true;
        }

        for (String str : params) {
            if (str == null || str.equals("")) {
                return true;
            }
        }
        return false;
    }


}
