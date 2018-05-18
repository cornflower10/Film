package com.jiangpw.utils;

import java.util.UUID;

public class CommonUtils {
    /**
     * 生成去'-'的UUID
     *
     * @return	UUID
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
